package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private Item createAndUpdate(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item("foo", sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return items[0];
    }

    @Test
    void testFrameworkWorks() {
        Item item = createAndUpdate("foo", 0, 17);
        assertEquals("foo", item.name);
    }

    @Test
    void systemLowerValues() {
       Item item = createAndUpdate("foo", 15, 25);
        assertEquals(14, item.sellIn);
        assertEquals(24, item.quality);

    }
    @Test
    void qualityDegradesTwiceAsFast() {
        Item item = createAndUpdate("foo", 0, 17);
        assertEquals(15, item.quality);
    }

    @Test
    void qualityIsNeverNegative() {
      Item item = createAndUpdate("foo", 0, 0);
        assertEquals(0, item.quality);
    }
    @Test
    void agedBrieIncreasesInQuality(){
        Item item = createAndUpdate("Aged Brie", 15, 25);
        assertEquals(26, item.quality);
    }

    @Test
    void qualityNeverMoreThan50() {
        Item item = createAndUpdate("foo", 15, 52);
        assertEquals(51, item.quality); //can exceed 50 if input exceeds 50

        item = createAndUpdate("Aged Brie", 15, 50);
        assertEquals(50, item.quality);

    }


    }

