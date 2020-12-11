//*****************************************************************************
//*
//* FILE NAME:  Player.java
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
//*            Player   (externally documented: no )
//*
//* CHANGE HISTORY:
//*
//*   Change Date     UserID   Description
//*   -----  -------- -------- ------------------------------------------------
//*   y0001  28112020 psch     Initial Version
//*
//*****************************************************************************
package com.patrick.games.textadv.units;

import com.patrick.games.textadv.items.Bag;
import com.patrick.games.textadv.items.Item;

public class Player extends AbstractCharacter implements PlayableCharacter {

    private Bag bag = new Bag();

    public Player(String name) {
        super(name, 100, 25, 25, 10);
    }

    @Override
    public void showBag() {
        this.bag.use(this);
    }

    public Bag getBag() {
        return bag;
    }


    public void useItem(String itemName) {
        itemName = itemName.toUpperCase();

        if (this.bag.contains(itemName)) {
            Item item = this.bag.get(itemName);
            item.use(this);
            this.bag.remove(item);
        } else {
            System.out.println("You don't have this item.");
        }
    }

    public enum Action {
        ATTACK,
        BAG,
        USE,
        RUN
    }
}
