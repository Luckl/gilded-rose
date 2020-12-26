package com.gildedrose;

public class DegradationService {

    public int getDegradationFactor(Item item) {
        if (item.sellIn < 0) {
            return 2;
        } else {
            return 1;
        }
    }
}
