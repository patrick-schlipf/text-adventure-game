//*****************************************************************************
//*
//* FILE NAME:  Potion.java
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
//*            Potion   (externally documented: no )
//*
//* CHANGE HISTORY:
//*
//*   Change Date     UserID   Description
//*   -----  -------- -------- ------------------------------------------------
//*   y0001  28112020 psch     Initial Version
//*
//*****************************************************************************
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
