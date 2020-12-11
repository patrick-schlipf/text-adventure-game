package com.patrick.games.textadv.items;

import com.patrick.games.textadv.units.AbstractCharacter;

public class Potion extends AbstractItem implements Consumable {

    public Potion() {
        super("Potion", "Heals the character for 20 HP.");
    }

    public void use(AbstractCharacter character) {
        Integer heal = 20;
        character.adjustHealthPoints(heal);
        System.out.println("You feel better now. (Healed for +" + heal + ")");
    }
}
