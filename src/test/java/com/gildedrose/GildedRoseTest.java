package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testRegularItem() {
        Item[] items = new Item[] { new Item("foo", 12, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(11, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void testRegularItemSellInReached() {
        Item[] items = new Item[] { new Item("foo", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void testRegularItemQualityNegative() {
        Item[] items = new Item[] { new Item("foo", 12, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(11, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testRegularItemQualityNegativeWhenSellInReached() {
        Item[] items = new Item[] { new Item("foo", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testRegularItemQualityZeroWhenSellInReached() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Nested
    class AgedBrie {
        @Test
        void testAgedBrie() {
            Item[] items = new Item[] { new Item("Aged Brie", 12, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Aged Brie", app.items[0].name);
            assertEquals(11, app.items[0].sellIn);
            assertEquals(21, app.items[0].quality);
        }

        @Test
        void testAgedBrieQualityNotAboveFifty() {
            Item[] items = new Item[] { new Item("Aged Brie", 12, 50) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Aged Brie", app.items[0].name);
            assertEquals(11, app.items[0].sellIn);
            assertEquals(50, app.items[0].quality);
        }
    }




}
