package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseSulfurasTest {
    private GildedRose app;
    private Item sulfuras;

    @BeforeEach
    public void init() {
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 0, 80)
        };
        app = new GildedRose(items);
        sulfuras = app.items[0];
    }


    @Test
    public void  normalItemQualityNotDecrease(){
        int sulfurasQualityBefore = sulfuras.quality;
        app.updateQuality();
        int sulfurasQualityAfter = sulfuras.quality;
        assertEquals(sulfurasQualityBefore, sulfurasQualityAfter);
    }

    @Test
    public void  normalItemSellInNotDecrease(){
        int sulfurasSellInBefore = sulfuras.sellIn;
        app.updateQuality();
        int sulfurasSellInAfter = sulfuras.sellIn;
        assertEquals(sulfurasSellInBefore, sulfurasSellInAfter);
    }







}
