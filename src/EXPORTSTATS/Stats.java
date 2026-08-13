package EXPORTSTATS;

import pkg.As;

public enum Stats {
    contract_double_points_chance(TagList.Contracts, As.PERCENT),craft_100x_chance(TagList.Crafting, As.PERCENT),fishing_super_shiny_multi(TagList.Fishing, As.TIMES),drone_count(TagList.Drones, As.NONE),
    super_star_triple_chance(TagList.Stars, As.PERCENT),drone_damage_percent(TagList.Drones, As.PERCENT),bomb_omega_crit_damage(TagList.Bombs, As.TIMES),rainbow_floor_multi(TagList.Ore, As.TIMES),

    statue_0_set1(TagList.Statues, As.STATUE),statue_1_set1(TagList.Statues, As.STATUE),statue_2_set1(TagList.Statues, As.STATUE),
    statue_3_set1(TagList.Statues, As.STATUE),statue_4_set1(TagList.Statues, As.STATUE),statue_5_set1(TagList.Statues, As.STATUE),
    statue_6_set1(TagList.Statues, As.STATUE),statue_7_set1(TagList.Statues, As.STATUE),statue_8_set1(TagList.Statues, As.STATUE),
    statue_0_set2(TagList.Statues, As.STATUE),statue_1_set2(TagList.Statues, As.STATUE),statue_2_set2(TagList.Statues, As.STATUE),
    statue_3_set2(TagList.Statues, As.STATUE),statue_4_set2(TagList.Statues, As.STATUE),statue_5_set2(TagList.Statues, As.STATUE),
    statue_6_set2(TagList.Statues, As.STATUE),statue_7_set2(TagList.Statues, As.STATUE),statue_8_set2(TagList.Statues, As.STATUE),
    statue_0_set3(TagList.Statues, As.STATUE),statue_1_set3(TagList.Statues, As.STATUE),statue_2_set3(TagList.Statues, As.STATUE),
    statue_3_set3(TagList.Statues, As.STATUE),statue_4_set3(TagList.Statues, As.STATUE),statue_5_set3(TagList.Statues, As.STATUE),
    statue_6_set3(TagList.Statues, As.STATUE),statue_7_set3(TagList.Statues, As.STATUE),statue_8_set3(TagList.Statues, As.STATUE),

    bomb_additional_multiplier(TagList.Bombs, As.TIMES),bomb_damage(TagList.Bombs, As.TIMES),bomb_transmuter_multi(TagList.Bombs, As.TIMES),bomb_trans_apply_bop_chance(TagList.Bombs,As.PERCENT),
    coal_capacity_multi(TagList.Drones, As.TIMES), xp_level_cap(TagList.Prestige, As.NONE), fishing_drone_power(TagList.Fishing, As.TIMES),candy_eaten(TagList.Stars, As.NONE),prismatic_floor_multi(TagList.Ore, As.TIMES),
    star_supernova_chance(TagList.Stars,As.PERCENT),chest_double_chance(TagList.Chests,As.PERCENT),lootfrog_golden_chance(TagList.Lootfrogs,As.PERCENT),obelisk_timer_add(TagList.Obelisk, As.NONE),
    lootfrog_triple_spawn_chance(TagList.Lootfrogs,As.PERCENT),super_star_radiant_chance(TagList.Stars,As.PERCENT),star_auto_catch_chance(TagList.Stars,As.PERCENT),drone_radius_percent(TagList.Drones,As.PERCENT),
    pickaxe_damage(TagList.Pickaxe, As.NONE),bomb_of_plenty_make_gold_chance(TagList.Bombs,As.PERCENT),prismatic_floor_chance(TagList.Ore,As.PERCENT),galactic_floor_chance(TagList.Ore,As.PERCENT),
    drone_rapid_fire_chance(TagList.Drones,As.PERCENT),chest_meter_multi(TagList.Chests,As.T),lootfrog_loot_multi(TagList.Lootfrogs,As.T),super_star_spawn_multi(TagList.Stars,As.T),
    game_speed_multi(TagList.Misc,As.T),bomb_battery_cap_increases(TagList.Bombs,As.N),all_floor_multipliers(TagList.Ore,As.T), fishing_5x_tick_chance(TagList.Fishing,As.PERCENT),
    super_star_10x_chance(TagList.Stars,As.PERCENT),golden_ore_multi(TagList.Ore,As.T),fishing_tier2_dock_multi(TagList.Fishing,As.T),pickaxe_super_crit_damage(TagList.Pickaxe,As.T),
    void_portal_base_multi(TagList.Drones,As.T),super_stonks_multi(TagList.Chests,As.T),fishing_notice_requirement(TagList.Fishing,As.P),bomb_omega_crit_chance(TagList.Bombs,As.PERCENT),    
    fishing_shiny_multi(TagList.Fishing,As.T),golden_floor_multi(TagList.Ore,As.T),coal_generation_seconds(TagList.Drones,As.S),super_star_supergiant_multi(TagList.Stars,As.T),
    super_star_supernova_multi(TagList.Stars,As.T),lootbug_bank_cap(TagList.Lootbugs, As.N),freebie_gems_bonus(TagList.Chests,As.N),rainbow_vein_multi(TagList.Veins,As.T),
    floor_clear_requirement_multi(TagList.Prestige,As.T),vein_income_multi(TagList.Veins,As.T),star_supergiant_chance(TagList.Stars,As.PERCENT),gleaming_vein_chance(TagList.Veins,As.PERCENT),
    golden_lootfrogs_caught(TagList.Lootfrogs, As.N),free_craft_chance(TagList.Crafting,As.PERCENT),fishing_drone_multiplier(TagList.Fishing,As.T),fishing_token_multi(TagList.Fishing,As.T),
    craft_5x_chance(TagList.Crafting,As.PERCENT),lootbug_triple_chance(TagList.Lootbugs,As.PERCENT),fishing_shiny_chance(TagList.Fishing,As.PERCENT),lootfrog_golden_multi(TagList.Lootfrogs,As.T),
    rainbow_void_portal_chance(TagList.Drones,As.PERCENT),rainbow_vein_chance(TagList.Veins,As.PERCENT),artifact_tier4_cap_increase(TagList.Prestige,As.N),golden_vein_chance(TagList.Veins,As.PERCENT),
    super_star_radiant_multi(TagList.Stars,As.T),pickaxe_omega_crit_chance(TagList.Pickaxe,As.PERCENT),pet_levelup_chance_multi(TagList.Misc,As.T),drone_movespeed_percent(TagList.Drones,As.PERCENT),
    contract_points_rewarded(TagList.Contracts,As.N),pickaxe_ultra_crit_damage(TagList.Pickaxe,As.T),star_double_spawn_chance(TagList.Stars,As.PERCENT),pickaxe_attack_speed_per_second(TagList.Pickaxe,As.T),
    golden_ore_chance(TagList.Ore,As.PERCENT),bomb_super_crit_damage(TagList.Bombs,As.T),obelisk_cooldown_multi(TagList.Obelisk,As.T),fishing_drone_capacity(TagList.Fishing,As.N),
    stonks_multi(TagList.Chests,As.T),bomb_cherry3x_chance(TagList.Bombs,As.PERCENT),contract_cost_reduction(TagList.Contracts,As.T),contract_cap_increase(TagList.Contracts,As.N),
    contract_10x_points_chance(TagList.Contracts,As.PERCENT),chest_items_bonus(TagList.Chests,As.N),bomb_free_chance(TagList.Bombs,As.PERCENT),all_star_multi(TagList.Stars,As.T),ore_income_multi(TagList.Ore,As.T),
    galactic_floor_multi(TagList.Ore,As.T),bomb_crit_chance(TagList.Bombs,As.P),freebie_5x_chance(TagList.Chests,As.P),pizzas_eaten(TagList.Ore,As.N),craft_20x_chance(TagList.Crafting,As.P),
    super_stonks_chance(TagList.Chests,As.PERCENT),golden_void_portal_multi(TagList.Drones,As.T),lootbug_golden_chance(TagList.Lootbugs,As.PERCENT),elixir_crit_chance(TagList.Drones,As.PERCENT),
    ultra_stonks_multi(TagList.Chests,As.T),fishing_triple_tick_chance(TagList.Fishing,As.P),rainbow_void_portal_multi(TagList.Drones,As.T),pickaxe_omega_crit_damage(TagList.Pickaxe,As.T),
    craft_10x_chance(TagList.Crafting,As.PERCENT),super_star_supergiant_chance(TagList.Stars,As.P),elixir_crit_multi(TagList.Drones,As.T),fishing_super_shiny_chance(TagList.Fishing,As.PERCENT),
    pickaxe_crit_chance(TagList.Pickaxe,As.PERCENT),time(TagList.Others, As.SPECIAL_TIME),fishing_tick_reduction_seconds(TagList.Fishing,As.S),prestige_point_multi(TagList.Prestige,As.T),fishing_rod_power(TagList.Fishing,As.T),
    gleaming_vein_multi(TagList.Veins,As.T),bomb_ultra_crit_chance(TagList.Bombs,As.P),bomb_cap_multiplier(TagList.Bombs,As.T),stonks_chance(TagList.Chests,As.P),gem_upgrade_cap_increase(TagList.Misc,As.N),
    lootfrog_lanterns_used(TagList.Lootbugs,As.N),lootbug_loot_multi(TagList.Lootbugs,As.T),artifact_cap_increase(TagList.Prestige,As.TIMES),lootbug_spawn_rate(TagList.Lootbugs,As.TIMES),
    pickaxe_ultra_crit_chance(TagList.Pickaxe,As.PERCENT),rainbow_floor_chance(TagList.Ore,As.PERCENT),bar_upgrade_cost_reduction(TagList.Crafting,As.T),steak_eaten(TagList.Ore, As.N),star_spawn_rate(TagList.Stars,As.T),
    freebie_bank_cap(TagList.Chests,As.N),coal_drone_exp_multi(TagList.Drones,As.T),drone_attack_speed_percent(TagList.Drones,As.PERCENT),coal_fuel_save_chance(TagList.Drones,As.PERCENT),
    bomb_capacity(TagList.Bombs,As.N),drone_triple_damage_chance(TagList.Drones,As.PERCENT),star_triple_spawn_chance(TagList.Stars,As.PERCENT),lootfrog_capacity(TagList.Lootfrogs,As.N),
    fishing_tick_speed(TagList.Fishing,As.S),coal_fuel_duration_multi(TagList.Drones,As.T),fishing_income_multi(TagList.Fishing,As.T),pickaxe_crit_damage(TagList.Pickaxe,As.T),
    lootfrog_10x_spawn_chance(TagList.Lootfrogs,As.P),contract_triple_points_chance(TagList.Contracts,As.P),bomb_workshop_cap_increase(TagList.Bombs,As.N),pickaxe_radius_percent(TagList.Pickaxe,As.P),
    ore_sell_price_multi(TagList.Ore,As.T),bar_output_multi(TagList.Crafting,As.T),void_portal_chance(TagList.Drones,As.P),bomb_of_plenty_multi(TagList.Bombs,As.T),drone_suit_cap(TagList.Drones,As.N),
    bomb_ultra_crit_damage(TagList.Bombs,As.T),lootbug_gem_cost_reduction(TagList.Lootbugs,As.T),star_supernova_multi(TagList.Stars,As.T),star_supergiant_multi(TagList.Stars,As.T),
    obelisk_armor_reduction(TagList.Obelisk,As.T),star_radiant_chance(TagList.Stars,As.P),experience_multi(TagList.Prestige,As.T),multi_rock_chance(TagList.Ore,As.P),bomb_crit_damage(TagList.Bombs,As.T),
    ultra_stonks_chance(TagList.Chests,As.P),star_radiant_multi(TagList.Stars,As.T),contract_5x_points_chance(TagList.Contracts,As.P),golden_floor_chance(TagList.Ore,As.P),
    item_duration_multi(TagList.Misc,As.T),contract_upgrade_cost_reduction(TagList.Contracts,As.T),bomb_recharge_speed(TagList.Bombs,As.T),fishing_tiny_notice_chance(TagList.Fishing,As.P),
    lootfrog_big_chance(TagList.Lootfrogs,As.PERCENT),bar_craft_cost_multi(TagList.Crafting,As.T),freebie_cooldown_seconds(TagList.Chests,As.S),super_star_supernova_chance(TagList.Stars,As.P),
    freebie_refresh_chance(TagList.Chests,As.PERCENT),lootfrog_big_multi(TagList.Lootfrogs,As.T),golden_vein_multi(TagList.Veins,As.T),double_craft_chance(TagList.Crafting,As.PERCENT),version(TagList.Others,As.N),
    lootfrogs_caught(TagList.Lootfrogs,As.N),vein_spawn_rate_multi(TagList.Veins,As.T),pickaxe_super_crit_chance(TagList.Pickaxe,As.P),novagiant_combo_multi(TagList.Stars,As.T),
    fishing_double_tick_chance(TagList.Fishing,As.P),triple_craft_chance(TagList.Crafting,As.PERCENT),golden_void_portal_chance(TagList.Drones,As.PERCENT),bomb_super_crit_chance(TagList.Bombs, As.PERCENT),
    all_void_portal_multi(TagList.Drones,As.T),
    
    //2.2.5

    ores_per_screen(TagList.Ore,As.N),is_drone_elixir_equipped_and_fueled(TagList.Drone_Unlock,As.B),is_drone_bear_equipped(TagList.Drone_Unlock,As.B),
    veinseeker_fuel_grade(TagList.Drone_Unlock,As.N),is_drone_elixir_equipped(TagList.Drone_Unlock,As.B),
    is_drone_frogger_equipped(TagList.Drone_Unlock,As.B),minotaur_fuel_grade(TagList.Drone_Unlock,As.N),
    galactic_void_portal_multi(TagList.Drones,As.T),starburst_fuel_grade(TagList.Drone_Unlock,As.N),
    is_drone_prism_equipped_and_fueled(TagList.Drone_Unlock,As.B),is_drone_starburst_equipped_and_fueled(TagList.Drone_Unlock,As.B),
    is_drone_bear_equipped_and_fueled(TagList.Drone_Unlock,As.B),is_drone_minotaur_equipped_and_fueled(TagList.Drone_Unlock,As.B),midas_fuel_grade(TagList.Drone_Unlock,As.B),
    is_drone_chain_equipped_and_fueled(TagList.Drone_Unlock,As.B),is_drone_veinseeker_equipped_and_fueled(TagList.Drone_Unlock,As.B),galactic_void_portal_chance(TagList.Drones,As.B),
    is_drone_minotaur_equipped(TagList.Drone_Unlock,As.B),lootfrog_massive_multi(TagList.Lootfrogs,As.T),is_drone_frogger_equipped_and_fueled(TagList.Drone_Unlock,As.B),void_portal_multi(TagList.Drones,As.T),
    lootfrog_massive_chance(TagList.Lootfrogs,As.P),angler_fuel_grade(TagList.Drone_Unlock,As.N),is_drone_chain_equipped(TagList.Drone_Unlock,As.B),is_drone_midas_equipped(TagList.Drone_Unlock,As.B),
    is_drone_prism_equipped(TagList.Drone_Unlock,As.B),is_drone_void_equipped(TagList.Drone_Unlock,As.B),is_drone_midas_equipped_and_fueled(TagList.Drone_Unlock,As.B),bear_fuel_grade(TagList.Drone_Unlock,As.N),
    infernal_card_multi(TagList.Misc,As.T),frogger_fuel_grade(TagList.Drone_Unlock,As.N),is_drone_starburst_equipped(TagList.Drone_Unlock,As.B),is_drone_void_equipped_and_fueled(TagList.Drone_Unlock,As.B),
    prism_fuel_grade(TagList.Drone_Unlock,As.N),void_fuel_grade(TagList.Drone_Unlock,As.N),chain_fuel_grade(TagList.Drone_Unlock,As.N),is_drone_basic_equipped(TagList.Drone_Unlock,As.B),
    is_drone_angler_equipped(TagList.Drone_Unlock,As.B),
    elixir_fuel_grade(TagList.Drone_Unlock,As.N),is_drone_veinseeker_equipped(TagList.Drone_Unlock,As.B),is_drone_angler_equipped_and_fueled(TagList.Drone_Unlock,As.B);

    //...

    
    final TagList tag;
    public Object value;
    final public As as;

    Stats(TagList tg, As as){
        tag = tg;
        this.as = as;
    }
}
