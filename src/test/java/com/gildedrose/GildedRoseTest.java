package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testFrameworkWorks() {
        Item item = createAndUpdate(0, 0);
        assertEquals("foo", item.name);
    }

    private Item createAndUpdate(int sellIn, int quality) {
        Item[] items = new Item[]{new Item("foo", sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return items[0];
    }

    @Test
    void systemLowerValues() {
        Item[] items = new Item[]{new Item("foo", 15, 25)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(24, app.items[0].quality);

    }
    @Test
    void qualityDegradesTwiceAsFast() {
        Item[] items = new Item[]{new Item("foo", 0, 17)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(15, app.items[0].quality);
    }

    @Test
    void qualityIsNeverNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    }

