package com.gildedrose;

import static com.gildedrose.ItemTypes.*;

class GildedRose {
    Item[] items;

    private DegradationService degradationService;

    public GildedRose(Item[] items, DegradationService degradationService) {
        this.items = items;
        this.degradationService = degradationService;
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

    // TODO: Validate if conjuring factor also applies to the backstage passes.
    private void updateQualityForBackstagePasses(Item backstagePasses) {
        final int degradationFactor = degradationService.getDegradationFactor(backstagePasses);

        backstagePasses.quality = backstagePasses.quality + degradationFactor;
        backstagePasses.sellIn = backstagePasses.sellIn - 1;
        if (backstagePasses.sellIn < 10) {
            backstagePasses.quality = backstagePasses.quality + degradationFactor;
        }
        if (backstagePasses.sellIn < 5) {
            backstagePasses.quality = backstagePasses.quality + degradationFactor;
        }
        if (backstagePasses.sellIn < 0) {
            backstagePasses.quality = 0;
        }
        if (backstagePasses.quality > 50) {
            backstagePasses.quality = 50;
        }
    }

    private void updateQualityForAgedBrie(Item brie) {
        brie.sellIn = brie.sellIn - 1;
        final int degradationFactor = degradationService.getDegradationFactor(brie);
        brie.quality = brie.quality + degradationFactor;
        if (brie.quality > 50) {
            brie.quality = 50;
        }
    }

    private void updateQuality(Item item) {
        item.sellIn = item.sellIn - 1;
        final int degradationFactor = degradationService.getDegradationFactor(item);
        item.quality = item.quality - degradationFactor;
        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}
