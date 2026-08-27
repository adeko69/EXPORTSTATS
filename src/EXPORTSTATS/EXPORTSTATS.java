package EXPORTSTATS;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adeko.FM.FileManage;
import adeko.FM.LanguageManage;
import adeko.deko.JsonDeko;
import adeko.deko.Lambda;
import adeko.deko.Message;
import adeko.deko.Restore;
import adeko.deko.WhoAmI;
import adeko.text.Texts;
import adeko.types.ShortDate;
import pkg.As;


public class EXPORTSTATS {
    static String exported = "EXPORTDATA";
    public static Restore r;
    public static Restore calc;

    //PRECISION CUT THE DECIMAL PLACES OF THE NUMBERS, -1 = NO CUT
    public static int precision = 3;
    final static String hardcoded_version = "v2.2.6";
    final static int hardcoded_calc_version = 0;
    static Message message = Message.OK;
    

    private static void ensureSettingsLoaded(){
        if(Restore.getSave(WhoAmI.SETTINGS) == null) new Restore("settings.bdeko", WhoAmI.SETTINGS);
    }

    public static void showScience(boolean set){
        ensureSettingsLoaded();
        Restore r = Restore.getSave(WhoAmI.SETTINGS);
        r.add("scientific", set);
        Notation.scientificNotation = set;
    }

    public static void trueTimer(boolean set){
        ensureSettingsLoaded();
        Restore.getSave(WhoAmI.SETTINGS).add("trueTimer", set);
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

        for(Calc c : Calc.list()) {
            if(c.show()) {
                getCalc(c);
            }
        }
        calc.add("calc_version", hardcoded_calc_version, "auto");
    }

    public static Object getCalc(Calc c){
        if(calc == null) return null;
        Object cached = calc.get(c.toString());
        if (cached != null) return cached;
        if (!c.tag.show || !c.show()) return null;

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
        if (st.as == As.STATUE) {
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
        if (st.as == As.P || st.as == As.PERCENT) {
            return numberStr + "%"; 
        }

        else if (st.as == As.T || st.as == As.TIMES){
            return numberStr + "x";
        }
        
        else if (st.as == As.S || st.as == As.SECONDS) {
            return numberStr + "s";
        }

        else if (st.as == As.SPECIAL_TIME){
            return ShortDate.fromOADate(bd.doubleValue()).toString();
        }

        if (st.as == As.N || st.as == As.NONE){
            return numberStr.endsWith(".0")?numberStr.substring(0,numberStr.lastIndexOf(".")):numberStr;
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

    

    public static String loadingText(){
        Lambda lb = new Lambda();
        lb.add("version", hardcoded_version);
        if(r != null) lb.add("game_version", r.get("version"));
        else lb.add("game_version", "{Message.TOO_EARLY}");
        lb.add("stats", Stats.values().length);
        lb.add("calc", Calc.values().length);
        return Texts.getText("message", message.name(), lb);
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

        

        String numberStr = o.toString();

        if (c.as == As.S || c.as == As.SECONDS) {
            return getTimeSecond(numberStr);
        }

        // Application de la précision si demandée
        if (bd != null && precision > -1) {
            numberStr = Notation.getBestNotation(bd);
        }
        
        // 2. Traitement des suffixes
        if (c.as == As.P || c.as == As.PERCENT) {
            return numberStr + "%"; 
        }

        else if (c.as == As.T || c.as == As.TIMES){
            return numberStr + "x";
        }

        else if (c.as == As.SPECIAL_TIME){
            return ShortDate.fromOADate(bd.doubleValue()).toString();
        }

        if (c.as == As.N || c.as == As.NONE){
            return numberStr.endsWith(".0")?numberStr.substring(0,numberStr.lastIndexOf(".")):numberStr;
        }



        return numberStr;
    }

    public static String getTimeSecond(String valueString){
        int seconds;
        try {
            seconds = Integer.parseInt(valueString);
        } catch (NumberFormatException e1) {
            try {
                double d = Double.parseDouble(valueString);
                if (!Double.isFinite(d)) return valueString;
                seconds = (int) Math.floor(d);
            } catch (NumberFormatException e2) {
                return valueString;
            }
        }

        if (Restore.getSave(WhoAmI.SETTINGS).getB("trueTimer")) {
            Double speed = getRawDouble(Stats.game_speed_multi);
            if (speed != null && speed != 0.0) {
                seconds = (int) Math.floor(seconds / speed);
            }
        }

        int days = seconds / 86400;
        int hours = (seconds % 86400) / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;

        StringBuilder sb = new StringBuilder();
        if (days > 0) sb.append(days).append("d");
        if (hours > 0) sb.append(hours).append("h");
        if (minutes > 0) sb.append(minutes).append("m");
        if (secs > 0 || sb.length() == 0) sb.append(secs).append("s");

        return sb.toString();
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
        if(!r.exists()){
            message = Message.NOT_FOUND;
        } else {
            Calc.load(x);
            if(!calc.exists()){
                message = Message.NOT_FOUND;
            } else {
                if(!calc.check("calc_version")) calc.add("calc_version",-1,"auto");
                if(((int) calc.get("calc_version")) != hardcoded_calc_version){
                    message = Message.INVALID;
                }
                if(!r.get("version").equals(hardcoded_version)) message = Message.PARTIALLY_OK;
            }
        }
    }

    public static void load(int x){
        ensureSettingsLoaded();
        Notation.scientificNotation = Restore.getSave(WhoAmI.SETTINGS).getB("scientific");
        if(r == null) loadRestore(x);
        for(CalcTag ct : CalcTag.values())
            ct.show();
        
        if(!calc.exists()) 
            calculateAll();
        else{
            if(((int) calc.get("calc_version")) != hardcoded_calc_version){
                try{
                    FileManage.eraseFile(EXPORTSTATS.exported+"/"+x+"_calc.bdeko");
                } catch (Exception e){
                }
                Calc.load(x);
                calculateAll();
            }
        }
        if(!r.exists()) {r = null; return;}
        if(r.check("precision")) precision = (int) r.get("precision");
    }

    public static void setPrecision(int setPrecision){
        if(r == null) {System.out.println("Erreur: Pas de Restore"); return;}
        r.replace("precision", setPrecision, "auto");
        precision = setPrecision;
    }

}
