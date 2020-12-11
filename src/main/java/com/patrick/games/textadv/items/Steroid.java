package com.patrick.games.textadv.items;

import com.patrick.games.textadv.units.AbstractCharacter;

public class Steroid extends AbstractItem implements Consumable {

    public Steroid() {
        super("Steroid", "Boots your Attack stat by 25%.");
    }

    public void use(AbstractCharacter character) {
        Integer boost = Math.round(character.getAttackPoints() * 0.25f);
        character.adjustAttackPoints(boost);
        System.out.println("You feel powerful. (Attack raised by +" + boost + ")");
    }
}
