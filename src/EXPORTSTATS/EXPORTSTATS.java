package EXPORTSTATS;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adeko.FM.FileManage;
import adeko.FM.LanguageManage;
import adeko.deko.JsonDeko;
import adeko.deko.Restore;
import adeko.text.Texts;
import adeko.types.ShortDate;


public class EXPORTSTATS {
    static String exported = "EXPORTDATA";
    public static Restore r;
    public static Restore calc;

    //PRECISION CUT THE DECIMAL PLACES OF THE NUMBERS, -1 = NO CUT
    public static int precision = 3;

    public static void showScience(boolean set){
        Restore r = new Restore("settings.bdeko");
        r.add("scientific", set);
        Notation.scientificNotation = set;
    }

    public static void setExportLocation(String s){
        exported = s;
    }

    public static void setLanguageManage(String path, String language){
        LanguageManage.setPath(path);
        LanguageManage.setLanguage(language);
    }

    public static void calculateAll(){
        if(r == null) {System.out.println("Erreur: Pas de Restore"); return;}

        for(Calc c : Calc.values()) {
            if(c.tag.show && c.show) {
                getCalc(c);
            }
        }
    }

    public static Object getCalc(Calc c){
        if(calc == null) return null;
        Object cached = calc.get(c.toString());
        if (cached != null) return cached;
        if (!c.tag.show || !c.show) return null;

        Object computed = c.setAndStore(c.calculate());
        if (computed != null) {
            calc.add(c.toString(), computed, c.tag.name());
        }
        return computed;
    }

    public static List<String> getAllData(){
        List<String> elementInData = FileManage.listFileWithExtension(exported, ".bdeko");

        List<String> alt = new ArrayList<>(elementInData);
        for(String s : alt){
            if(!new Restore(exported+"/"+s).getB("EXPORTSTATS")) elementInData.remove(s);
        }
        return elementInData;
    }

    public static List<String> getSimilarName(String s){
        if(r.check(s)) return new ArrayList<>(Arrays.asList(s));
        return r.corresponds(s);
    }

    public static List<Stats> getTag(TagList tg){
        List<Stats> ls = new ArrayList<>();
        for(Stats e : Stats.values()) if(e.tag == tg) ls.add(e);
        return ls;
    }

    public static String getString(Stats st){
        Object o = getRaw(st);
        if (o == null) return ""; 

        if(o instanceof Boolean) return ((Boolean) o).toString();
        
        // 1. On stocke la valeur sous forme de BigDecimal pour garder 100% de la précision
        java.math.BigDecimal bd = null;
        if (o instanceof java.math.BigDecimal bdValue) bd = bdValue;
        else if (o instanceof Double dValue) bd = java.math.BigDecimal.valueOf(dValue);
        else if (o instanceof Integer iValue) bd = java.math.BigDecimal.valueOf(iValue);
        else if (o instanceof Long lValue) bd = java.math.BigDecimal.valueOf(lValue);

        // Si on n'a pas pu en faire un nombre, on prend la String brute
        String numberStr = (bd != null) ? bd.stripTrailingZeros().toPlainString() : o.toString();

        // Cas des Statues
        if (st.tag == TagList.Statues && bd != null) {
            try {
                int i = bd.intValueExact(); // Plus propre et sécurisé
                return switch(i){
                    default -> "Not Owned";
                    case 1 -> "Base";
                    case 2 -> "Gilded";
                    case 3 -> "Platinized";
                };
            } catch (ArithmeticException e) {
                return "Unknown Statue"; // Si le nombre ne rentre pas dans un int
            }
        }
        
        // Application de la précision si demandée
        if (bd != null && precision > -1) {
            numberStr = Notation.getBestNotation(bd);
        }
        
        // 2. Traitement des suffixes
        if (st.name().endsWith("chance") || st.name().endsWith("percent")) {
            return numberStr + "%"; 
        }
        
        if ((st.name().endsWith("multiplier") || st.name().endsWith("multi") || st.name().endsWith("crit_damage") || st.name().endsWith("rate")) && bd != null) {
            return numberStr + "x";
        }
        
        if ((st.name().endsWith("reduction") || st.name().endsWith("requirement")) && bd != null && bd.compareTo(java.math.BigDecimal.ZERO) > 0 && bd.compareTo(java.math.BigDecimal.ONE) < 0){
            return numberStr + "x";
        }
        
        if (st.name().endsWith("seconds") || st.name().endsWith("second") && bd != null) {
            return numberStr + "s";
        }

        if (st.name().equals("time") && bd != null){
            return ShortDate.fromOADate(bd.doubleValue()).toString();
        }
        
        return numberStr;
    }

    public static Object getRaw(Stats st){
        if(st.value == null) st.value = r.get(st.toString());
        return st.value;
    }

    public static Object getRaw(Calc c){
        return calc.get(c.toString());
    }

    final String hardcoded_version = "2.2.6";

    public static String loadingText(){
        return "Loading a lot of elements!"+"\n"+
                "Converting "+Stats.values().length + " elements into a special file...\n"+
                "Calculating less than "+Calc.ESTIMATED_AMOUNT + " elements...\n"+
                "Ignoring a lot of the calculation! (95% at 0.0% of progression in game)\n"+
                "This loading screen is quicker for beginners!";
    }

    public static String getString(Calc c){
        Object o = getRaw(c);
        if (o == null) return ""; 

        if(o instanceof Boolean) return ((Boolean) o).toString();
        
        // 1. On stocke la valeur sous forme de BigDecimal pour garder 100% de la précision
        java.math.BigDecimal bd = null;
        if (o instanceof java.math.BigDecimal bdValue) bd = bdValue;
        else if (o instanceof Double dValue) bd = java.math.BigDecimal.valueOf(dValue);
        else if (o instanceof Integer iValue) bd = java.math.BigDecimal.valueOf(iValue);
        else if (o instanceof Long lValue) bd = java.math.BigDecimal.valueOf(lValue);

        String valueString = o.toString();
        String name = c.name();

        if (bd != null && precision > -1) {
            valueString = Notation.getBestNotation(bd);
        }

        if(name.endsWith("_multi") || c == Calc.star_chance_per_floor) return valueString+"x";
        if(name.startsWith("true_") && !name.contains("pickaxe_damage") || c == Calc.radiant_supernova_supergiant_star || c == Calc.rainbow_veins_rainbow_portal_rainbow_floor) return valueString+"%";
        if((name.startsWith("zone") || name.startsWith("world")) && (name.endsWith("veinseeker") || name.endsWith("vein") || name.endsWith("_double"))) return valueString+"%";
        if(name.startsWith("lootbugs")) return valueString+"s";



        return valueString;
    }

    public static Integer getRawInt(Stats st){
        Object o = getRaw(st);
        if(o instanceof Integer i) return i;
        if(o instanceof Double d) return d.intValue();
        if(o instanceof Long l) return l.intValue();
        return null;
    }

    public static Double getRawDouble(Stats st){
        Object o = getRaw(st);
        if(o instanceof Double d) return d;
        if(o instanceof Double i) return i.doubleValue();
        if(o instanceof Long l) return l.doubleValue();
        if(o instanceof BigDecimal db) return db.doubleValue();
        return null;
    }

    public static String getText(Stats st){
        return Texts.getText("stats", st.toString());
    }

    public static String getTextDesc(Stats st){
        return Texts.getText("stats", st.toString()+"_desc");
    }

    public static void convertJson(String json, int fileSave){
        long c = System.currentTimeMillis();


        String lastPath = "last.bdeko";

        // On efface le VRAI fichier cible avant extraction, pour éviter
        // qu'extractString ne saute l'écriture (cas EXISTS) sur un résidu d'un run précédent
        FileManage.eraseFile(lastPath);

        try{
            JsonDeko.extractString(json, "last");
        } catch(Exception e){
            System.out.println(e);
            return;
        }

        Restore r = new Restore(lastPath);
        //if(!r.getB("EXPORTSTATS")) return;

        if(r.getB("EXPORTSTATS"))
            {
                ShortDate sd = ShortDate.fromOADate((double) r.get("time"));
                r.add("timestamp", sd.getTimestamp(), "auto");
            }
        FileManage.deplacerFichier(lastPath, exported+"/"+fileSave+".bdeko");

        System.out.println("total: "+(System.currentTimeMillis()-c));
    }

    public static boolean checkSave(int x){
        List<String> elementInData = FileManage.listFileWithExtension(exported, ".bdeko");
        return elementInData.contains(x+".bdeko");
    }

    public static String getText(Calc c){
        return Texts.getText("calc", c.toString());
    }

    public static String getTextDesc(Calc c){
        return Texts.getText("calc", c.toString()+"_desc");
    }

    public static void loadRestore(int x){
        r = new Restore(exported+"/"+x+".bdeko");
    }

    public static void load(int x){
        Notation.scientificNotation = new Restore("settings.bdeko").getB("scientific");
        if(r == null) loadRestore(x);
        Calc.load(x);
        if(!calc.exists()) calculateAll();
        if(!r.exists()) {r = null; return;}
        if(r.check("precision")) precision = (int) r.get("precision");
    }

    public static void setPrecision(int setPrecision){
        if(r == null) {System.out.println("Erreur: Pas de Restore"); return;}
        r.replace("precision", setPrecision, "auto");
        precision = setPrecision;
    }

}
