package EXPORTSTATS;

import java.util.ArrayList;
import java.util.List;

import adeko.FM.LanguageManage;
import adeko.deko.Restore;
import adeko.types.Voidable;
import adeko.utils.Console;
import pkg.As;
import pkg.Drones;
import pkg.Pickaxe;

public enum Calc {

    Obelisk(CalcTag.Pickaxe,As.N),
    is_tutorial_done(CalcTag.Pickaxe,As.B),
    world(CalcTag.Pickaxe,As.N),

    true_galactic_floor(CalcTag.Floors,As.P),
    true_prismatic_floor(CalcTag.Floors,As.P),

    true_galactic_floor_multi(CalcTag.Floors,As.T),
    true_prismatic_floor_multi(CalcTag.Floors,As.T),

    true_golden_floor_multi(CalcTag.Floors,As.T),
    true_golden_rainbow_floor_multi(CalcTag.Floors,As.T),
    true_golden_galactic_floor_multi(CalcTag.Floors,As.T),
    true_golden_prismatic_floor_multi(CalcTag.Floors,As.T),

    zone1_veinseeker(CalcTag.Veins_Per_Zone,As.P),
    zone1_vein(CalcTag.Veins_Per_Zone,As.P),
    zone2_veinseeker(CalcTag.Veins_Per_Zone,As.P),
    zone2_vein(CalcTag.Veins_Per_Zone,As.P),
    zone3_veinseeker(CalcTag.Veins_Per_Zone,As.P),
    zone3_vein(CalcTag.Veins_Per_Zone,As.P),
    zone4_veinseeker(CalcTag.Veins_Per_Zone,As.P),
    zone4_vein(CalcTag.Veins_Per_Zone,As.P),
    zone5_veinseeker(CalcTag.Veins_Per_Zone,As.P),
    zone5_vein(CalcTag.Veins_Per_Zone,As.P),
    zone6_veinseeker(CalcTag.Veins_Per_Zone,As.P),
    zone6_vein(CalcTag.Veins_Per_Zone,As.P),
    world2_veinseeker(CalcTag.Veins_Per_Zone,As.P),
    world2_vein(CalcTag.Veins_Per_Zone,As.P),
    world3_veinseeker(CalcTag.Veins_Per_Zone,As.P),
    world3_vein(CalcTag.Veins_Per_Zone,As.P),
    world4_veinseeker(CalcTag.Veins_Per_Zone,As.P),
    world4_vein(CalcTag.Veins_Per_Zone,As.P),

    zone1_veinseeker_double(CalcTag.Veins_Per_Zone,As.P),
    zone1_vein_double(CalcTag.Veins_Per_Zone,As.P),
    zone2_veinseeker_double(CalcTag.Veins_Per_Zone,As.P),
    zone2_vein_double(CalcTag.Veins_Per_Zone,As.P),
    zone3_veinseeker_double(CalcTag.Veins_Per_Zone,As.P),
    zone3_vein_double(CalcTag.Veins_Per_Zone,As.P),
    zone4_veinseeker_double(CalcTag.Veins_Per_Zone,As.P),
    zone4_vein_double(CalcTag.Veins_Per_Zone,As.P),
    zone5_veinseeker_double(CalcTag.Veins_Per_Zone,As.P),
    zone5_vein_double(CalcTag.Veins_Per_Zone,As.P),
    zone6_veinseeker_double(CalcTag.Veins_Per_Zone,As.P),
    zone6_vein_double(CalcTag.Veins_Per_Zone,As.P),

    world2_veinseeker_double(CalcTag.Veins_Per_Zone,As.P),
    world2_vein_double(CalcTag.Veins_Per_Zone,As.P),
    world3_veinseeker_double(CalcTag.Veins_Per_Zone,As.P),
    world3_vein_double(CalcTag.Veins_Per_Zone,As.P),
    world4_veinseeker_double(CalcTag.Veins_Per_Zone,As.P),
    world4_vein_double(CalcTag.Veins_Per_Zone,As.P),

    true_golden_vein_multi(CalcTag.Veins_Multi,As.T),
    true_rainbow_vein_multi(CalcTag.Veins_Multi,As.T),
    true_rainbow_vein(CalcTag.Veins_Multi,As.P),
    true_gleaming_golden_vein_multi(CalcTag.Veins_Multi,As.T),
    true_gleaming_rainbow_vein_multi(CalcTag.Veins_Multi,As.T),

    lootbugsAlone(CalcTag.Lootbugs,As.S),
    lootbugsWithBear(CalcTag.Lootbugs,As.S),
    lootbugsWithBearAndLantern(CalcTag.Lootbugs,As.S),
    lootbugsWithLantern(CalcTag.Lootbugs,As.S),
    lootbugsWithGoldenLantern(CalcTag.Lootbugs,As.S),
    lootbugsWithGoldenLanternAndBear(CalcTag.Lootbugs,As.S),

    lootbugsAlone_cap(CalcTag.Lootbugs,As.S),
    lootbugsWithBear_cap(CalcTag.Lootbugs,As.S),
    lootbugsWithBearAndLantern_cap(CalcTag.Lootbugs,As.S),
    lootbugsWithLantern_cap(CalcTag.Lootbugs,As.S),
    lootbugsWithGoldenLantern_cap(CalcTag.Lootbugs,As.S),
    lootbugsWithGoldenLanternAndBear_cap(CalcTag.Lootbugs,As.S),

    true_big_golden_lootfrogs(CalcTag.Lootfrogs,As.P),
    true_big_golden_lootfrogs_multi(CalcTag.Lootfrogs,As.T),

    true_massive_lootfrogs(CalcTag.Lootfrogs,As.P),
    true_massive_lootfrogs_multi(CalcTag.Lootfrogs,As.T),

    true_massive_golden_lootfrogs(CalcTag.Lootfrogs,As.P),
    true_massive_golden_lootfrogs_multi(CalcTag.Lootfrogs,As.T),
    medium_additional_lootfrogs(CalcTag.Lootfrogs,As.N),

    true_pickaxe_damage(CalcTag.Pickaxe,As.N),
    bear_duration_until_max(CalcTag.Bomb_Bear,As.N), 
    bear_duration(CalcTag.Bomb_Bear,As.N),
    bear_experience_until_max(CalcTag.Bomb_Bear,As.N),
    bear_lootbug_speed_multi(CalcTag.Bomb_Bear,As.P),
    chain_duration_until_max(CalcTag.Chain_Bomber,As.N),
    chain_duration(CalcTag.Chain_Bomber,As.N),
    chain_experience_until_max(CalcTag.Chain_Bomber,As.N),
    midas_duration_until_max(CalcTag.Midas,As.N),
    midas_duration(CalcTag.Midas,As.N),
    midas_experience_until_max(CalcTag.Midas,As.N),
    frogger_duration_until_max(CalcTag.Frogger,As.N),
    frogger_duration(CalcTag.Frogger,As.N),
    frogger_experience_until_max(CalcTag.Frogger,As.N),
    veinseeker_duration_until_max(CalcTag.Veinseeker,As.N),
    veinseeker_duration(CalcTag.Veinseeker,As.N), 
    veinseeker_experience_until_max(CalcTag.Veinseeker,As.N),
    starburst_duration_until_max(CalcTag.Starburst,As.N),
    starburst_duration(CalcTag.Starburst,As.N),
    starburst_experience_until_max(CalcTag.Starburst,As.N),
    elixir_duration_until_max(CalcTag.Elixir,As.N),
    elixir_duration(CalcTag.Elixir,As.N),
    elixir_experience_until_max(CalcTag.Elixir,As.N),
    void_duration_until_max(CalcTag.Void,As.N),
    void_duration(CalcTag.Void,As.N),
    void_experience_until_max(CalcTag.Void,As.N),
    angler_duration_until_max(CalcTag.Angler,As.N),
    angler_duration(CalcTag.Angler,As.N),
    angler_experience_until_max(CalcTag.Angler,As.N),
    prism_duration_until_max(CalcTag.Prism,As.N),
    prism_duration(CalcTag.Prism,As.N),
    prism_experience_until_max(CalcTag.Prism,As.N),
    minotaur_duration_until_max(CalcTag.Minotaur,As.N),
    minotaur_duration(CalcTag.Minotaur,As.N),
    minotaur_experience_until_max(CalcTag.Minotaur,As.N),

    void_portal_perma(CalcTag.Void,As.P),

    star_chance_per_floor(CalcTag.Star,As.P),
    true_star_per_floor(CalcTag.Star, As.P),
    super_star_chance_per_floor(CalcTag.Star, As.P),
    true_super_star_per_floor(CalcTag.Star, As.T),
    radiant_supernova_supergiant_star(CalcTag.Star,As.P),

    DC13_challenge_floor(CalcTag.Star,As.N),
    DC13_challenge_time_off(CalcTag.Star,As.S),
    DC13_challenge_time_spoon(CalcTag.Star,As.S),
    
    true_golden_void_portal(CalcTag.Void,As.P),
    true_rainbow_void_portal(CalcTag.Void,As.P),
    true_galactic_void_portal(CalcTag.Void,As.P),

    true_golden_void_portal_multi(CalcTag.Void,As.T),
    true_rainbow_void_portal_multi(CalcTag.Void,As.T),
    true_galactic_void_portal_multi(CalcTag.Void,As.T),

    rainbow_veins_rainbow_portal_rainbow_floor(CalcTag.Floors,As.P),
    
    expected_stonks_on_max_cap(CalcTag.Stonks,As.N),
    expected_super_stonks_on_max_cap(CalcTag.Stonks,As.N),
    expected_ultra_stonks_on_max_cap(CalcTag.Stonks,As.N),
    true_super_stonks(CalcTag.Stonks,As.P),
    true_ultra_stonks(CalcTag.Stonks,As.P),
    true_super_stonks_multi(CalcTag.Stonks,As.P),
    true_ultra_stonks_multi(CalcTag.Stonks,As.P),

    base_low_gems_gift_min(CalcTag.Gifts,As.N),
    base_low_gems_gift_max(CalcTag.Gifts,As.N),

    base_med_gems_gift_min(CalcTag.Gifts,As.N),
    base_med_gems_gift_max(CalcTag.Gifts,As.N),

    base_high_gems_gift_min(CalcTag.Gifts,As.N),
    base_high_gems_gift_max(CalcTag.Gifts,As.N),

    base_low_chest_gift_min(CalcTag.Gifts,As.N),
    base_low_chest_gift_max(CalcTag.Gifts,As.N),

    rare_gems_gift_min(CalcTag.Gifts,As.N),
    rare_gems_gift_max(CalcTag.Gifts,As.N),

    base_high_chest_gift_min(CalcTag.Gifts,As.N),
    base_high_chest_gift_max(CalcTag.Gifts,As.N),

    fuel_gift_min(CalcTag.Gifts,As.N),
    fuel_gift_max(CalcTag.Gifts,As.N),

    cherry_charge_gift_min(CalcTag.Gifts,As.N),
    cherry_charge_gift_max(CalcTag.Gifts,As.N);


    public final CalcTag tag;
    public Object item;
    public final As as;

    Calc(CalcTag tag, As as) {
        this.tag = tag;
        this.as = as;

        if(tag.hasSub){ Console.print("<r>Illegal Sub Access for **"+this.name()+"**<>"); }

        if(Voidable.of(EXPORTSTATS.getText(this)) == null){
            Restore r = new Restore(LanguageManage.p("calc"));
            if(r.exists()) {r.add(name(), name(),tag.toString()); r.add(name()+"_desc", "",tag.toString()); System.out.println("added localisation for Calc."+name());}
        }
    }

    public static List<Calc> list(){
        List<Calc> ls = new ArrayList<>();
        for(Calc c : Calc.values()){
            if(c.show()) ls.add(c);
        }
        return ls;
    }

    public boolean show(){
        if(!tag.show) return false;
        return switch(this){
            case is_tutorial_done -> Pickaxe.obelisk==-1;
            case true_galactic_floor -> EXPORTSTATS.getRawDouble(Stats.galactic_floor_chance) != 0.0;
            case true_prismatic_floor -> EXPORTSTATS.getRawDouble(Stats.prismatic_floor_chance) != 0.0;
            case true_galactic_floor_multi -> EXPORTSTATS.getRawDouble(Stats.galactic_floor_chance) != 0.0;
            case true_prismatic_floor_multi -> EXPORTSTATS.getRawDouble(Stats.prismatic_floor_chance) != 0.0;
            case true_golden_floor_multi, true_golden_rainbow_floor_multi, true_golden_galactic_floor_multi, true_golden_prismatic_floor_multi -> EXPORTSTATS.getRawDouble(Stats.golden_floor_chance) != 0.0;

            case zone1_veinseeker, zone2_veinseeker, zone3_veinseeker, zone4_veinseeker, zone5_veinseeker, zone6_veinseeker,
                 zone1_veinseeker_double, zone2_veinseeker_double, zone3_veinseeker_double, zone4_veinseeker_double, zone5_veinseeker_double, zone6_veinseeker_double -> Drones.Veinseeker.grade != 0;

            case world2_veinseeker, world3_veinseeker, world4_veinseeker,
                 world2_veinseeker_double, world3_veinseeker_double, world4_veinseeker_double -> Drones.Veinseeker.grade != 0 && Pickaxe.getWorld() >= Integer.parseInt(this.name().substring(5,6));

            case world2_vein, world3_vein, world4_vein,
                 world2_vein_double, world3_vein_double, world4_vein_double -> Pickaxe.getWorld() >= Integer.parseInt(this.name().substring(5,6));

            case true_golden_vein_multi -> EXPORTSTATS.getRawDouble(Stats.golden_vein_chance) != 0.0;
            case true_rainbow_vein_multi, true_rainbow_vein -> EXPORTSTATS.getRawDouble(Stats.rainbow_vein_chance) != 0.0;
            case true_gleaming_golden_vein_multi -> EXPORTSTATS.getRawDouble(Stats.golden_vein_chance) != 0.0 && EXPORTSTATS.getRawDouble(Stats.gleaming_vein_chance) != 0.0;
            case true_gleaming_rainbow_vein_multi -> EXPORTSTATS.getRawDouble(Stats.rainbow_vein_chance) != 0.0 && EXPORTSTATS.getRawDouble(Stats.gleaming_vein_chance) != 0.0;

            case lootbugsWithBearAndLantern, lootbugsWithLantern, lootbugsWithBearAndLantern_cap, lootbugsWithLantern_cap -> EXPORTSTATS.getRawInt(Stats.lootfrogs_caught) != null && EXPORTSTATS.getRawInt(Stats.lootfrogs_caught) > 0;
            case lootbugsWithGoldenLantern, lootbugsWithGoldenLanternAndBear, lootbugsWithGoldenLantern_cap, lootbugsWithGoldenLanternAndBear_cap -> EXPORTSTATS.getRawInt(Stats.lootfrog_lanterns_used) != null && EXPORTSTATS.getRawInt(Stats.lootfrog_lanterns_used) > 25;

            case true_big_golden_lootfrogs, true_big_golden_lootfrogs_multi -> EXPORTSTATS.getRawDouble(Stats.lootfrog_big_chance) > 0.0 && EXPORTSTATS.getRawDouble(Stats.lootfrog_golden_chance) > 0.0;
            case true_massive_lootfrogs, true_massive_lootfrogs_multi -> EXPORTSTATS.getRawDouble(Stats.lootfrog_massive_chance) > 0.0;
            case true_massive_golden_lootfrogs, true_massive_golden_lootfrogs_multi -> EXPORTSTATS.getRawDouble(Stats.lootfrog_massive_chance) > 0.0 && EXPORTSTATS.getRawDouble(Stats.lootfrog_golden_chance) > 0.0;
            case medium_additional_lootfrogs -> EXPORTSTATS.getRawDouble(Stats.lootfrog_10x_spawn_chance) > 0.0 || EXPORTSTATS.getRawDouble(Stats.lootfrog_triple_spawn_chance) > 0.0;

            case true_pickaxe_damage -> true;

              case bear_duration_until_max -> !Drones.Bomb_Bear.isMaxGrade() && Pickaxe.obelisk>=18;
              case bear_duration, bear_lootbug_speed_multi -> Pickaxe.obelisk>=18;
              case bear_experience_until_max -> !Drones.Bomb_Bear.isMaxGrade() && Pickaxe.obelisk>=18;

              case chain_duration_until_max -> !Drones.Chain_Bomber.isMaxGrade() && Pickaxe.obelisk>=18;
              case chain_duration -> Pickaxe.obelisk>=18;
              case chain_experience_until_max -> !Drones.Chain_Bomber.isMaxGrade() && Pickaxe.obelisk>=18;

              case midas_duration_until_max -> !Drones.Midas.isMaxGrade() && Pickaxe.obelisk>=18;
              case midas_duration -> Pickaxe.obelisk>=18;
              case midas_experience_until_max -> !Drones.Midas.isMaxGrade() && Pickaxe.obelisk>=18;

              case frogger_duration_until_max -> !Drones.Frogger.isMaxGrade() && Pickaxe.obelisk>=18;
              case frogger_duration -> Pickaxe.obelisk>=18;
              case frogger_experience_until_max -> !Drones.Frogger.isMaxGrade() && Pickaxe.obelisk>=18;

              case veinseeker_duration_until_max -> !Drones.Veinseeker.isMaxGrade() && Pickaxe.obelisk>=18;
              case veinseeker_duration -> Pickaxe.obelisk>=18;
              case veinseeker_experience_until_max -> !Drones.Veinseeker.isMaxGrade() && Pickaxe.obelisk>=18;

              case starburst_duration_until_max -> !Drones.Starburst.isMaxGrade() && Pickaxe.obelisk>=18;
              case starburst_duration -> Pickaxe.obelisk>=18;
              case starburst_experience_until_max -> !Drones.Starburst.isMaxGrade() && Pickaxe.obelisk>=18;

              case elixir_duration_until_max -> !Drones.Elixir.isMaxGrade() && Pickaxe.obelisk>=18;
              case elixir_duration -> Pickaxe.obelisk>=18;
              case elixir_experience_until_max -> !Drones.Elixir.isMaxGrade() && Pickaxe.obelisk>=18;

              case void_duration_until_max -> !Drones.Void.isMaxGrade() && Pickaxe.obelisk>=18;
              case void_duration -> Pickaxe.obelisk>=18;
              case void_experience_until_max -> !Drones.Void.isMaxGrade() && Pickaxe.obelisk>=18;

              case angler_duration_until_max -> !Drones.Angler.isMaxGrade();
              case angler_experience_until_max -> !Drones.Angler.isMaxGrade();
              case angler_duration -> true;
              case prism_duration_until_max -> !Drones.Prism.isMaxGrade();
              case prism_experience_until_max -> !Drones.Prism.isMaxGrade();
              case prism_duration -> true;
              case minotaur_duration_until_max -> !Drones.Minotaur.isMaxGrade();
              case minotaur_experience_until_max -> !Drones.Minotaur.isMaxGrade();
              case minotaur_duration -> true;

            case radiant_supernova_supergiant_star -> EXPORTSTATS.getRawDouble(Stats.star_radiant_chance) > 0.0;
            case DC13_challenge_floor,DC13_challenge_time_off,DC13_challenge_time_spoon -> EXPORTSTATS.getRawDouble(Stats.star_radiant_chance) > 0.0 && Pickaxe.getWorld()>=4;

            case true_golden_void_portal, true_golden_void_portal_multi -> EXPORTSTATS.getRawDouble(Stats.golden_void_portal_chance) > 0.0;
            case true_rainbow_void_portal, true_rainbow_void_portal_multi -> EXPORTSTATS.getRawDouble(Stats.rainbow_void_portal_chance) > 0.0;
            case true_galactic_void_portal, true_galactic_void_portal_multi -> EXPORTSTATS.getRawDouble(Stats.galactic_void_portal_chance) > 0.0;

            case rainbow_veins_rainbow_portal_rainbow_floor -> EXPORTSTATS.getRawDouble(Stats.rainbow_void_portal_chance) > 0.0;

            case expected_stonks_on_max_cap -> EXPORTSTATS.getRawDouble(Stats.stonks_chance) > 1.0;
            case true_super_stonks, expected_super_stonks_on_max_cap -> EXPORTSTATS.getRawDouble(Stats.super_stonks_chance) > 0.0;
            case true_ultra_stonks, expected_ultra_stonks_on_max_cap -> EXPORTSTATS.getRawDouble(Stats.ultra_stonks_chance) > 0.0;
            case true_super_stonks_multi -> EXPORTSTATS.getRawDouble(Stats.super_stonks_multi) > 0.0;
            case true_ultra_stonks_multi -> EXPORTSTATS.getRawDouble(Stats.ultra_stonks_multi) > 0.0;

            case base_high_gems_gift_min, base_high_gems_gift_max -> Pickaxe.obelisk >= 60;

            case cherry_charge_gift_min, cherry_charge_gift_max -> Pickaxe.getWorld()>=3;
            
            default -> true;
        };
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
            case zone1_vein:
            return Drones.veinChance(0, false, 0) * 100;
            case zone1_vein_double:
                return Drones.veinChance(0, true, 0) * 100;
            case zone1_veinseeker:
                return Drones.veinChance(40, false, 0) * 100;
            case zone1_veinseeker_double:
                return Drones.veinChance(40, true, 0) * 100;
            
            case zone2_vein:
                return Drones.veinChance(0, false, 1) * 100;
            case zone2_vein_double:
                return Drones.veinChance(0, true, 1) * 100;
            case zone2_veinseeker:
                return Drones.veinChance(40, false, 1) * 100;
            case zone2_veinseeker_double:
                return Drones.veinChance(40, true, 1) * 100;
            
            case zone3_vein:
                return Drones.veinChance(0, false, 2) * 100;
            case zone3_vein_double:
                return Drones.veinChance(0, true, 2) * 100;
            case zone3_veinseeker:
                return Drones.veinChance(40, false, 2) * 100;
            case zone3_veinseeker_double:
                return Drones.veinChance(40, true, 2) * 100;
            
            case zone4_vein:
                return Drones.veinChance(0, false, 3) * 100;
            case zone4_vein_double:
                return Drones.veinChance(0, true, 3) * 100;
            case zone4_veinseeker:
                return Drones.veinChance(40, false, 3) * 100;
            case zone4_veinseeker_double:
                return Drones.veinChance(40, true, 3) * 100;
            
            case zone5_vein:
                return Drones.veinChance(0, false, 4) * 100;
            case zone5_vein_double:
                return Drones.veinChance(0, true, 4) * 100;
            case zone5_veinseeker:
                return Drones.veinChance(40, false, 4) * 100;
            case zone5_veinseeker_double:
                return Drones.veinChance(40, true, 4) * 100;
            
            case zone6_vein:
                return Drones.veinChance(0, false, 5) * 100;
            case zone6_vein_double:
                return Drones.veinChance(0, true, 5) * 100;
            case zone6_veinseeker:
                return Drones.veinChance(40, false, 5) * 100;
            case zone6_veinseeker_double:
                return Drones.veinChance(40, true, 5) * 100;
            
            case world2_vein:
                return Drones.veinChance(0, false, 6) * 100;
            case world2_vein_double:
                return Drones.veinChance(0, true, 6) * 100;
            case world2_veinseeker:
                return Drones.veinChance(40, false, 6) * 100;
            case world2_veinseeker_double:
                return Drones.veinChance(40, true, 6) * 100;
            
            case world3_vein:
                return Drones.veinChance(0, false, 7) * 100;
            case world3_vein_double:
                return Drones.veinChance(0, true, 7) * 100;
            case world3_veinseeker:
                return Drones.veinChance(40, false, 7) * 100;
            case world3_veinseeker_double:
                return Drones.veinChance(40, true, 7) * 100;
            
            case world4_vein:
                return Drones.veinChance(0, false, 8) * 100;
            case world4_vein_double:
                return Drones.veinChance(0, true, 8) * 100;
            case world4_veinseeker:
                return Drones.veinChance(40, false, 8) * 100;
            case world4_veinseeker_double:
                return Drones.veinChance(40, true, 8) * 100;
            case lootbugsAlone_cap:
                return ((int) EXPORTSTATS.getRaw(Calc.lootbugsAlone))*EXPORTSTATS.getRawInt(Stats.lootbug_bank_cap);
            case lootbugsWithBear_cap:
                return ((int) EXPORTSTATS.getRaw(Calc.lootbugsWithBear))*EXPORTSTATS.getRawInt(Stats.lootbug_bank_cap);
            case lootbugsWithBearAndLantern_cap:
                return ((int) EXPORTSTATS.getRaw(Calc.lootbugsWithBearAndLantern))*EXPORTSTATS.getRawInt(Stats.lootbug_bank_cap);
            
            case lootbugsWithLantern_cap:
                return ((int) EXPORTSTATS.getRaw(Calc.lootbugsWithLantern))*EXPORTSTATS.getRawInt(Stats.lootbug_bank_cap);
            
            case lootbugsWithGoldenLantern_cap:
                return ((int) EXPORTSTATS.getRaw(Calc.lootbugsWithGoldenLantern))*EXPORTSTATS.getRawInt(Stats.lootbug_bank_cap);
            case lootbugsWithGoldenLanternAndBear_cap:
                return ((int) EXPORTSTATS.getRaw(Calc.lootbugsWithGoldenLanternAndBear))*EXPORTSTATS.getRawInt(Stats.lootbug_bank_cap);
            
            case lootbugsAlone:
                return Drones.lootbugSpeed(false);
        
            case lootbugsWithBear:
                return Drones.lootbugSpeed(true);
            
            case lootbugsWithBearAndLantern:
                return Drones.lootbugSpeedGoldenLantern(true, false);
            
            case lootbugsWithLantern:
                return Drones.lootbugSpeedGoldenLantern(false, false);
            
            case lootbugsWithGoldenLantern:
                return Drones.lootbugSpeedGoldenLantern(false, true);
            
            case lootbugsWithGoldenLanternAndBear:
                return Drones.lootbugSpeedGoldenLantern(true, true);
            
            case expected_stonks_on_max_cap:
                return EXPORTSTATS.getRawInt(Stats.freebie_bank_cap)*(EXPORTSTATS.getRawDouble(Stats.stonks_chance)/100.0);
            case expected_super_stonks_on_max_cap:
                return EXPORTSTATS.getRawInt(Stats.freebie_bank_cap)*(getComputedValue(Calc.true_super_stonks)/100.0);
            case expected_ultra_stonks_on_max_cap:
                return EXPORTSTATS.getRawInt(Stats.freebie_bank_cap)*(getComputedValue(Calc.true_ultra_stonks)/100.0);
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
            case star_chance_per_floor: {
                Double rate = EXPORTSTATS.getRawDouble(Stats.star_spawn_rate);
                if (rate == null || rate == 0.0) return 0.0;
                return (rate/50.0)*100.0;
            }
            case true_star_per_floor: {
                Double chance = (Double) getComputedValue(Calc.star_chance_per_floor);
                Double doubleChance = EXPORTSTATS.getRawDouble(Stats.star_double_spawn_chance);
                Double tripleChance = EXPORTSTATS.getRawDouble(Stats.star_triple_spawn_chance);
            
                double result = chance / 100.0;
                if (doubleChance != null && doubleChance != 0.0) result *= (doubleChance / 50.0);
                if (tripleChance != null && tripleChance != 0.0) result *= (3 * tripleChance / 100.0);

                return result * 100.0;
            }
            case true_super_star_per_floor: {
                Double superChance = (Double) getComputedValue(Calc.super_star_chance_per_floor);
                Double tripleChance = EXPORTSTATS.getRawDouble(Stats.super_star_triple_chance);
                Double tenxChance = EXPORTSTATS.getRawDouble(Stats.super_star_10x_chance);
            
                double result = superChance / 100.0;
                if (tripleChance != null && tripleChance != 0.0) result *= (3 * tripleChance / 100.0);
                if (tenxChance != null && tenxChance != 0.0) result *= (10 * tenxChance / 100.0);
            
                return result * 100.0;
            }
            case super_star_chance_per_floor: {
                Double chance = (Double) getComputedValue(Calc.star_chance_per_floor);
                Double spawnMulti = EXPORTSTATS.getRawDouble(Stats.super_star_spawn_multi);
                if (chance == null || spawnMulti == null) return 0.0;
                return (chance/100.0)*(spawnMulti/100.0)*100.0;
            }
            case Obelisk:
                return Pickaxe.obelisk;
            case is_tutorial_done:
                return false;
            case world:
                return Pickaxe.getWorld();
            case bear_lootbug_speed_multi:
                return (int) (130 + (int) (Drones.Bomb_Bear.grade * 0.03));
            case DC13_challenge_time_off:
                return (getComputedValue(Calc.DC13_challenge_floor)/48)*60;
            case DC13_challenge_time_spoon:
                return (getComputedValue(Calc.DC13_challenge_floor)/60)*60;
            case DC13_challenge_floor:
                double chance = getComputedValue(Calc.radiant_supernova_supergiant_star) / 100.0;
                double floorChance = (Double) getComputedValue(Calc.true_star_per_floor) / 100.0;
                return 12500 / (chance* floorChance);
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
            case true_galactic_floor:
                base = ((Double) EXPORTSTATS.getRaw(Stats.rainbow_floor_chance)) / 100.0
                    * ((Double) EXPORTSTATS.getRaw(Stats.galactic_floor_chance)) / 100.0;
                return base * 100;
            
            case true_prismatic_floor:
                base = getComputedValue(Calc.true_galactic_floor) / 100.0
                    * ((Double) EXPORTSTATS.getRaw(Stats.prismatic_floor_chance)) / 100.0;
                return base * 100;
            
            case true_galactic_floor_multi:
                base = 1;
                base *= ((Double) EXPORTSTATS.getRaw(Stats.galactic_floor_multi));
                base *= ((Double) EXPORTSTATS.getRaw(Stats.rainbow_floor_multi));
                base /= 100;
                return base * 100;
            
            case true_prismatic_floor_multi:
                base = 1;
                base *= ((Double) EXPORTSTATS.getRaw(Stats.prismatic_floor_multi));
                base *= getComputedValue(Calc.true_galactic_floor_multi);
                base /= 100;
                return base * 100;
            
            case true_golden_floor_multi:
                base = 1;
                base *= ((Double) EXPORTSTATS.getRaw(Stats.golden_floor_multi));
                base /= 100;
                return base * 100;
            
            case true_golden_rainbow_floor_multi:
                base = 1;
                base *= ((Double) EXPORTSTATS.getRaw(Stats.golden_floor_multi));
                base *= ((Double) EXPORTSTATS.getRaw(Stats.rainbow_floor_multi));
                base /= 100;
                return base * 100;
            
            case true_golden_galactic_floor_multi:
                base = 1;
                base *= ((Double) EXPORTSTATS.getRaw(Stats.golden_floor_multi));
                base *= ((Double) EXPORTSTATS.getRaw(Stats.galactic_floor_multi));
                base *= ((Double) EXPORTSTATS.getRaw(Stats.rainbow_floor_multi));
                base /= 100;
                return base * 100;
            
            case true_golden_prismatic_floor_multi:
                base = 1;
                base *= ((Double) EXPORTSTATS.getRaw(Stats.golden_floor_multi));
                base *= ((Double) EXPORTSTATS.getRaw(Stats.prismatic_floor_multi));
                base *= getComputedValue(Calc.true_galactic_floor_multi);
                base /= 100;
                return base * 100;
            
            case true_rainbow_vein:
                base = 1.0;
                base *= ((EXPORTSTATS.getRawDouble(Stats.golden_vein_chance)) / 100.0)
                    * (EXPORTSTATS.getRawDouble(Stats.rainbow_vein_chance) / 100.0);
                return base * 100;
            
            case true_golden_vein_multi:
                base = 1;
                base *= ((Double) EXPORTSTATS.getRaw(Stats.golden_floor_multi));
                base /= 100;
                return base * 100;
            
            case true_rainbow_vein_multi:
                base = 1;
                base *= getComputedValue(Calc.true_golden_vein_multi) * ((Double) EXPORTSTATS.getRaw(Stats.rainbow_vein_multi));
                base /= 100;
                return base * 100;
            
            case true_gleaming_golden_vein_multi:
                base = 1;
                base *= ((Double) EXPORTSTATS.getRaw(Stats.gleaming_vein_multi));
                base *= ((Double) EXPORTSTATS.getRaw(Stats.golden_floor_multi));
                base /= 100;
                return base * 100;
            
            case true_gleaming_rainbow_vein_multi:
                base = 1;
                base *= ((Double) EXPORTSTATS.getRaw(Stats.gleaming_vein_multi));
                base *= getComputedValue(Calc.true_golden_vein_multi) * ((Double) EXPORTSTATS.getRaw(Stats.rainbow_vein_multi));
                base /= 100;
                return base * 100;
            
            case true_big_golden_lootfrogs:
                base = ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_golden_chance)) / 100.0
                    * ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_big_chance)) / 100.0;
                return base * 100;
            
            case true_massive_lootfrogs:
                base = ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_big_chance)) / 100.0
                    * ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_massive_chance)) / 100.0;
                return base * 100;
            
            case true_massive_golden_lootfrogs:
                base = ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_golden_chance)) / 100.0
                    * getComputedValue(Calc.true_massive_lootfrogs) / 100.0;
                return base * 100;
            
            case true_big_golden_lootfrogs_multi:
                base = ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_golden_multi)) * ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_big_multi));
                base /= 100.0;
                return base * 100;
            
            case true_massive_lootfrogs_multi:
                base = ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_big_multi)) * ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_massive_multi));
                base /= 100.0;
                return base * 100;
            
            case true_massive_golden_lootfrogs_multi:
                base = ((Double) EXPORTSTATS.getRaw(Stats.lootfrog_golden_multi)) * getComputedValue(Calc.true_massive_lootfrogs_multi);
                base /= 100.0;
                return base * 100;
            
            case true_golden_void_portal:
                base = getComputedValue(Calc.void_portal_perma) * ((Double) EXPORTSTATS.getRaw(Stats.golden_void_portal_chance)) / 100.0;
                return base * 100;
            
            case true_rainbow_void_portal:
                base = getComputedValue(Calc.true_golden_void_portal) / 100.0
                    * ((Double) EXPORTSTATS.getRaw(Stats.rainbow_void_portal_chance)) / 100.0;
                return base * 100;
            
            case true_galactic_void_portal:
                base = getComputedValue(Calc.true_rainbow_void_portal) / 100.0
                    * ((Double) EXPORTSTATS.getRaw(Stats.galactic_void_portal_chance)) / 100.0;
                return base * 100;
            
            case true_golden_void_portal_multi:
                base = (((Double) EXPORTSTATS.getRaw(Stats.void_portal_base_multi))) * ((Double) EXPORTSTATS.getRaw(Stats.golden_void_portal_multi));
                base /= 100;
                return base * 100;
            
            case true_rainbow_void_portal_multi:
                base = getComputedValue(Calc.true_golden_void_portal_multi) * ((Double) EXPORTSTATS.getRaw(Stats.rainbow_void_portal_multi));
                base /= 100;
                return base * 100;
            
            case true_galactic_void_portal_multi:
                base = getComputedValue(Calc.true_rainbow_void_portal_multi) * ((Double) EXPORTSTATS.getRaw(Stats.galactic_void_portal_multi));
                base /= 100;
                return base * 100;
            
            case true_super_stonks:
                base = ((Double) EXPORTSTATS.getRaw(Stats.super_stonks_chance)) / 100.0 * ((Double) EXPORTSTATS.getRaw(Stats.stonks_chance)) / 100.0;
                return base * 100;
            
            case true_ultra_stonks:
                base = ((Double) EXPORTSTATS.getRaw(Stats.ultra_stonks_chance)) / 100.0 * getComputedValue(Calc.true_super_stonks) / 100.0;
                return base * 100;
            
            case true_super_stonks_multi:
                base = ((Double) EXPORTSTATS.getRaw(Stats.super_stonks_multi)) * (Double) EXPORTSTATS.getRaw(Stats.stonks_multi);
                base /= 100.0;
                return base * 100;
            
            case true_ultra_stonks_multi:
                base = ((Double) EXPORTSTATS.getRaw(Stats.ultra_stonks_multi)) * getComputedValue(Calc.true_super_stonks_multi);
                base /= 100.0;
                return base * 100;
            } 
            
    }
}
