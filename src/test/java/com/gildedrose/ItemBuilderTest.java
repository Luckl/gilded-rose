package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemTypes.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemBuilderTest {

    @Test
    void testCreateItem() {
        Item item = ItemBuilder.createItem("item", 12, 20);

        assertEquals(item.name, "item");
        assertEquals(item.sellIn, 12);
        assertEquals(item.quality, 20);

    }

    @Test
    void testCreateSulfurasFromItem() {
        Item item = ItemBuilder.createItem(SULFURAS, 12, 20);

        assertEquals(item.name, SULFURAS);
        assertEquals(item.sellIn, 0);
        assertEquals(item.quality, 80);

    }

    @Test
    void testCreateBrieFromItem() {
        Item item = ItemBuilder.createItem(AGED_BRIE, 12, 20);

        assertEquals(item.name, AGED_BRIE);
        assertEquals(item.sellIn, 12);
        assertEquals(item.quality, 20);
    }

    @Test
    void testCreateBackstagePassesFromItem() {
        Item item = ItemBuilder.createItem(BACKSTAGE_PASSES, 12, 20);

        assertEquals(item.name, BACKSTAGE_PASSES);
        assertEquals(item.sellIn, 12);
        assertEquals(item.quality, 20);

    }

    @Test
    void testCreateBrie() {
        Item item = ItemBuilder.createAgedBrie(12, 20);

        assertEquals(item.name, AGED_BRIE);
        assertEquals(item.sellIn, 12);
        assertEquals(item.quality, 20);

    }

    @Test
    void testCreateBackstagePasses() {
        Item item = ItemBuilder.createBackstagePasses(12, 20);

        assertEquals(item.name, BACKSTAGE_PASSES);
        assertEquals(item.sellIn, 12);
        assertEquals(item.quality, 20);

    }

    @Test
    void testCreateSulfuras() {
        Item item = ItemBuilder.createSulfuras();

        assertEquals(item.name, SULFURAS);
        assertEquals(item.sellIn, 0);
        assertEquals(item.quality, 80);

    }
}
