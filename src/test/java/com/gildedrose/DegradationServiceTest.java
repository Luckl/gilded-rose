package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DegradationServiceTest {

    private DegradationService degradationService;

    @BeforeEach
    public void setUp() {
        degradationService = new DegradationService();
    }

    @Test
    void testGetDegradationFactorForNormalItemWithinSellIn() {
        Item item = new Item("item", 10, 2);
        int degradationFactor = degradationService.getDegradationFactor(item);
        assertEquals(degradationFactor, 1);
    }

    @Test
    void testGetDegradationFactorForNormalItemAfterSellIn() {
        Item item = new Item("item", -1, 2);
        int degradationFactor = degradationService.getDegradationFactor(item);
        assertEquals(degradationFactor, 2);
    }
}
