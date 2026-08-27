package pkg;

import EXPORTSTATS.EXPORTSTATS;
import EXPORTSTATS.Stats;

public enum Gift {
    low_gems(),mid_gems(),high_gems(),skill_shard(),cherry_bomb(),low_relic(),high_relic(),  
    star_spawn(35), gifts(40), base_gems(45),t2_items(37), fuel(30), idol_token(33),rare_sushi_low(45),mythic_chest(100),
    Gem_Chest(25),Relic_Chest(125), Frogspawn(25), Cosmic_Candy(30),Stickers(85),ButteryLobster(250),
    rare_sushi_high(175),MEGA_gems(250),forbidden_sushi(1000),Skin(200),Gilded_Skin(2000),Divine_Chest(2500);

    final int isRare;
    double trueChance = -2.0;

    Gift(int chances){
        this.isRare = chances;
    }

    Gift(){
        isRare = 1;
    }

    public double overwriteChances(){
        double chance = 1.0; // produit des (1 - p_j) pour tous les items après "this"
        switch(this){
            default:
                if(Pickaxe.obelisk >= 30 && Pickaxe.obelisk <= 59) chance *= (1 - 1.0/star_spawn.isRare);   // gifts
            case star_spawn:
                chance *= (1 - 1.0/gifts.isRare);   // gifts
                if(this == star_spawn && (Pickaxe.obelisk < 30 || Pickaxe.obelisk > 59)) return -1;
            case gifts:
                chance *= (1 - 1.0/base_gems.isRare);   // base_gems
            case base_gems:
                if(Pickaxe.obelisk >= 37)chance *= (1 - 1.0/t2_items.isRare);   // t2_items
            case t2_items:
                if(this == t2_items && Pickaxe.obelisk < 37) return -1;
                chance *= (1 - 1.0/fuel.isRare);   // fuel
            case fuel:
                if(Pickaxe.obelisk >= 30) chance *= (1 - 1.0/idol_token.isRare);   // idol_token
            case idol_token:
                if(this == idol_token && Pickaxe.obelisk < 30) return -1;
                if(Pickaxe.obelisk >= 37) chance *= (1 - 1.0/rare_sushi_low.isRare);   // rare_sushi_low
            case rare_sushi_low:
                if(this == rare_sushi_low && Pickaxe.obelisk < 37) return -1;
                chance *= (1 - 1.0/mythic_chest.isRare);  // mythic_chest
            case mythic_chest:
                if(Pickaxe.obelisk >= 60) chance *= (1 - 1.0/Gem_Chest.isRare);   // Gem_Chest
            case Gem_Chest:
                if(this == Gem_Chest && Pickaxe.obelisk < 60) return -1;
                if(Pickaxe.obelisk >= 60) chance *= (1 - 1.0/Relic_Chest.isRare);  // Relic_Chest
            case Relic_Chest:
                if(this == Relic_Chest && Pickaxe.obelisk < 60) return -1;
                if(EXPORTSTATS.getRawInt(Stats.lootfrogs_caught) > 0) chance *= (1 - 1.0/Frogspawn.isRare);   // Frogspawn
            case Frogspawn:
                if(this == Frogspawn && EXPORTSTATS.getRawInt(Stats.lootfrogs_caught) == 0) return -1;
                if(Pickaxe.obelisk >= 60) chance *= (1 - 1.0/Cosmic_Candy.isRare);   // Cosmic_Candy
            case Cosmic_Candy:
                if(this == Cosmic_Candy && Pickaxe.obelisk < 60) return -1;
                if(Pickaxe.obelisk >= 3) chance *= (1 - 1.0/Stickers.isRare);   // Stickers
            case Stickers:
                if(this == Stickers && Pickaxe.obelisk < 3) return -1;
                chance *= (1 - 1.0/ButteryLobster.isRare);  // ButteryLobster
            case ButteryLobster:
                if(Pickaxe.obelisk >= 37) chance *= (1 - 1.0/rare_sushi_high.isRare);  // rare_sushi_high
            case rare_sushi_high:
                if(this == rare_sushi_high && Pickaxe.obelisk < 37) return -1;
                if(Pickaxe.obelisk >= 70) chance *= (1 - 1.0/MEGA_gems.isRare);  // MEGA_gems
            case MEGA_gems:
                if(this == MEGA_gems && Pickaxe.obelisk < 70) return -1;
                if(Pickaxe.obelisk >= 60) chance *= (1 - 1.0/forbidden_sushi.isRare); // forbidden_sushi
            case forbidden_sushi:
                if(this == forbidden_sushi && Pickaxe.obelisk < 60) return -1;
                chance *= (1 - 1.0/Skin.isRare);  // Skin
            case Skin:
                chance *= (1 - 1.0/Gilded_Skin.isRare); // Gilded_Skin
            case Gilded_Skin:
                chance *= (1 - 1.0/Divine_Chest.isRare); // Divine_Chest
            case Divine_Chest:
                break; // rien après → pas d'overwrite possible
        }
        return 1 - chance;
    }

    public double trueChance(){
        if(trueChance != -2.0) return trueChance;
        double p_x = 1.0 / this.isRare;          // proba que X arrive tout seul
        double overwrite = overwriteChances();
        if(overwrite == -1) return 0;
        double survivalProb = 1 - overwrite; // proba qu'aucun item plus rare n'arrive après
        trueChance = p_x * survivalProb;
        return p_x * survivalProb;
    }

    

    public int howMuch(boolean max){
        int relic_mult = Pickaxe.obelisk >= 64?3:1;
        int shard_mult = Pickaxe.obelisk >= 60?2:1;
        shard_mult *= Pickaxe.obelisk >= 64?2:1;
        shard_mult *= Pickaxe.obelisk >= 70?3:1;
        int gem_mult = Pickaxe.obelisk >= 64?3:1;

        switch(this){
            default: return -1;
            case fuel:
                if(max) return (int) 41+Math.round((Pickaxe.obelisk-18)*2)+10;
                else return (int) 41+Math.round((Pickaxe.obelisk-18)*2)-10;
            case base_gems:
                if(max) return (int) (130*(1+Pickaxe.obelisk*0.08))*gem_mult;
                else return (int) (80*(1+Pickaxe.obelisk*0.08))*gem_mult;
            case mid_gems:
                if(max) return (int) (50*(1+Pickaxe.obelisk*0.08))*gem_mult;
            case low_gems:
                if(max) return (int) (40*(1+Pickaxe.obelisk*0.08))*gem_mult;
                else return (int) (20*(1+Pickaxe.obelisk*0.08))*gem_mult;
            case high_gems:
                if(max) return (int) (150*(1+Pickaxe.obelisk*0.08))*gem_mult;
                else return (int) (90*(1+Pickaxe.obelisk*0.08))*gem_mult;
            case cherry_bomb:
                if(max) return 2750*((Pickaxe.obelisk-36)/6);
                else return (int) 1500*((Pickaxe.obelisk-36)/6);
            case skill_shard:
                if(max) return (int) (5*(1+Pickaxe.obelisk*0.08))*shard_mult;
                else return (int) (2*(1+Pickaxe.obelisk*0.08))*shard_mult;
            case low_relic:
                if(max) return (int) (5*(1+Pickaxe.obelisk*0.08))*relic_mult;
                else return (int) (3*(1+Pickaxe.obelisk*0.08))*relic_mult;
            case high_relic:
                if(max) return (int) (10*(1+Pickaxe.obelisk*0.08))*relic_mult;
                else return (int) (5*(1+Pickaxe.obelisk*0.08))*relic_mult;
        }
    }
}
