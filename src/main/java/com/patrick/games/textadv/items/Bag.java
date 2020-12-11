package com.patrick.games.textadv.items;

import com.patrick.games.textadv.units.AbstractCharacter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Bag extends AbstractItem {

    private Map<String, BagEntry> items = new LinkedHashMap<>();

    public Bag() {
        super("Bag", "A leather bag that holds your items.");

        this.add(new Potion());
        this.add(new Steroid());
    }

    public boolean contains(String itemName) {
        return items.containsKey(itemName);
    }

    public Item get(String itemName) {
        return items.get(itemName).getItem();
    }

    public Bag add(Item item) {
        BagEntry entry = this.items.get(item.getId());

        if (Objects.isNull(entry)) {
            this.items.put(item.getId(), new BagEntry(item));
        } else {
            this.items.replace(item.getId(), entry.addOne());
        }

        return this;
    }

    public Bag remove(Item item) {
        BagEntry entry = this.items.get(item.getId());

        if (item instanceof Consumable) {
            if (entry.getAmount() <= 1) {
                this.items.remove(item.getId());
            } else {
                this.items.replace(item.getId(), entry.removeOne());
            }
        }

        return this;
    }

    public void use(AbstractCharacter character) {
        System.out.println("----------------------------------------------");
        System.out.println("Bag:");

        items.entrySet()
                .stream()
                .sequential()
                .forEach((entry) -> {
                    BagEntry bagEntry = entry.getValue();
                    Item item = bagEntry.getItem();

                    System.out.println(" > " + item.getName() + " - x" + bagEntry.getAmount() + " - " + item.getDescription());
                });

        System.out.println();
    }
}
