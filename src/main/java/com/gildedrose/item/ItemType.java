package com.gildedrose.item;

public abstract class ItemType {

    protected String name;

    protected int sellIn;

    protected int quality;

    public ItemType(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    abstract void updateQuality();


}
