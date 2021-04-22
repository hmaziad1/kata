package com.gildedrose;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseCheeseTest {
    private GildedRose app;
    private Item cheese;
    private static final int CHEESE_MAX_QUALITY = 50;
    private static final int MIN_SELL_IN = 0;

    /**
     * Testing will be divided between four components:
     * 1.   Cheese
     * 2.   Concert Tickets
     * 3.   un-Depreciable Items
     * 4.   Conjuring Items
     *
     * A comment block for each components will be provided below...
     *
     */

    /**
     * Cheese: Aged Brie
     * What tests should be thought off:
     * 1.   "Aged Brie" actually increases in Quality the older it gets even after sell date passes
     * 2.   The Quality of an item is never more than 50
     */


    @BeforeEach
    public void init() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 2, 5)
        };
        app = new GildedRose(items);
        cheese = app.items[0];
    }


    @Test
    public void cheeseIncreaseQualityOnceAfterOneDay() {
        int cheeseQualityBefore = cheese.quality;
        app.updateQuality();
        int cheeseQualityAfter = cheese.quality;
        assertEquals(cheeseQualityBefore+1, cheeseQualityAfter);
    }


    @Test
    public void cheeseIncreaseQualityTwiceAfterTwoDays() {
        int cheeseQualityBefore = cheese.quality;
        app.updateQuality();
        app.updateQuality();
        int cheeseQualityAfter = cheese.quality;
        assertEquals(cheeseQualityBefore+2, cheeseQualityAfter);
    }

    @Test
    public void cheeseQualityNotExceed50() {
        cheese.quality = CHEESE_MAX_QUALITY;
        app.updateQuality();
        int cheeseQualityAfter = cheese.quality;
        assertEquals(CHEESE_MAX_QUALITY, cheeseQualityAfter);
    }

    @Test
    public void cheeseQualityIncreaseTwiceAfterOneNegativeSellIn() {
        cheese.sellIn = 0;
        int cheeseQualityBefore = cheese.quality;
        app.updateQuality();
        int cheeseQualityAfter = cheese.quality;
        assertEquals(cheeseQualityBefore+2, cheeseQualityAfter);
    }

    @Test
    public void cheeseQualityIncreaseFourTimesAfterTwoNegativeSellIn() {
        cheese.sellIn = 0;
        int cheeseQualityBefore = cheese.quality;
        app.updateQuality();
        app.updateQuality();
        int cheeseQualityAfter = cheese.quality;
        assertEquals(cheeseQualityBefore+4, cheeseQualityAfter);
    }

    @Test
    public void cheeseSellInDecreaseOnceAfterOneDay() {
        int cheeseSellInBefore = cheese.sellIn;
        app.updateQuality();
        int cheeseSellInAfter = cheese.sellIn;
        assertEquals(cheeseSellInBefore-1,cheeseSellInAfter);
    }


    @Test
    public void cheeseSellInDecreaseTwiceAfterTwoDays() {
        int cheeseSellInBefore = cheese.sellIn;
        app.updateQuality();
        app.updateQuality();
        int cheeseSellInAfter = cheese.sellIn;
        assertEquals(cheeseSellInBefore-2,cheeseSellInAfter);
    }

    @Test
    public void cheeseSellInCanDecreaseBelowZero() {
        cheese.sellIn = MIN_SELL_IN;
        int cheeseSellInBefore = cheese.sellIn;
        app.updateQuality();
        int cheeseSellInAfter = cheese.sellIn;
        assertEquals(cheeseSellInBefore-1,cheeseSellInAfter);
    }

}
