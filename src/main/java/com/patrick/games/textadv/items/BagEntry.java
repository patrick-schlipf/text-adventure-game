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
