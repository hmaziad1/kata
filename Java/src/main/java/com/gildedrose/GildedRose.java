package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item current = items[i];
            switch (current.name) {
                case "Aged Brie":
                    updateCheeseQuality(current);
                    decrementSellIn(current);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateConcertTicketQuality(current);
                    decrementSellIn(current);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                case "Conjured Mana Cake":
                    updateConjuredItemQuality(current);
                    decrementSellIn(current);
                    break;
                default:
                    updateNormalItemQuality(current);
                    decrementSellIn(current);
                    break;
            }
        }
    }

    private void updateCheeseQuality(Item cheese) {
        cheese.quality = cheese.sellIn <= 0 ? cheese.quality + 2 : cheese.quality + 1;
        cheese.quality = Math.min(cheese.quality, 50);
    }

    private void updateConcertTicketQuality(Item ticket) {
        ticket.quality = ticket.sellIn <= 0 ? 0 :
                ticket.sellIn <= 5 ? ticket.quality + 3 :
                        ticket.sellIn <= 10 ? ticket.quality + 2 :
                                ticket.quality + 1;
    }

    private void updateConjuredItemQuality(Item conjuredItem) {
        conjuredItem.quality = conjuredItem.sellIn <= 0 ? conjuredItem.quality - 4 : conjuredItem.quality - 2;
    }

    private void updateNormalItemQuality(Item normalItem) {
        normalItem.quality = normalItem.sellIn <= 0 ? normalItem.quality - 2 : normalItem.quality - 1;
    }

    private void decrementSellIn(Item item){
        item.sellIn--;
    }

}