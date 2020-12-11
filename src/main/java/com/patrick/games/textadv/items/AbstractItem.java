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
