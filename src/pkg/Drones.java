package pkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import EXPORTSTATS.EXPORTSTATS;
import EXPORTSTATS.Stats;

public enum Drones {
    Bomb_Bear(2000, 240,40, "bear"), Chain_Bomber(2500,220,257, "chain"), Midas(3000, 200,100, "midas"),
    Frogger(3500, 180,54, "frogger"), Veinseeker(4000, 160,166, "veinseeker"), Starburst(4500, 140,60, "starburst"),
    Elixir(5000, 210,45, "elixir"), Void(5500, 180,157, "void"), 
    Angler(22500, 120,42, "angler"), Prism(255000, 70,50, "prism"), Minotaur(765000, 65,45, "minotaur");

    public final int base;
    public final int depletion;
    public final int maxGrade;
    public int grade = -1;
    public final String smallName;


    Drones(int base, int depletion, int maxGrade, String smallName) {
        this.base = base;
        this.depletion = depletion;
        this.maxGrade = maxGrade;
        this.smallName = smallName;
        if(EXPORTSTATS.r == null) return;
        grade = (int) Double.parseDouble(EXPORTSTATS.getRaw(Stats.valueOf(smallName+"_fuel_grade")).toString());
    }

    public static int lootbugSpeed(boolean fueledBear) {
        int minutes = 20 * 60;
        float based = Float.parseFloat(EXPORTSTATS.getRaw(Stats.lootbug_spawn_rate).toString());//8.676
        float multiplier = 1.30f + Drones.Bomb_Bear.grade * 0.03f;

        boolean wasAppliedInStats = Boolean.TRUE.equals(Stats.is_drone_bear_equipped_and_fueled.value);

        if (wasAppliedInStats) {
            based /= multiplier;//3.6919277999999998
        }

        if (fueledBear) {
            based *= multiplier;//8.676
        }

        return (int) (minutes / based);
    }

    public static double veinChance(int veinseek, boolean doublevein, int zone) {
        double based = Float.parseFloat(EXPORTSTATS.getRaw(Stats.vein_spawn_rate_multi).toString());//8.676
        based *= 1.0+veinseek/100.0;
        if (doublevein)
            based *= 2;

        return (double) (based / (chance_vein(zone)*EXPORTSTATS.getRawInt(Stats.ores_per_screen)));
    }

    private static int chance_vein(int zone){
        List<Integer> ar = new ArrayList<Integer>(Arrays.asList(15,20,25,30,35,40,//W1
                                                                                    50,//W2
                                                                                    70,//W3
                                                                                100));//W4
        return ar.get(zone);
    }

    public static int lootbugSpeedGoldenLantern(boolean fueledBear, boolean golden){
        int minutes = 20*60;
        float based = Float.parseFloat(EXPORTSTATS.getRaw(Stats.lootbug_spawn_rate).toString());

        float multiplier = 1.30f + Drones.Bomb_Bear.grade * 0.03f;

        boolean wasAppliedInStats = Boolean.TRUE.equals(Stats.is_drone_bear_equipped_and_fueled.value);

        if (wasAppliedInStats) {
            based /= multiplier;
        }

        if (fueledBear) {
            based *= multiplier; 
        }
        if(golden) based*=6;
        else based *= 3;
        return (int) (minutes/based);
    }

    public String getSmall(){
        return smallName;
    }

    public boolean isMaxGrade() {
        return grade >= maxGrade;
    }

    public int getBase() {
        return base;
    }

    public int getDepletion() {
        return depletion;
    }

    public int getGrade(int x){
        return x*base;
    }

    public long getUntilGrade(int currentGrade, int expectedGrade) {
        expectedGrade = Math.min(expectedGrade, maxGrade);
        if (expectedGrade <= currentGrade) return 0;

        // Formule directe sans boucle : base * ((y*(y+1) - x*(x+1)) / 2)
        long yTerms = (long) expectedGrade * (expectedGrade + 1);
        long xTerms = (long) currentGrade * (currentGrade + 1);
        
        return base * (yTerms - xTerms) / 2;
    }

    public int getFuelDurationAtGrade(int grade, double fuelMulti){
        double durationPerFuel = depletion * (1 + grade * 0.05);
        durationPerFuel *= fuelMulti;
        return (int) durationPerFuel;
    }

    public int getFuelDurationAtGrade(int grade){
        return getFuelDurationAtGrade(grade, Double.parseDouble(EXPORTSTATS.getRaw(Stats.coal_fuel_duration_multi).toString()));
            //Double.parseDouble(EXPORTSTATS.getRaw(Stats.coal_fuel_duration_multi)));
    }

    public int durationUntilGrade(int x, int y, boolean prefueled) {
        y = Math.min(y, maxGrade);
        if (y <= x) return 0;

        double fuelMulti = (Double) Double.parseDouble(EXPORTSTATS.getRaw(Stats.coal_fuel_duration_multi).toString()); // lu UNE seule fois

        if (!prefueled) {
            int totalFuelDuration = 0;
            for (int i = x; i < y; i++) {
                totalFuelDuration += getFuelDurationAtGrade(i, fuelMulti);
            }
            return totalFuelDuration;
        } else {
            long totalXpNeeded = getUntilGrade(x, y);
            double droneExpMulti = Double.parseDouble(EXPORTSTATS.getRaw(Stats.coal_drone_exp_multi).toString()); // lu UNE seule fois
            double durationPerFuelAtX = getFuelDurationAtGrade(x, fuelMulti);
            double unitsOfFuelNeeded = totalXpNeeded / (durationPerFuelAtX * droneExpMulti);
            return (int) Math.ceil(unitsOfFuelNeeded * durationPerFuelAtX);
        }
    }
}
