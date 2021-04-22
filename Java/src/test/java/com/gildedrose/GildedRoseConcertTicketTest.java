package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseConcertTicketTest {

    private GildedRose app;
    private Item ticket;

    @BeforeEach
    public void init() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)
        };
        app = new GildedRose(items);
        ticket = app.items[0];
    }

    @Test
    public void ticketQualityDropsToZeroOneDayAfterConcert(){
        ticket.sellIn = 0;
        app.updateQuality();
        int qualityAfter = ticket.quality;
        assertEquals(0, qualityAfter);
    }

    @Test
    public void ticketQualityDropsToZeroTwoDaysAfterConcert(){
        ticket.sellIn = 0;
        app.updateQuality();
        app.updateQuality();
        int qualityAfter = ticket.quality;
        assertEquals(0, qualityAfter);
    }

    @Test
    public void ticketQualityIncreaseByOne11DaysOrMoreBeforeConcert(){
        ticket.sellIn = 13;
        int qualityBefore = ticket.quality;
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        int qualityAfter = ticket.quality;
        assertEquals(qualityBefore+3,qualityAfter);
    }


    @Test
    public void ticketQualityIncreaseByTwo10DaysOrLessButMorethan5DaysBeforeConcert(){
        ticket.sellIn = 10;
        int qualityBefore = ticket.quality;
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        int qualityAfter = ticket.quality;
        assertEquals(qualityBefore+2*5,qualityAfter);
    }


    @Test
    public void ticketQualityIncreaseByThree5DaysBeforeConcert(){
        ticket.sellIn = 5;
        int qualityBefore = ticket.quality;
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        int qualityAfter = ticket.quality;
        assertEquals(qualityBefore+3*5,qualityAfter);
    }

    @Test
    public void ticketSellInDecreasesOver15DayPeriod() {
        ticket.sellIn = 15;
        for (int i = 0; i < 15; i++)
            app.updateQuality();
        assertEquals(0,ticket.sellIn);
    }

    /**
     * Ticket : "Backstage passes to a TAFKAL80ETC concert"
     * What tests should be thought off:
     * 1.   Sell in value decreases after each day
     * 2.   quality
     */


}
