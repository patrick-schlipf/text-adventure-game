//*****************************************************************************
//*
//* FILE NAME:  Launcher.java
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
//*            Launcher   (externally documented: no )
//*
//* CHANGE HISTORY:
//*
//*   Change Date     UserID   Description
//*   -----  -------- -------- ------------------------------------------------
//*   y0001  27112020 psch     Initial Version
//*
//*****************************************************************************
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
