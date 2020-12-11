//*****************************************************************************
//*
//* FILE NAME:  Fight.java
//*
//* IBM Confidential
//*
//*  OCO Source Materials
//*
//*  5698-SA4
//*
//*  © Copyright IBM Corp. 2020
//*
//*   The source code for this program is not published or otherwise
//*   divested of its trade secrets, irrespective of what has been
//*   deposited with the U.S. Copyright Office.
//*
//*****************************************************************************
//*
//* CLASSES:
//*            Fight   (externally documented: no )
//*
//* CHANGE HISTORY:
//*
//*   Change Date     UserID   Description
//*   -----  -------- -------- ------------------------------------------------
//*   y0001  28112020 psch     Initial Version
//*
//*****************************************************************************
package com.patrick.games.textadv.actions;

import com.patrick.games.textadv.units.Character;
import com.patrick.games.textadv.units.PlayableCharacter;
import com.patrick.games.textadv.units.Player;

import java.util.Random;
import java.util.Scanner;

import static com.patrick.games.textadv.units.Player.Action.*;

public class Fight {

    private final PlayableCharacter player;
    private final Character enemy;
    private final Scanner input = new Scanner(System.in);

    private boolean playerEscaped = false;

    public Fight(PlayableCharacter player, Character enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void start() {
        while (!this.isOver()) {
            player.displayStats();
            enemy.displayStats();

            System.out.println();
            System.out.println("----------------------------------------------");
            System.out.println("What do you do?");
            System.out.println(" - Attack");
            System.out.println(" - Bag <list>");
            System.out.println(" - Use <item>");
            System.out.println(" - Run");
            System.out.println();

            Player.Action action = null;
            System.out.print("Action: ");
            String playerInput = input.nextLine().toUpperCase();
            try {
                String command = (playerInput.contains(" "))
                        ? playerInput.substring(0, playerInput.indexOf(" "))
                        : playerInput;

                action = Player.Action.valueOf(command);
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid action: " + playerInput);
                System.out.println();
                continue;
            }

            System.out.println();
            System.out.println("----------------------------------------------");

            if (ATTACK.equals(action)) {
                System.out.println("You attack first.");
                player.attack(enemy);

                if (!enemy.isDead()) {
                    System.out.println("The " + enemy.getClass().getSimpleName() + " thirsts for revenge!");
                    enemy.attack(player);
                }
            }

            if (BAG.equals(action)) {
                player.showBag();
            }

            if (USE.equals(action)) {
                if (!playerInput.contains(" ")) {
                    System.out.println("No item given.");
                    continue;
                }

                String itemName = playerInput.substring(playerInput.indexOf(" ") + 1).trim();
                if ("BAG".equalsIgnoreCase(itemName)) {
                    player.showBag();

                } else if (!player.getBag().contains(itemName)) {
                    System.out.println("You don't have this item.");

                } else {
                    player.useItem(itemName);

                    enemy.attack(player);
                }
            }

            if (RUN.equals(action)) {
                boolean isSuccessful = this.runFromBattle();
                if (isSuccessful) {
                    this.playerEscaped = true;
                } else {
                    System.out.println("You were too slow.");
                    System.out.println("The " + enemy.getClass().getSimpleName() + " already blocked your escape route.");
                    System.out.println("Before you could react, the " + enemy.getClass().getSimpleName() + " swung its weapon");
                    this.playerEscaped = false;
                    enemy.attack(player);
                }
            }
        }

        this.endFight();

    }

    private void endFight() {
        if (this.playerEscaped) {
            System.out.println("You are too scared to fight the creepy " + enemy.getClass().getSimpleName() + ".");
            System.out.println("Quickly you turn around and start running without looking back.");
            System.out.println("After a few minutes you feel exhausted and stopped running.");
            System.out.println("You have no idea where you are.");

        } else if (player.isDead()) {
            System.out.println("You died.");

        } else if (enemy.isDead()) {
            System.out.println(enemy.getName() + " died.");
        }
    }

    private boolean runFromBattle() {
        return (new Random().nextInt(100) + 1 < 25);
    }

    public boolean isOver() {
        return this.playerEscaped || player.isDead() || enemy.isDead();
    }
}
