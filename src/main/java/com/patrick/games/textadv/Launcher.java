package com.patrick.games.textadv;

import com.patrick.games.textadv.actions.Fight;
import com.patrick.games.textadv.units.Player;
import com.patrick.games.textadv.units.Skeleton;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {

        Player player;
        Scanner input = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = input.nextLine();
        player = new Player(name);

        player.displayStats();
        System.out.println();
        System.out.println("Press <ENTER> to continue!");
        input.nextLine();

        System.out.println("You enter the dungeon.");
        System.out.println("There is a spiral staircase leading into an old and abandoned prison.");
        System.out.println("A skeleton blocks the entry.");
        System.out.println("You have to fight your way through.");

        System.out.println();
        System.out.println("Press <ENTER> to start the fight!");
        input.nextLine();

        new Fight(player, new Skeleton()).start();
    }
}
