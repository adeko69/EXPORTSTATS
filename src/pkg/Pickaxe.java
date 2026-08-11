package pkg;

import java.math.BigDecimal;

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

    public static int getObelisk(){
        if(EXPORTSTATS.getRawInt(Stats.xp_level_cap) == 20) return -1;
        return (EXPORTSTATS.getRawInt(Stats.xp_level_cap)-30)/5;
    }

    public static int getWorld(){
        int e = obelisk;
        if(e < 19) return 1;
        if(e < 42) return 2;
        if(e < 64) return 3;
        return 4;
    }
}
