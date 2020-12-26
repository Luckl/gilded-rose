package com.gildedrose;

public class DegradationService {

    public int getDegradationFactor(Item item) {
        if (item.sellIn < 0) {
            return multiplyByConjuringFactor(item, 2);
        } else {
            return multiplyByConjuringFactor(item, 1);
        }
    }

    private int multiplyByConjuringFactor(Item item, int degradationFactor) {
        if (item instanceof ConjuredItem) {
            return degradationFactor * 2;
        } else {
            return degradationFactor;
        }
    }
}
