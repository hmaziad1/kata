package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseConjuredltemTest {
    private GildedRose app;
    private Item conjuredItem;

    @BeforeEach
    public void init() {
        Item[] items = new Item[]{
                new Item("Conjured Mana Cake", 15, 20)
        };
        app = new GildedRose(items);
        conjuredItem = app.items[0];
    }


    @Test
    public void  conjuredItemQualityDecreaseByTwoInOneDay(){
        int conjuredItemQualityBefore = conjuredItem.quality;
        app.updateQuality();
        int conjuredItemQualityAfter = conjuredItem.quality;
        assertEquals(conjuredItemQualityBefore-2, conjuredItemQualityAfter);
    }


    @Test
    public void  conjuredItemQualityDecreasesIncrementallyByTwoOver10Days(){
        int conjuredItemQualityBefore = conjuredItem.quality;
        for(int i=0;i<10;i++)
            app.updateQuality();
        int conjuredItemQualityAfter = conjuredItem.quality;
        assertEquals(conjuredItemQualityBefore-10*2, conjuredItemQualityAfter);
    }

    @Test
    public void  conjuredItemQualityDecreasesIncrementallyByFourOver10Days(){
        conjuredItem.sellIn = 0;
        int conjuredItemQualityBefore = conjuredItem.quality;
        for(int i=0;i<10;i++)
            app.updateQuality();
        int conjuredItemQualityAfter = conjuredItem.quality;
        assertEquals(conjuredItemQualityBefore-10*4, conjuredItemQualityAfter);
    }




}
