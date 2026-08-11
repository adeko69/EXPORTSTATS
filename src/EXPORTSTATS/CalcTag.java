package EXPORTSTATS;

import pkg.Drones;

public enum CalcTag {
    Floors,
    Veins(pkg.Pickaxe.obelisk >= 19),
    Lootbugs,
    Star(pkg.Pickaxe.obelisk >= 23),
    Lootfrogs((int) EXPORTSTATS.getRawInt(Stats.lootfrogs_caught) > 0),
    Pickaxe,
    Stonks((Double) EXPORTSTATS.getRaw(Stats.stonks_chance) > 0.0),
    Bomb_Bear(Drones.Bomb_Bear.grade != 0), Chain_Bomber(Drones.Chain_Bomber.grade != 0), 
    Midas(Drones.Midas.grade != 0), Frogger(Drones.Frogger.grade != 0), 
    Veinseeker(Drones.Veinseeker.grade != 0), 
    Starburst(Drones.Starburst.grade != 0), Elixir(Drones.Elixir.grade != 0), 
    Void(Drones.Void.grade != 0), Angler(Drones.Angler.grade != 0), 
    Prism(Drones.Prism.grade != 0), Minotaur(Drones.Minotaur.grade != 0),
    Gifts();

    boolean show = true;

    CalcTag(boolean show) {
        this.show = show;
    }

    CalcTag() {
    }
}
