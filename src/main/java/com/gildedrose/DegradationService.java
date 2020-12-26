package com.gildedrose;

import static com.gildedrose.ItemTypes.BACKSTAGE_PASSES;

public class DegradationService {

    public int getDegradationFactor(Item item) {
        if (!BACKSTAGE_PASSES.equals(item.name)) {
            if (item.sellIn < 0) {
                return 2;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
