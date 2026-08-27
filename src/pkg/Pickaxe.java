package pkg;

import java.math.BigDecimal;
import java.math.RoundingMode;

import EXPORTSTATS.EXPORTSTATS;
import EXPORTSTATS.Stats;

public class Pickaxe {

    public final static int obelisk = getObelisk();

    public static BigDecimal trueDamage() {
        BigDecimal baseDamage = toBigDecimal(EXPORTSTATS.getRaw(Stats.pickaxe_damage));
        float bigMult = 1f;

        
        float critChance = clampChance(toBigDecimal(EXPORTSTATS.getRaw(Stats.pickaxe_crit_chance)).floatValue() / 100.0f);

        if(critChance == 0.0) return baseDamage.multiply(BigDecimal.valueOf(bigMult));
        float critMult = toBigDecimal(EXPORTSTATS.getRaw(Stats.pickaxe_crit_damage)).floatValue();
        bigMult = critChance * critMult;

        float superCritChance = critChance*clampChance(toBigDecimal(EXPORTSTATS.getRaw(Stats.pickaxe_super_crit_chance)).floatValue() / 100.0f);

        if(superCritChance == 0.0) return baseDamage.multiply(BigDecimal.valueOf(bigMult));

        float superCritMult = toBigDecimal(EXPORTSTATS.getRaw(Stats.pickaxe_super_crit_damage)).floatValue();
        bigMult = superCritChance * superCritMult * bigMult;

        float ultraCritChance = superCritChance*clampChance(toBigDecimal(EXPORTSTATS.getRaw(Stats.pickaxe_ultra_crit_chance)).floatValue() / 100.0f);

        if(ultraCritChance == 0.0) return baseDamage.multiply(BigDecimal.valueOf(bigMult));

        float ultraCritMult = toBigDecimal(EXPORTSTATS.getRaw(Stats.pickaxe_ultra_crit_damage)).floatValue();
        bigMult = ultraCritChance * ultraCritMult * bigMult;

        float omegaCritChance = ultraCritChance*clampChance(toBigDecimal(EXPORTSTATS.getRaw(Stats.pickaxe_omega_crit_chance)).floatValue() / 100.0f);

        if(omegaCritChance == 0.0) return baseDamage.multiply(BigDecimal.valueOf(bigMult));

        float omegaCritMult = toBigDecimal(EXPORTSTATS.getRaw(Stats.pickaxe_omega_crit_damage)).floatValue();
        bigMult = omegaCritChance * omegaCritMult * bigMult;

        return baseDamage.multiply(BigDecimal.valueOf(bigMult));
    }

    private static float clampChance(float value) {
        return Math.max(0.0f, Math.min(1.0f, value));
    }

    private static BigDecimal toBigDecimal(Object value) {
        if (value == null) return BigDecimal.ZERO;
        if (value instanceof BigDecimal) return (BigDecimal) value;
        if (value instanceof Number) return BigDecimal.valueOf(((Number) value).doubleValue());
        return new BigDecimal(value.toString());
    }

    static int getObelisk(){
        if(EXPORTSTATS.getRawInt(Stats.xp_level_cap) == 20) return -1;
        return (EXPORTSTATS.getRawInt(Stats.xp_level_cap)-30)/5;
    }

    public static int getWorld(){
        if(obelisk < 19) return 1;
        if(obelisk < 42) return 2;
        if(obelisk < 64) return 3;
        return 4;
    }

    public static double giftsPercent(){
        int getStat = EXPORTSTATS.getRawInt(Stats.statue_8_set2);
        return switch(getStat){
            default -> 0.0;
            case 1 -> 0.005;
            case 2 -> 0.0075;
            case 3 -> 0.01;
        };
    }

    public static double bigGiftsPercent(){
        int getStat = EXPORTSTATS.getRawInt(Stats.statue_8_set2);
        
        return switch(getStat){
            default -> 0.0;
            case 1 -> 0.00002;
            case 2 -> 0.0000285714286;
            case 3 -> 0.00004;
        };
    }

    private static final BigDecimal ARMOR_LATE_GROWTH = BigDecimal.valueOf(9.5);
    private static final BigDecimal HEALTH_LATE_GROWTH = BigDecimal.valueOf(30);
    private static final BigDecimal GROWTH = BigDecimal.valueOf(2.8);

    public static BigDecimal getObArmor() {
        if (obelisk < 1) return BigDecimal.ZERO;

        BigDecimal value;
        if (obelisk <= 60) {
            value = BigDecimal.TEN.multiply(pow(GROWTH, obelisk));
            if (obelisk == 1) {
                value = value.divide(BigDecimal.valueOf(2));
            }
        } else {
            BigDecimal base60 = BigDecimal.TEN.multiply(pow(GROWTH, 60));
            value = base60.multiply(pow(ARMOR_LATE_GROWTH, obelisk - 59));
        }

        BigDecimal reduction = BigDecimal.valueOf(EXPORTSTATS.getRawDouble(Stats.obelisk_armor_reduction));
        value = value.multiply(reduction);

        return value.setScale(0, RoundingMode.HALF_UP);
    }

    private static BigDecimal pow(BigDecimal base, int exponent) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 0; i < exponent; i++) {
            result = result.multiply(base);
        }
        return result;
    }

    public static BigDecimal getObLife() {
        if (obelisk < 1) return BigDecimal.ZERO;

        BigDecimal value;
        if (obelisk <= 60) {
            value = BigDecimal.valueOf(100000).multiply(pow(GROWTH, obelisk));
        } else {
            BigDecimal base60 = BigDecimal.valueOf(100000).multiply(pow(GROWTH, 60));
            value = base60.multiply(pow(HEALTH_LATE_GROWTH, obelisk - 59));
        }
        return value.setScale(0, RoundingMode.HALF_UP);
    }
}
