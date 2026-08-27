package EXPORTSTATS;


public enum CalcTag {
    Floors,
    Veins(),
    Veins_Per_Zone(CalcTag.Veins),
    Veins_Multi(CalcTag.Veins),
    Lootbugs,
    Star(),
    Lootfrogs(),
    Obelisk,
    General(CalcTag.Obelisk),
    Obelisk_Life(CalcTag.Obelisk),
    Damage(CalcTag.Obelisk),
    Freebies(),
    Stonks(CalcTag.Freebies),
    Gifts_in_Freebies(CalcTag.Freebies),
    Drones(),
    Bomb_Bear(CalcTag.Drones),Chain_Bomber(CalcTag.Drones) ,
    Midas(CalcTag.Drones), Frogger(CalcTag.Drones), 
    Veinseeker(CalcTag.Drones), 
    Starburst(CalcTag.Drones), Elixir(CalcTag.Drones), 
    Void(CalcTag.Drones), Angler(CalcTag.Drones), 
    Prism(CalcTag.Drones), Minotaur(CalcTag.Drones),
    Gifts(),Base(CalcTag.Gifts),
    Drop_rare(CalcTag.Gifts), rare_overwritten(CalcTag.Gifts);

    public boolean show = true;
    public boolean hasSub = false;
    public CalcTag isSub = null;

    public void show(){
        if(isSub != null && !isSub.show) show = false;
        show = switch(this){
            case Veins ->  pkg.Pickaxe.obelisk >= 19;
            case Star -> pkg.Pickaxe.obelisk >= 23;
            case Lootfrogs -> (int) EXPORTSTATS.getRawInt(Stats.lootfrogs_caught) > 0;
            case Freebies -> (Double) EXPORTSTATS.getRaw(Stats.stonks_chance) > 0.0;
            case Gifts_in_Freebies -> EXPORTSTATS.getRawDouble(Stats.statue_8_set2) != 0.0;
            case Bomb_Bear -> pkg.Drones.Bomb_Bear.grade != 0;
            case Chain_Bomber -> pkg.Drones.Chain_Bomber.grade != 0;
            case Midas -> pkg.Drones.Midas.grade != 0;
            case Frogger -> pkg.Drones.Frogger.grade != 0;
            case Veinseeker -> pkg.Drones.Veinseeker.grade != 0;
            case Starburst -> pkg.Drones.Starburst.grade != 0;
            case Elixir -> pkg.Drones.Elixir.grade != 0;
            case Void -> pkg.Drones.Void.grade != 0;
            case Angler -> pkg.Drones.Angler.grade != 0;
            case Prism -> pkg.Drones.Prism.grade != 0;
            case Minotaur -> pkg.Drones.Minotaur.grade != 0;
            default -> true;
        };

    }

    CalcTag(CalcTag isSub){
        this.isSub = isSub;
        isSub.hasSub = true;
    }

    CalcTag() {
    }
    
    
}
