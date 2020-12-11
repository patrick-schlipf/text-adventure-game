//*****************************************************************************
//*
//* FILE NAME:  Steroid.java
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
//*            Steroid   (externally documented: no )
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
