//*****************************************************************************
//*
//* FILE NAME:  AbstractItem.java
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
//*            AbstractItem   (externally documented: no )
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

import java.util.StringJoiner;

public abstract class AbstractItem implements Item {

    protected final String id;
    protected final String name;
    protected final String description;

    protected AbstractItem(String name, String description) {
        this.id = name.toUpperCase();
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AbstractItem.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .toString();
    }

    public abstract void use(AbstractCharacter character);
}
