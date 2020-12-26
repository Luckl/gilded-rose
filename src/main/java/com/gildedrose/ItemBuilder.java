package com.gildedrose;

import static com.gildedrose.ItemTypes.*;

public class ItemBuilder {

    public static Item createItem(final String name, final int sellIn, final int quality) {
        if (AGED_BRIE.equals(name)) {
            return createAgedBrie(sellIn, quality);
        } else if (BACKSTAGE_PASSES.equals(name)) {
            return createBackstagePasses(sellIn, quality);
        } else if (SULFURAS.equals(name)) {
            return createSulfuras();
        } else {
            return new Item(name, sellIn, quality);
        }
    }

    public static Item createSulfuras() {
        return new Item(SULFURAS, 0, 80);
    }

    public static Item createAgedBrie(final int sellIn, final int quality) {
        return new Item(AGED_BRIE, sellIn, quality);
    }

    public static Item createBackstagePasses(final int sellIn, final int quality) {
        return new Item(BACKSTAGE_PASSES, sellIn, quality);
    }
}
