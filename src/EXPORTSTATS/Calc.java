package EXPORTSTATS;

import adeko.FM.LanguageManage;
import adeko.deko.Restore;
import adeko.types.Voidable;
import pkg.Drones;
import pkg.Pickaxe;

public enum Calc {

    //NEVER CALL A CALC IN AN INITIALISATOR! THIS IS FORBIDDEN MAGIC! 
    //                                                   - An old man

    Obelisk(CalcTag.Pickaxe, true),
    is_tutorial_done(CalcTag.Pickaxe, Pickaxe.obelisk==-1),
    world(CalcTag.Pickaxe, true),

    true_galactic_floor(CalcTag.Floors, (double) EXPORTSTATS.getRaw(Stats.galactic_floor_chance) != 0.0),
    true_prismatic_floor(CalcTag.Floors, (double) EXPORTSTATS.getRaw(Stats.prismatic_floor_chance) != 0.0),

    true_galactic_floor_multi(CalcTag.Floors, (Double) EXPORTSTATS.getRaw(Stats.galactic_floor_chance) != 0.0),
    true_prismatic_floor_multi(CalcTag.Floors, (Double) EXPORTSTATS.getRaw(Stats.prismatic_floor_chance) != 0.0),

    true_golden_floor_multi(CalcTag.Floors, (Double) EXPORTSTATS.getRaw(Stats.golden_floor_chance) != 0.0),
    true_golden_rainbow_floor_multi(CalcTag.Floors, (Double) EXPORTSTATS.getRaw(Stats.golden_floor_chance) != 0.0 && (Double) EXPORTSTATS.getRaw(Stats.rainbow_floor_chance) != 0.0),
    true_golden_galactic_floor_multi(CalcTag.Floors, (Double) EXPORTSTATS.getRaw(Stats.golden_floor_chance) != 0.0 && (Double) EXPORTSTATS.getRaw(Stats.galactic_floor_chance) != 0.0),
    true_golden_prismatic_floor_multi(CalcTag.Floors, (Double) EXPORTSTATS.getRaw(Stats.golden_floor_chance) != 0.0 && (Double) EXPORTSTATS.getRaw(Stats.prismatic_floor_chance) != 0.0),

    zone1_veinseeker(CalcTag.Veins, Drones.Veinseeker.grade != 0),
    zone1_vein(CalcTag.Veins, true),
    zone2_veinseeker(CalcTag.Veins, Drones.Veinseeker.grade != 0),
    zone2_vein(CalcTag.Veins, true),
    zone3_veinseeker(CalcTag.Veins, Drones.Veinseeker.grade != 0),
    zone3_vein(CalcTag.Veins, true),
    zone4_veinseeker(CalcTag.Veins, Drones.Veinseeker.grade != 0),
    zone4_vein(CalcTag.Veins, true),
    zone5_veinseeker(CalcTag.Veins, Drones.Veinseeker.grade != 0),
    zone5_vein(CalcTag.Veins, true),
    zone6_veinseeker(CalcTag.Veins, Drones.Veinseeker.grade != 0),
    zone6_vein(CalcTag.Veins, true),
    world2_veinseeker(CalcTag.Veins, Drones.Veinseeker.grade != 0 && Pickaxe.getWorld()>=2),
    world2_vein(CalcTag.Veins, Pickaxe.getWorld()>=2),
    world3_veinseeker(CalcTag.Veins, Drones.Veinseeker.grade != 0 && Pickaxe.getWorld()>=3),
    world3_vein(CalcTag.Veins, Pickaxe.getWorld()>=3),
    world4_veinseeker(CalcTag.Veins, Drones.Veinseeker.grade != 0 && Pickaxe.getWorld()>=4),
    world4_vein(CalcTag.Veins, Pickaxe.getWorld()>=4),

    zone1_veinseeker_double(CalcTag.Veins, Drones.Veinseeker.grade != 0),
    zone1_vein_double(CalcTag.Veins, true),
    zone2_veinseeker_double(CalcTag.Veins, Drones.Veinseeker.grade != 0),
    zone2_vein_double(CalcTag.Veins, true),
    zone3_veinseeker_double(CalcTag.Veins, Drones.Veinseeker.grade != 0),
    zone3_vein_double(CalcTag.Veins, true),
    zone4_veinseeker_double(CalcTag.Veins, Drones.Veinseeker.grade != 0),
    zone4_vein_double(CalcTag.Veins, true),
    zone5_veinseeker_double(CalcTag.Veins, Drones.Veinseeker.grade != 0),
    zone5_vein_double(CalcTag.Veins, true),
    zone6_veinseeker_double(CalcTag.Veins, Drones.Veinseeker.grade != 0),
    zone6_vein_double(CalcTag.Veins, true),

    world2_veinseeker_double(CalcTag.Veins, Drones.Veinseeker.grade != 0 && Pickaxe.getWorld()>=2),
    world2_vein_double(CalcTag.Veins, Pickaxe.getWorld()>=2),
    world3_veinseeker_double(CalcTag.Veins, Drones.Veinseeker.grade != 0 && Pickaxe.getWorld()>=3),
    world3_vein_double(CalcTag.Veins, Pickaxe.getWorld()>=3),
    world4_veinseeker_double(CalcTag.Veins, Drones.Veinseeker.grade != 0 && Pickaxe.getWorld()>=4),
    world4_vein_double(CalcTag.Veins, Pickaxe.getWorld()>=4),

    true_golden_vein_multi(CalcTag.Veins, ((Double) EXPORTSTATS.getRaw(Stats.golden_vein_chance)) != 0),
    true_rainbow_vein_multi(CalcTag.Veins, ((Double) EXPORTSTATS.getRaw(Stats.rainbow_vein_chance)) != 0),
    true_rainbow_vein(CalcTag.Veins, ((Double) EXPORTSTATS.getRaw(Stats.rainbow_vein_chance)) != 0),
    true_gleaming_golden_vein_multi(CalcTag.Veins, ((Double) EXPORTSTATS.getRaw(Stats.golden_vein_chance)) != 0 && ((Double) EXPORTSTATS.getRaw(Stats.gleaming_vein_chance)) != 0),
    true_gleaming_rainbow_vein_multi(CalcTag.Veins, ((Double) EXPORTSTATS.getRaw(Stats.rainbow_vein_chance)) != 0 && ((Double) EXPORTSTATS.getRaw(Stats.gleaming_vein_chance)) != 0),

    lootbugsAlone(CalcTag.Lootbugs, true),
    lootbugsWithBear(CalcTag.Lootbugs, true),
    lootbugsWithBearAndLantern(CalcTag.Lootbugs, (int) EXPORTSTATS.getRawInt(Stats.lootfrogs_caught) > 0),
    lootbugsWithLantern(CalcTag.Lootbugs, (int) EXPORTSTATS.getRawInt(Stats.lootfrogs_caught) > 0),
    lootbugsWithGoldenLantern(CalcTag.Lootbugs, (int) EXPORTSTATS.getRawInt(Stats.lootfrog_lanterns_used) > 25),
    lootbugsWithGoldenLanternAndBear(CalcTag.Lootbugs, (int) EXPORTSTATS.getRawInt(Stats.lootfrog_lanterns_used) > 25),

    true_big_golden_lootfrogs(CalcTag.Lootfrogs, (Double) EXPORTSTATS.getRaw(Stats.lootfrog_big_chance) > 0 && (Double) EXPORTSTATS.getRaw(Stats.lootfrog_golden_chance) > 0.0),
    true_big_golden_lootfrogs_multi(CalcTag.Lootfrogs, (Double) EXPORTSTATS.getRaw(Stats.lootfrog_big_chance) > 0 && (Double) EXPORTSTATS.getRaw(Stats.lootfrog_golden_chance) > 0.0),

    true_massive_lootfrogs(CalcTag.Lootfrogs, (Double) EXPORTSTATS.getRaw(Stats.lootfrog_massive_chance) > 0),
    true_massive_lootfrogs_multi(CalcTag.Lootfrogs, (Double) EXPORTSTATS.getRaw(Stats.lootfrog_massive_chance) > 0),

    true_massive_golden_lootfrogs(CalcTag.Lootfrogs, (Double) EXPORTSTATS.getRaw(Stats.lootfrog_massive_chance) > 0 && (Double) EXPORTSTATS.getRaw(Stats.lootfrog_golden_chance) > 0.0),
    true_massive_golden_lootfrogs_multi(CalcTag.Lootfrogs, (Double) EXPORTSTATS.getRaw(Stats.lootfrog_massive_chance) > 0 && (Double) EXPORTSTATS.getRaw(Stats.lootfrog_golden_chance) > 0.0),
    medium_additional_lootfrogs(CalcTag.Lootfrogs, (Double) EXPORTSTATS.getRaw(Stats.lootfrog_10x_spawn_chance) > 0.0 || (Double) EXPORTSTATS.getRaw(Stats.lootfrog_triple_spawn_chance) > 0.0),

    true_pickaxe_damage(CalcTag.Pickaxe, Pickaxe.obelisk>=18),
    bear_duration_until_max(CalcTag.Bomb_Bear, !Drones.Bomb_Bear.isMaxGrade()&& Pickaxe.obelisk>=18), 
    bear_duration(CalcTag.Bomb_Bear, Pickaxe.obelisk>=18),
    bear_experience_until_max(CalcTag.Bomb_Bear, !Drones.Bomb_Bear.isMaxGrade()&& Pickaxe.obelisk>=18),
    chain_duration_until_max(CalcTag.Chain_Bomber, !Drones.Chain_Bomber.isMaxGrade()&& Pickaxe.obelisk>=18),
    chain_duration(CalcTag.Chain_Bomber, Pickaxe.obelisk>=18),
    chain_experience_until_max(CalcTag.Chain_Bomber, !Drones.Chain_Bomber.isMaxGrade()&& Pickaxe.obelisk>=18),
    midas_duration_until_max(CalcTag.Midas, !Drones.Midas.isMaxGrade()&& Pickaxe.obelisk>=18),
    midas_duration(CalcTag.Midas, Pickaxe.obelisk>=18),
    midas_experience_until_max(CalcTag.Midas, !Drones.Midas.isMaxGrade()&& Pickaxe.obelisk>=18),
    frogger_duration_until_max(CalcTag.Frogger, !Drones.Frogger.isMaxGrade()&& Pickaxe.obelisk>=18),
    frogger_duration(CalcTag.Frogger, Pickaxe.obelisk>=18),
    frogger_experience_until_max(CalcTag.Frogger, !Drones.Frogger.isMaxGrade()&& Pickaxe.obelisk>=18),
    veinseeker_duration_until_max(CalcTag.Veinseeker, !Drones.Veinseeker.isMaxGrade()&& Pickaxe.obelisk>=18),
    veinseeker_duration(CalcTag.Veinseeker, Pickaxe.obelisk>=18), 
    veinseeker_experience_until_max(CalcTag.Veinseeker, !Drones.Veinseeker.isMaxGrade()&& Pickaxe.obelisk>=18),
    starburst_duration_until_max(CalcTag.Starburst, !Drones.Starburst.isMaxGrade()&& Pickaxe.obelisk>=18),
    starburst_duration(CalcTag.Starburst, Pickaxe.obelisk>=18),
    starburst_experience_until_max(CalcTag.Starburst, !Drones.Starburst.isMaxGrade()&& Pickaxe.obelisk>=18),
    elixir_duration_until_max(CalcTag.Elixir, !Drones.Elixir.isMaxGrade()&& Pickaxe.obelisk>=18),
    elixir_duration(CalcTag.Elixir,  Pickaxe.obelisk>=18),
    elixir_experience_until_max(CalcTag.Elixir, !Drones.Elixir.isMaxGrade()&& Pickaxe.obelisk>=18),
    void_duration_until_max(CalcTag.Void, !Drones.Void.isMaxGrade()&& Pickaxe.obelisk>=18),
    void_duration(CalcTag.Void, Pickaxe.obelisk>=18),
    void_experience_until_max(CalcTag.Void, !Drones.Void.isMaxGrade()&& Pickaxe.obelisk>=18),
    angler_duration_until_max(CalcTag.Angler, !Drones.Angler.isMaxGrade()),
    angler_duration(CalcTag.Angler, true),
    angler_experience_until_max(CalcTag.Angler, !Drones.Angler.isMaxGrade()),
    prism_duration_until_max(CalcTag.Prism, !Drones.Prism.isMaxGrade()),
    prism_duration(CalcTag.Prism, true),
    prism_experience_until_max(CalcTag.Prism, !Drones.Prism.isMaxGrade()),
    minotaur_duration_until_max(CalcTag.Minotaur, !Drones.Minotaur.isMaxGrade()),
    minotaur_duration(CalcTag.Minotaur, true),
    minotaur_experience_until_max(CalcTag.Minotaur, !Drones.Minotaur.isMaxGrade()),

    void_portal_perma(CalcTag.Void, true),

    star_chance_per_floor(CalcTag.Star, true),
    radiant_supernova_supergiant_star(CalcTag.Star, (Double) EXPORTSTATS.getRaw(Stats.star_radiant_chance) > 0.0),

    DC13_challenge_floor(CalcTag.Star, (Double) EXPORTSTATS.getRaw(Stats.star_radiant_chance) > 0.0 && Pickaxe.getWorld()>=4),
    
    true_golden_void_portal(CalcTag.Void,(Double) EXPORTSTATS.getRaw(Stats.golden_void_portal_chance) > 0.0),
    true_rainbow_void_portal(CalcTag.Void, (Double) EXPORTSTATS.getRaw(Stats.rainbow_void_portal_chance) > 0.0),
    true_galactic_void_portal(CalcTag.Void, (Double) EXPORTSTATS.getRaw(Stats.galactic_void_portal_chance) > 0.0),

    true_golden_void_portal_multi(CalcTag.Void, (Double) EXPORTSTATS.getRaw(Stats.golden_void_portal_chance) > 0.0),
    true_rainbow_void_portal_multi(CalcTag.Void, (Double) EXPORTSTATS.getRaw(Stats.rainbow_void_portal_chance) > 0.0),
    true_galactic_void_portal_multi(CalcTag.Void, (Double) EXPORTSTATS.getRaw(Stats.galactic_void_portal_chance) > 0.0),

    rainbow_veins_rainbow_portal_rainbow_floor(CalcTag.Floors, (Double) EXPORTSTATS.getRaw(Stats.rainbow_void_portal_chance) > 0.0),
    
    true_super_stonks(CalcTag.Stonks, (Double) EXPORTSTATS.getRaw(Stats.super_stonks_chance) > 0.0),
    true_ultra_stonks(CalcTag.Stonks, (Double) EXPORTSTATS.getRaw(Stats.ultra_stonks_chance) > 0.0),
    true_super_stonks_multi(CalcTag.Stonks, (Double) EXPORTSTATS.getRaw(Stats.super_stonks_chance) > 0.0),
    true_ultra_stonks_multi(CalcTag.Stonks, (Double) EXPORTSTATS.getRaw(Stats.ultra_stonks_chance) > 0.0),

    base_low_gems_gift_min(CalcTag.Gifts),
    base_low_gems_gift_max(CalcTag.Gifts),

    base_med_gems_gift_min(CalcTag.Gifts),
    base_med_gems_gift_max(CalcTag.Gifts),

    base_high_gems_gift_min(CalcTag.Gifts, Pickaxe.obelisk >= 60),
    base_high_gems_gift_max(CalcTag.Gifts, Pickaxe.obelisk >= 60),

    base_low_chest_gift_min(CalcTag.Gifts),
    base_low_chest_gift_max(CalcTag.Gifts),

    rare_gems_gift_min(CalcTag.Gifts),
    rare_gems_gift_max(CalcTag.Gifts),

    base_high_chest_gift_min(CalcTag.Gifts),
    base_high_chest_gift_max(CalcTag.Gifts),

    fuel_gift_min(CalcTag.Gifts),
    fuel_gift_max(CalcTag.Gifts),

    cherry_charge_gift_min(CalcTag.Gifts, Pickaxe.getWorld()>=3),
    cherry_charge_gift_max(CalcTag.Gifts, Pickaxe.getWorld()>=3);


    public final CalcTag tag;
    public final boolean show;
    public Object item;
    public static final int ESTIMATED_AMOUNT = 130;

    Calc(CalcTag tag) {
        this(tag, true);
    }

    Calc(CalcTag tag, boolean show) {
        this.tag = tag;
        this.show = show;

        if(Voidable.of(EXPORTSTATS.getText(this)) == null){
            Restore r = new Restore(LanguageManage.p("calc"));
            if(r.exists()) {r.add(name(), name(),tag.toString()); r.add(name()+"_desc", "",tag.toString()); System.out.println("added localisation for Calc."+name());}
        }
    }

    public static void load(int x){
        EXPORTSTATS.calc = new Restore(EXPORTSTATS.exported+"/"+x+"_calc.bdeko");
    }

    public Object setAndStore(Object value) {
        this.item = value;
        return value;
    }

    private double getComputedValue(Calc calc) {
        Object value = EXPORTSTATS.getCalc(calc);
        if (value instanceof Number number) return number.doubleValue();
        return 0.0;
    }

    public static Object get(Calc calc){
        return EXPORTSTATS.getCalc(calc);
    }

    public Object calculate() {
        if(item != null) return item;
        double base = 0.0;
            if(name().startsWith("true_") && !name().equals("true_pickaxe_damage")) {
                

                if(name().endsWith("_vein")){//Assumed it is like Floors Multi (All Veins Included in; Not Gleaming?)
                    base = 1.0;
                    if(name().contains("gleaming_")) base *= (((Double) EXPORTSTATS.getRawDouble(Stats.gleaming_vein_chance))/100.0);
                    if(name().contains("golden_vein")) base *= (((Double) EXPORTSTATS.getRawDouble(Stats.golden_floor_chance))/100.0);
                    else if(name().contains("rainbow_vein")) base *= ((EXPORTSTATS.getRawDouble(Stats.golden_vein_chance))/100.0) * (EXPORTSTATS.getRawDouble(Stats.rainbow_vein_chance)/100.0);
                }

                if(name().endsWith("_vein_multi")){//Assumed it is like Floors Multi (All Veins Included in; Not Gleaming?)
                    base = 1;
                    if(name().contains("gleaming_")) base *= ((Double) EXPORTSTATS.getRaw(Stats.gleaming_vein_multi));
                    if(name().contains("golden_vein")) base *= ((Double) EXPORTSTATS.getRaw(Stats.golden_floor_multi));
                    else if(name().contains("rainbow_vein")) base *= getComputedValue(Calc.true_golden_vein_multi) * ((Double) EXPORTSTATS.getRaw(Stats.rainbow_vein_multi));
                    base /=100;
                }

                else if(name().endsWith("_floor")) {
                    if(name().equals("true_galactic_floor")) base = ((Double) EXPORTSTATS.getRaw(Stats.rainbow_floor_chance)) / 100.0 * ((Double) EXPORTSTATS.getRaw(Stats.galactic_floor_chance)) / 100.0;
                    else if(name().equals("true_prismatic_floor")) base = getComputedValue(Calc.true_galactic_floor) / 100.0 * ((Double) EXPORTSTATS.getRaw(Stats.prismatic_floor_chance)) / 100.0;
                }

                else if(name().endsWith("_floor_multi")) {
                    base = 1;
                    if(name().contains("_golden_")) base *= ((Double) EXPORTSTATS.getRaw(Stats.golden_floor_multi));
                    if(name().contains("rainbow_floor_multi")) base *= ((Double) EXPORTSTATS.getRaw(Stats.rainbow_floor_multi));
                    if(name().contains("galactic_floor_multi")) {
                        base *=  ((Double) EXPORTSTATS.getRaw(Stats.galactic_floor_multi));
                        base *= ((Double) EXPORTSTATS.getRaw(Stats.rainbow_floor_multi));
                    }
                    else if(name().contains("prismatic_floor_multi")) {
                        base *=  ((Double) EXPORTSTATS.getRaw(Stats.prismatic_floor_multi));
                        base *= getComputedValue(Calc.true_galactic_floor_multi);
                    }
                    base /=100;
                }

                else if(name().contains("void_portal")) {
                    if(name().equals("true_golden_void_portal")) base =  getComputedValue(Calc.void_portal_perma) * ((Double) EXPORTSTATS.getRaw(Stats.golden_void_portal_chance)) / 100.0;
                    else if(name().equals("true_rainbow_void_portal")) base = getComputedValue(Calc.true_golden_void_portal) / 100.0 * ((Double) EXPORTSTATS.getRaw(Stats.rainbow_void_portal_chance)) / 100.0;
                    else if(name().equals("true_galactic_void_portal")) base = getComputedValue(Calc.true_rainbow_void_portal) / 100.0 * ((Double) EXPORTSTATS.getRaw(Stats.galactic_void_portal_chance)) / 100.0;
                    
                    if(name().endsWith("_multi")){//Assumed it is like Floors Multi (All Void Portal Included in)
                        if(name().equals("true_golden_void_portal_multi")) base =  (((Double) EXPORTSTATS.getRaw(Stats.void_portal_base_multi))) * ((Double) EXPORTSTATS.getRaw(Stats.golden_void_portal_multi));
                        else if(name().equals("true_rainbow_void_portal_multi")) base = getComputedValue(Calc.true_golden_void_portal_multi) * ((Double) EXPORTSTATS.getRaw(Stats.rainbow_void_portal_multi));
                        else if(name().equals("true_galactic_void_portal_multi")) base = getComputedValue(Calc.true_rainbow_void_portal_multi) * ((Double) EXPORTSTATS.getRaw(Stats.galactic_void_portal_multi));
                        base /=100;
                    }
                }

                else if(name().endsWith("stonks")) {
                    if(this == Calc.true_super_stonks) base = ((Double) EXPORTSTATS.getRaw(Stats.super_stonks_chance)) / 100.0 * ((Double) EXPORTSTATS.getRaw(Stats.stonks_chance)) / 100.0;
                    if(this == Calc.true_ultra_stonks) base = ((Double) EXPORTSTATS.getRaw(Stats.ultra_stonks_chance)) / 100.0 * getComputedValue(Calc.true_super_stonks) / 100.0;
                }
                else if(name().endsWith("stonks_multi")) {
                    if(this == Calc.true_super_stonks_multi) base = ((Double) EXPORTSTATS.getRaw(Stats.super_stonks_multi)) * (Double) EXPORTSTATS.getRaw(Stats.stonks_multi);
                    if(this == Calc.true_ultra_stonks_multi) base = ((Double) EXPORTSTATS.getRaw(Stats.ultra_stonks_multi)) * getComputedValue(Calc.true_super_stonks_multi);
                    base/=100.0;
                }

                else if(name().endsWith("_lootfrogs")) {
                    if(name().equals("true_big_golden_lootfrogs")) base = ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_golden_chance)) / 100.0 * ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_big_chance)) / 100.0;
                    else if(name().equals("true_massive_lootfrogs")) base = ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_big_chance)) / 100.0 * ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_massive_chance)) / 100.0;
                    else if(name().equals("true_massive_golden_lootfrogs")) base = ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_golden_chance)) / 100.0 * getComputedValue(Calc.true_massive_lootfrogs) / 100.0;
                } else if(name().endsWith("_lootfrogs_multi")) {
                    if(name().equals("true_big_golden_lootfrogs_multi")) base = ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_golden_multi)) * ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_big_multi));
                    else if(name().equals("true_massive_lootfrogs_multi")) base = ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_big_multi)) * ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_massive_multi));
                    else if(name().equals("true_massive_golden_lootfrogs_multi")) base = ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_golden_multi)) * getComputedValue(Calc.true_massive_lootfrogs_multi) ;
                    base/=100.0;
                }

                return base*100;
            }

            if(this.name().startsWith("zone") && (this.name().contains("vein_") || name().endsWith("vein"))){
                return Drones.veinChance(0,name().endsWith("double"), Integer.parseInt(String.valueOf(this.name().charAt(4)))-1)*100;
            } else if (this.name().startsWith("zone") && this.name().contains("veinseeker")){
                return Drones.veinChance(40,name().endsWith("double"), Integer.parseInt(String.valueOf(this.name().charAt(4)))-1)*100;
            }

            if(this.name().startsWith("world") && (this.name().contains("vein_") || name().endsWith("vein"))){
                return Drones.veinChance(0,name().endsWith("double"), 4+Integer.parseInt(String.valueOf(this.name().charAt(5))))*100;
            } else if (this.name().startsWith("world") && this.name().contains("veinseeker")){
                return Drones.veinChance(40,name().endsWith("double"), 4+Integer.parseInt(String.valueOf(this.name().charAt(5))))*100;
            }

            if(this.name().startsWith("lootbugs")){
                switch(name()){
                    case "lootbugsAlone" -> {
                        return Drones.lootbugSpeed(false);
                    }
                    case "lootbugsWithBear" -> {
                        return Drones.lootbugSpeed(true);
                    }
                    case "lootbugsWithBearAndLantern" -> {
                        return Drones.lootbugSpeedGoldenLantern(true, false);
                    }
                    case "lootbugsWithLantern" -> {
                        return Drones.lootbugSpeedGoldenLantern(false, false);
                    }
                    case "lootbugsWithGoldenLantern" -> {
                        return Drones.lootbugSpeedGoldenLantern(false, true);
                    }
                    case "lootbugsWithGoldenLanternAndBear" -> {
                        return Drones.lootbugSpeedGoldenLantern(true, true);
                    }
                }
            }
            for(Drones drone: Drones.values()){
                if(this.name().startsWith(drone.smallName+"_") || this.name().startsWith(drone.name())){
                    int currentGrade = drone.grade;

                    // 1. XP NÉCESSAIRE jusqu'au max
                    if (this.name().contains("experience_until_max")) {
                        return drone.getUntilGrade(currentGrade, drone.maxGrade);
                    } 
                    
                    // 2. TEMPS (DURÉE) NÉCESSAIRE jusqu'au max (en secondes)
                    else if (this.name().contains("duration_until_max")) {
                        return drone.durationUntilGrade(currentGrade, drone.maxGrade, false);
                    } 
                    
                    // 3. DURÉE DE CARBURANT DU GRADE ACTUEL
                    else if (this.name().contains("duration")) {
                        return drone.getFuelDurationAtGrade(currentGrade);
                    }
                }
            }
            
        switch(this){
            default:
                System.out.println("Unknown calculation for: " + this.name());
                return null;
            case true_pickaxe_damage:
                return Pickaxe.trueDamage();
            case void_portal_perma:
                return (Double) EXPORTSTATS.getRaw(Stats.void_portal_chance) == 0.0?0.4:(Double) EXPORTSTATS.getRaw(Stats.void_portal_chance)/100.0;
            case medium_additional_lootfrogs:
                base = 0;
                base += (int) EXPORTSTATS.getRawInt(Stats.lootfrog_capacity)*(((Double) EXPORTSTATS.getRaw(Stats.lootfrog_triple_spawn_chance))/100.0)*2;
                base += (int) EXPORTSTATS.getRawInt(Stats.lootfrog_capacity)*(((Double) EXPORTSTATS.getRaw(Stats.lootfrog_10x_spawn_chance))/100.0)*9;
                return base;
            case radiant_supernova_supergiant_star:
                base = EXPORTSTATS.getRawDouble(Stats.star_supernova_chance)/100.0;
                base *= EXPORTSTATS.getRawDouble(Stats.star_supergiant_chance)/100.0;
                base *= EXPORTSTATS.getRawDouble(Stats.star_radiant_chance)/100.0;
                return base*100;
            case star_chance_per_floor:
                return (EXPORTSTATS.getRawDouble(Stats.star_spawn_rate)/50.0);
            case Obelisk:
                return Pickaxe.obelisk;
            case is_tutorial_done:
                return false;
            case world:
                return Pickaxe.getWorld();
            case DC13_challenge_floor:
                double chance = getComputedValue(Calc.radiant_supernova_supergiant_star) / 100.0;
                double floorChance = getComputedValue(Calc.star_chance_per_floor);
                return 12500 / (floorChance * chance);
            case base_low_chest_gift_min:
                return 3*(1+Pickaxe.obelisk*0.08);
            case base_low_chest_gift_max:
                return 5*(1+Pickaxe.obelisk*0.08);
            case base_high_chest_gift_min:
                return 5*(1+Pickaxe.obelisk*0.08);
            case base_high_chest_gift_max:
                return 10*(1+Pickaxe.obelisk*0.08);

            case base_low_gems_gift_max:
                return 40*(1+Pickaxe.obelisk*0.08);
            case base_med_gems_gift_min:
            case base_low_gems_gift_min:
                return 20*(1+Pickaxe.obelisk*0.08);
            case base_med_gems_gift_max:
                return 50*(1+Pickaxe.obelisk*0.08);
            case base_high_gems_gift_min:
                return 90*(1+Pickaxe.obelisk*0.08);
            case base_high_gems_gift_max:
                return 150*(1+Pickaxe.obelisk*0.08);
            case rare_gems_gift_min:
                return 80*(1+Pickaxe.obelisk*0.08);
            case rare_gems_gift_max:
                return 130*(1+Pickaxe.obelisk*0.08);
            case cherry_charge_gift_min:
                return 1500*((Pickaxe.obelisk-36)/6);
            case cherry_charge_gift_max:
                return 2750*((Pickaxe.obelisk-36)/6);  
            case fuel_gift_min:
                return 2*Math.max(18, Pickaxe.obelisk)-5;
            case fuel_gift_max:
                return 2*Math.max(18, Pickaxe.obelisk)+15;
            case rainbow_veins_rainbow_portal_rainbow_floor:
                return ((getComputedValue(Calc.true_rainbow_void_portal)/100.0) * (EXPORTSTATS.getRawDouble(Stats.rainbow_floor_chance)/100.0) * (getComputedValue(Calc.true_rainbow_vein)/100.0))*100;
            } 
            
    }
}
