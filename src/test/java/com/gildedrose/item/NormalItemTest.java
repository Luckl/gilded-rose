package com.gildedrose.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalItemTest {
    @Test
    void testNormalItem() {
        ItemType item = new NormalItem("foo", 12, 20);
        item.updateQuality();
        assertEquals("foo", item.name);
        assertEquals(11, item.sellIn);
        assertEquals(19, item.quality);
    }

    @Test
    void testNormalItemSellInReached() {
        ItemType item = new NormalItem("foo", 0, 20);
        item.updateQuality();
        assertEquals("foo", item.name);
        assertEquals(-1, item.sellIn);
        assertEquals(18, item.quality);
    }

    @Test
    void testNormalItemQualityNegative() {
        ItemType item = new NormalItem("foo", 12, 0);
        item.updateQuality();
        assertEquals("foo", item.name);
        assertEquals(11, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void testNormalItemQualityNegativeWhenSellInReached() {
        ItemType item = new NormalItem("foo", 0, 1);
        item.updateQuality();
        assertEquals("foo", item.name);
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void testNormalItemQualityZeroWhenSellInReached() {
        ItemType item = new NormalItem("foo", 0, 0);
        item.updateQuality();
        assertEquals("foo", item.name);
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }
}
