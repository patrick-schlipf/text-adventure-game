package com.patrick.games.textadv.units;

public interface Character {

    String getName();

    void attack(Character enemy);

    void displayStats();

    boolean isDead();
}
