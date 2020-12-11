package com.patrick.games.textadv.units;

import com.patrick.games.textadv.items.Bag;

public interface PlayableCharacter extends Character {

    Bag getBag();

    void showBag();

    void useItem(String itemName);
}
