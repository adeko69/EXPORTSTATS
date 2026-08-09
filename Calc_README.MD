### CALC

At the opposite from EXPORTSTATS.jar, calc is used to calculate things (lol)

###Usages

## Pickaxe

`true_pickaxe_damage`: Give the true value of the pickaxe damage after crit and mult. They are estimed based on the % of the crit.

## Lootbugs

`lootbugsAlone`: Calculate the second between lootbugs without bear drone and (golden) lantern
`lootbugsWithBear`-`lootbugsWithLantern`-`lootbugsWithGolden` and the other possibility: Calculate when bear drone (fueled) and lantern is active. Cancel Bear if active, but not Lantern

## Veins
`zone_vein` - `world_vein`: Show the chance of getting a vein, without double veins and without veinseeker
`zone_veinseeker` - `world_veinseeker`: Show the chance of getting a vein, without double veins and with veinseeker

> [!NOTE]
> The following are not included but coded. The reason is **Easier to add or remove something if we know the double veins is already bought**

`2.2.6-3 or later`:
> `zone_vein_double` - `world_vein_double`: Show the chance of getting a vein, with double veins and without veinseeker
> `zone_veinseeker_double` - `world_veinseeker_double`: Show the chance of getting a vein, with double veins and with veinseeker

## Floors
`true_rainbow_floor` - `true_galactic_floor` - `true_prismatic_floor`: Chance of getting special floor. `true_rainbow_floor` is always off (as it is the same as `rainbow_floor_chance`)

## Drones (11 kind)
`duration_until_max`: The number of tick until having the drone fully maxed (Ignore grade cap not unlocked)
`duration`: The number of second gave by the drone
`experience_until_max`: How many experience you need to max grade.
