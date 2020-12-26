package com.gildedrose;

import static com.gildedrose.ItemTypes.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals(AGED_BRIE)) {
                updateQualityForAgedBrie(items[i]);
            } else if (items[i].name.equals(BACKSTAGE_PASSES)) {
                updateQualityForBackstagePasses(items[i]);
            } else if (items[i].name.equals(SULFURAS)) {
                updateQualityForSulfuras(items[i]);
            } else {
                updateQuality(items[i]);
            }
        }
    }

    private void updateQualityForSulfuras(Item sulfuras) {
        // Do nothing.
    }

    private void updateQualityForBackstagePasses(Item backstagePasses) {
        if (backstagePasses.quality < 50) {
            backstagePasses.quality = backstagePasses.quality + 1;
        }
        backstagePasses.sellIn = backstagePasses.sellIn - 1;
        if (backstagePasses.sellIn < 10) {
            backstagePasses.quality = backstagePasses.quality + 1;
        }
        if (backstagePasses.sellIn < 5) {
            backstagePasses.quality = backstagePasses.quality + 1;
        }
        if (backstagePasses.sellIn < 0) {
            backstagePasses.quality = 0;
        }
    }

    private void updateQualityForAgedBrie(Item brie) {
        if (brie.quality < 50) {
            brie.quality = brie.quality + 1;
        }
        brie.sellIn = brie.sellIn - 1;
        if (brie.sellIn < 0) {
            if (brie.quality < 50) {
                brie.quality = brie.quality + 1;
            }
        }
    }

    private void updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
