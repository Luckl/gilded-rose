package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemTypes.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testRegularItem() {
        Item[] items = new Item[]{new Item("foo", 12, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(11, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void testRegularItemSellInReached() {
        Item[] items = new Item[]{new Item("foo", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void testRegularItemQualityNegative() {
        Item[] items = new Item[]{new Item("foo", 12, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(11, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testRegularItemQualityNegativeWhenSellInReached() {
        Item[] items = new Item[]{new Item("foo", 0, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testRegularItemQualityZeroWhenSellInReached() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
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
            Item[] items = new Item[]{new Item(AGED_BRIE, 12, 20)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(AGED_BRIE, app.items[0].name);
            assertEquals(11, app.items[0].sellIn);
            assertEquals(21, app.items[0].quality);
        }

        @Test
        void testAgedBrieSellInReached() {
            Item[] items = new Item[]{new Item(AGED_BRIE, 0, 20)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(AGED_BRIE, app.items[0].name);
            assertEquals(-1, app.items[0].sellIn);
            assertEquals(22, app.items[0].quality);
        }

        @Test
        void testAgedBrieQualityNotAboveFifty() {
            Item[] items = new Item[]{new Item(AGED_BRIE, 12, 50)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(AGED_BRIE, app.items[0].name);
            assertEquals(11, app.items[0].sellIn);
            assertEquals(50, app.items[0].quality);
        }
    }

    @Nested
    class Sulfuras {

        @Test
        void testSulfuras() {
            Item[] items = new Item[]{new Item(SULFURAS, 12, 80)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(SULFURAS, app.items[0].name);
            assertEquals(12, app.items[0].sellIn);
            assertEquals(80, app.items[0].quality);
        }

        @Test
        void testSulfurasQualityDoesNotDegrade() {
            Item[] items = new Item[]{new Item(SULFURAS, 0, 80)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(SULFURAS, app.items[0].name);
            assertEquals(0, app.items[0].sellIn);
            assertEquals(80, app.items[0].quality);
        }
    }

    @Nested
    class BackstagePass {

        @Test
        void testAgedBrieQualityNotAboveFifty() {
            Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 11, 50)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(BACKSTAGE_PASSES, app.items[0].name);
            assertEquals(10, app.items[0].sellIn);
            assertEquals(50, app.items[0].quality);
        }

        @Test
        void testBackstagePassMoreThanTenDays() {
            Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 11, 10)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(BACKSTAGE_PASSES, app.items[0].name);
            assertEquals(10, app.items[0].sellIn);
            assertEquals(11, app.items[0].quality);
        }

        @Test
        void testBackstagePassLessThanTenDays() {
            Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 10, 10)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(BACKSTAGE_PASSES, app.items[0].name);
            assertEquals(9, app.items[0].sellIn);
            assertEquals(12, app.items[0].quality);
        }

        @Test
        void testBackstagePassMoreThanFiveDays() {
            Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 6, 10)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(BACKSTAGE_PASSES, app.items[0].name);
            assertEquals(5, app.items[0].sellIn);
            assertEquals(12, app.items[0].quality);
        }

        @Test
        void testBackstagePassLessThanFiveDays() {
            Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 5, 10)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(BACKSTAGE_PASSES, app.items[0].name);
            assertEquals(4, app.items[0].sellIn);
            assertEquals(13, app.items[0].quality);
        }

        @Test
        void testBackstagePassForToday() {
            Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 1, 10)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(BACKSTAGE_PASSES, app.items[0].name);
            assertEquals(0, app.items[0].sellIn);
            assertEquals(13, app.items[0].quality);
        }

        @Test
        void testBackstagePassForYesterday() {
            Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 0, 10)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(BACKSTAGE_PASSES, app.items[0].name);
            assertEquals(-1, app.items[0].sellIn);
            assertEquals(0, app.items[0].quality);
        }
    }
}
