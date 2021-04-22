package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseNormaltemTest {
    private GildedRose app;
    private Item normalItem;

    @BeforeEach
    public void init() {
        Item[] items = new Item[]{
                new Item("Normal Item", 15, 20)
        };
        app = new GildedRose(items);
        normalItem = app.items[0];
    }


    @Test
    public void  normalItemQualityDecreaseByOneEachDay(){
        int normalItemQualityBefore = normalItem.quality;
        app.updateQuality();
        int normalItemQualityAfter = normalItem.quality;
        assertEquals(normalItemQualityBefore-1, normalItemQualityAfter);
    }


    @Test
    public void  normalItemQualityDecreasesIncrementallyOver10Days(){
        int normalItemQualityBefore = normalItem.quality;
        for(int i=0;i<10;i++)
            app.updateQuality();
        int normalItemQualityAfter = normalItem.quality;
        assertEquals(normalItemQualityBefore-10, normalItemQualityAfter);
    }

    @Test
    public void  normalItemQualityDecreasesIncrementallyByTwoOver10Days(){
        normalItem.sellIn = 0;
        int normalItemQualityBefore = normalItem.quality;
        for(int i=0;i<10;i++)
            app.updateQuality();
        int normalItemQualityAfter = normalItem.quality;
        assertEquals(normalItemQualityBefore-10*2, normalItemQualityAfter);
    }




}
