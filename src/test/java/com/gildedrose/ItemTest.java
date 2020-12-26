package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testCreateItem() {
        Item item = new Item("item", 10, 20);

        assertEquals(item.name, "item");
        assertEquals(item.sellIn, 10);
        assertEquals(item.quality, 20);
    }

    @Test
    void testToString() {
        Item item = new Item("item", 10, 20);

        assertEquals(item.toString(), "item, 10, 20");
    }
}
