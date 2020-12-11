package com.patrick.games.textadv.units;

import java.util.Objects;
import java.util.Random;

public abstract class AbstractCharacter implements Character {

    private String name;

    private Integer healthPoints;
    private Integer attackPoints;
    private Integer defensePoints;
    private Integer dodgeChance;

    private Random random = new Random();

    protected AbstractCharacter(String name,
                                Integer healthPoints,
                                Integer attackPoints,
                                Integer defensePoints,
                                Integer dodgeChance) {
        this.name = name;

        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.dodgeChance = dodgeChance;
    }

    public void attack(Character enemy) {
        this.attack((AbstractCharacter) enemy);
    }

    public void attack(AbstractCharacter enemy) {
        if (enemy.hasDodged()) {
            System.out.println(enemy.name + " dodged the attack.");
            return;
        }

        Integer damage = this.calculateDamage(enemy);
        enemy.adjustHealthPoints(damage * -1);
        System.out.println(enemy.name + " took " + damage + " points of damage.");
    }

    protected boolean hasDodged() {
        return random.nextInt(100) + 1 < this.getDodgeChance();
    }

    protected Integer calculateDamage(AbstractCharacter enemy) {
        return Math.round(this.getAttackPoints() * (1 - (enemy.getDefensePoints() / 100.f)));
    }

    public void displayStats() {
        System.out.println("----------------------------------------------");
        System.out.println("Name: " + this.name);
        System.out.println("HP  : " + this.healthPoints);
        System.out.println("ATK : " + this.attackPoints);
        System.out.println("DEF : " + this.defensePoints);
    }

    public boolean isDead() {
        return this.healthPoints <= 0;
    }

    //region # Getter & Setter
    public String getName() {
        return name;
    }

    public AbstractCharacter setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public AbstractCharacter setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
        return this;
    }

    public AbstractCharacter adjustHealthPoints(Integer healthPoints) {
        if (Objects.isNull(healthPoints)) {
            System.out.println("Nothing happened.");
        }

        this.healthPoints += healthPoints;

        if (this.healthPoints > 100) {
            this.healthPoints = 100;

        } else if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }

        return this;
    }

    public Integer getAttackPoints() {
        return attackPoints;
    }

    public AbstractCharacter setAttackPoints(Integer attackPoints) {
        this.attackPoints = attackPoints;
        return this;
    }

    public AbstractCharacter adjustAttackPoints(Integer attackPoints) {
        if (Objects.isNull(attackPoints)) {
            System.out.println("Nothing happened.");
        }

        this.attackPoints += attackPoints;

        if (this.attackPoints < 0) {
            this.attackPoints = 0;
        }

        return this;
    }

    public Integer getDefensePoints() {
        return defensePoints;
    }

    public AbstractCharacter setDefensePoints(Integer defensePoints) {
        this.defensePoints = defensePoints;
        return this;
    }

    public AbstractCharacter adjustDefensePoints(Integer defensePoints) {
        if (Objects.isNull(defensePoints)) {
            System.out.println("Nothing happened.");
        }

        this.defensePoints += defensePoints;

        if (this.defensePoints < 0) {
            this.defensePoints = 0;
        }

        return this;
    }

    public Integer getDodgeChance() {
        return dodgeChance;
    }

    public AbstractCharacter setDodgeChance(Integer dodgeChance) {
        this.dodgeChance = dodgeChance;
        return this;
    }

    public AbstractCharacter adjustDodgeChance(Integer dodgeChance) {
        if (Objects.isNull(dodgeChance)) {
            System.out.println("Nothing happened.");
        }

        this.dodgeChance += dodgeChance;

        if (this.dodgeChance > 100) {
            this.dodgeChance = 100;

        } else if (this.dodgeChance < 0) {
            this.dodgeChance = 0;
        }

        return this;
    }

    //endregion
}
