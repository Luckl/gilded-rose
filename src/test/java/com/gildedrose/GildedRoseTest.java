package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Nested
    class NormalItem {
        @Test
        void testNormalItem() {
            Item[] items = new Item[] { new Item("foo", 12, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("foo", app.items[0].name);
            assertEquals(11, app.items[0].sellIn);
            assertEquals(19, app.items[0].quality);
        }

        @Test
        void testNormalItemSellInReached() {
            Item[] items = new Item[] { new Item("foo", 0, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("foo", app.items[0].name);
            assertEquals(-1, app.items[0].sellIn);
            assertEquals(18, app.items[0].quality);
        }

        @Test
        void testNormalItemQualityNegative() {
            Item[] items = new Item[] { new Item("foo", 12, 0) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("foo", app.items[0].name);
            assertEquals(11, app.items[0].sellIn);
            assertEquals(0, app.items[0].quality);
        }

        @Test
        void testNormalItemQualityNegativeWhenSellInReached() {
            Item[] items = new Item[] { new Item("foo", 0, 1) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("foo", app.items[0].name);
            assertEquals(-1, app.items[0].sellIn);
            assertEquals(0, app.items[0].quality);
        }

        @Test
        void testNormalItemQualityZeroWhenSellInReached() {
            Item[] items = new Item[] { new Item("foo", 0, 0) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("foo", app.items[0].name);
            assertEquals(-1, app.items[0].sellIn);
            assertEquals(0, app.items[0].quality);
        }
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
        void testAgedBrieSellInReached() {
            Item[] items = new Item[] { new Item("Aged Brie", 0, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Aged Brie", app.items[0].name);
            assertEquals(-1, app.items[0].sellIn);
            assertEquals(22, app.items[0].quality);
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

    @Nested
    class Sulfuras {

        @Test
        void testSulfuras() {
            Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 12, 80) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
            assertEquals(12, app.items[0].sellIn);
            assertEquals(80, app.items[0].quality);
        }

        @Test
        void testSulfurasQualityDoesNotDegrade() {
            Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
            assertEquals(0, app.items[0].sellIn);
            assertEquals(80, app.items[0].quality);
        }
    }
    @Nested
    class BackstagePass {

        @Test
        void testBackstagePassMoreThanTenDays() {
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
            assertEquals(10, app.items[0].sellIn);
            assertEquals(11, app.items[0].quality);
        }

        @Test
        void testBackstagePassLessThanTenDays() {
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
            assertEquals(9, app.items[0].sellIn);
            assertEquals(12, app.items[0].quality);
        }

        @Test
        void testBackstagePassMoreThanFiveDays() {
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
            assertEquals(5, app.items[0].sellIn);
            assertEquals(12, app.items[0].quality);
        }

        @Test
        void testBackstagePassLessThanFiveDays() {
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
            assertEquals(4, app.items[0].sellIn);
            assertEquals(13, app.items[0].quality);
        }

        @Test
        void testBackstagePassForToday() {
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
            assertEquals(0, app.items[0].sellIn);
            assertEquals(13, app.items[0].quality);
        }

        @Test
        void testBackstagePassForYesterday() {
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
            assertEquals(-1, app.items[0].sellIn);
            assertEquals(0, app.items[0].quality);
        }

    }
}
