package com.patrick.games.textadv.items;

import com.patrick.games.textadv.units.AbstractCharacter;

public interface Item {

    void use(AbstractCharacter character);

    String getId();

    String getName();

    String getDescription();
}
