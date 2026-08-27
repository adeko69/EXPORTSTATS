package EXPORTSTATS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import adeko.FM.ConfigManage;
import adeko.deko.Crash;
import adeko.deko.Restore;
import adeko.deko.WhoAmI;
import adeko.text.Conversion;
import adeko.text.Texts;
import adeko.utils.Console;
import pkg.Gift;

/**
 * Décrivez votre classe Main ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Main
{
    public static Crash c = new Crash();
    public static long seed = new Random().nextLong();
    public static RandomGenerator placement = RandomGeneratorFactory.of("L64X128MixRandom").create(seed);

    public static String toJson(int set) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < set-1; i++) {
            if(i != 0) sb.append(", ");
            sb.append("\n").append("\"id").append(i).append("\":").append(set);
        }
        sb.append("\n}");

        return sb.toString();
    }

    public static void start() {
        System.setProperty("sun.java2d.dpiaware", "false");

        EXPORTSTATS.setLanguageManage("texts", "en");

        new Restore("settings.bdeko", WhoAmI.SETTINGS);  

        //Conversion.copyToClipboard(toJson(2483642));

        EXPORTSTATS.convertJson(Conversion.getClipboardText(),1);

        List<String> ls = EXPORTSTATS.getAllData();
        
        //Restore.compare(new Restore(EXPORTSTATS.exported+"/"+ls.get(0)), new Restore(EXPORTSTATS.exported+"/"+ls.get(1)));

        System.out.println(ls);//[0.bdeko, 1.bdeko, 2.bdeko]


        int h = Console.list(ls);//[0/0]
        
        EXPORTSTATS.load(h);

        if(!EXPORTSTATS.r.check("precision")) EXPORTSTATS.precision = 2;
        else EXPORTSTATS.precision = (int) EXPORTSTATS.r.get("precision");

        Long l = System.currentTimeMillis();
        EXPORTSTATS.calculateAll();

        double total = Gift.high_relic.trueChance()*100;

        for(Gift f : Gift.values()){
            double truechance = f.trueChance()*100;
            System.out.println(f.name()+" Chances: "+truechance+"%");
            if(truechance > 50) continue;
            else total += truechance;
        }
        System.out.println("gift chances total: "+ total);
        
        System.out.println("time: " + (System.currentTimeMillis()-l));

        System.out.println("Calc is "+Calc.values().length+ " element long");
        System.out.println("Restore.Calc is "+EXPORTSTATS.calc.list().size()+ " element long");
        List<String> contained = EXPORTSTATS.r.list();

        List<String> st = Arrays.stream(Stats.values())
                        .map(Enum::name) 
                        .toList();

        List<Stats> stats = new ArrayList<Stats>(Arrays.asList(Stats.values()));
        contained.removeAll(st);

        for(Stats s : stats){
            if(s.tag == TagList.Drone_Unlock){
                //System.out.println(s.toString()+": "+s.toString());
                //System.out.println(s.toString()+"_desc: ");
            }
        }
        for(String s : contained){
            System.out.print(s+"(TagList.),");
        }

        if(ConfigManage.isAdmin()){
            for(String c : contained){
                
                if(Stats.valueOf(c) == null){
                    System.out.println(c);
                } else {
                    //st.remove(Stats.valueOf(c));
                }
            }
            //System.out.println(st);
            for(Stats _ : Stats.values()){
                //if(Stats.pickaxe_damage == e) 
                    //System.out.println(e+": "+EXPORTSTATS.getString(e));
            }

            boolean b = true;
            for(String s : EXPORTSTATS.r.list("null")){
                try{
                    Stats.valueOf(s);
                } catch(Exception e){
                    if(!b)Console.clear();
                    System.out.print(s+"(),");
                    b = true;
                }        
            }
            if(b) Console.getScan();
        }
        helpMessage();

        

        while(true){
            String s = Console.getScan().toLowerCase();

            if(s.equals("clear")) helpMessage();
            if(s.equals("precision")) System.out.println("Current precision: "+EXPORTSTATS.precision);
            else {
                List<String> eg = EXPORTSTATS.getSimilarName(s);
                if(eg.size() > 1) {System.out.println("Try to be more precise!");
                System.out.println(eg);}
                else if(eg.size() == 1) try{
                    System.out.println(Texts.getText("stats", eg.get(0)+"_desc")+" ("+ Texts.getText("stats", eg.get(0)) +"): "+EXPORTSTATS.getString(Stats.valueOf(eg.get(0))));
                    System.out.println("textV2: "+EXPORTSTATS.getText(Stats.valueOf(eg.get(0))));
                } catch(Exception e){
                    System.out.println(eg.get(0) +": "+EXPORTSTATS.r.get(eg.get(0)));
                }
                else System.out.println("<r>Unknown<>");
            }
        }
    }

    public static void helpMessage(){
        Console.clear();
        System.out.println("If empty, try looking for some stats! (\"drone\", \"bomb\", \"lootbug\")");
        System.out.println("Type \"clear\": Clear the console. Put back the help message");
    }

    /**
     * Lance l'application
     *
     * @param args Un paramètre quelquonque
     */
    public static void main(String[] args) {
        start();
    }
}
