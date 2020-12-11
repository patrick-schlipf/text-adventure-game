//*****************************************************************************
//*
//* FILE NAME:  BagEntry.java
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
//*            BagEntry   (externally documented: no )
//*
//* CHANGE HISTORY:
//*
//*   Change Date     UserID   Description
//*   -----  -------- -------- ------------------------------------------------
//*   y0001  28112020 psch     Initial Version
//*
//*****************************************************************************
package com.patrick.games.textadv.items;

public class BagEntry {

    private Item item;
    private Integer amount;

    public BagEntry(Item item) {
        this(item, 1);
    }

    public BagEntry(Item item, Integer amount) {
        this.item = item;
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public Integer getAmount() {
        return amount;
    }

    public BagEntry add(Integer amount) {
        this.amount += amount;
        return this;
    }

    public BagEntry addOne() {
        return this.add(1);
    }

    public BagEntry remove(Integer amount) {
        this.amount -= amount;
        return this;
    }

    public BagEntry removeOne() {
        return this.remove(1);
    }
}
