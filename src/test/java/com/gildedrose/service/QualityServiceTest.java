package com.gildedrose.service;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.ManagedItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityServiceTest {

    private final QualityService qualityService = new QualityService();

    @Test
    void normalItemLosesOneQuality() {
        Item item = new Item("+5 Dexterity Vest", 10, 20);
        qualityService.update(new ManagedItem(item));
        assertEquals(19, item.quality);
    }

    @Test
    void normalItemLosesTwoQualityAfterSellByDate() {
        Item item = new Item("+5 Dexterity Vest", -1, 20);
        qualityService.update(new ManagedItem(item));
        assertEquals(18, item.quality);
    }

    @Test
    void normalItemQualityCannotBecomeNegative() {
        Item item = new Item("+5 Dexterity Vest", 10, 0);
        qualityService.update(new ManagedItem(item));
        assertEquals(0, item.quality);
    }

    @Test
    void agedBrieIncreasesOneQuality() {
        Item item = new Item("Aged Brie", 10, 20);
        qualityService.update(new ManagedItem(item));
        assertEquals(21, item.quality);
    }

    @Test
    void agedBrieIncreasesTwoQualityAfterSellByDate() {
        Item item = new Item("Aged Brie", -1, 20);
        qualityService.update(new ManagedItem(item));
        assertEquals(22, item.quality);
    }

    @Test
    void qualityCannotExceedFifty() {
        Item item = new Item("Aged Brie", 10, 50);
        qualityService.update(new ManagedItem(item));
        assertEquals(50, item.quality);
    }

    @Test
    void sulfurasQualityNeverChanges() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        qualityService.update(new ManagedItem(item));
        assertEquals(80, item.quality);
    }

    @Test
    void backstagePassIncreasesOneQuality() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        qualityService.update(new ManagedItem(item));
        assertEquals(21, item.quality);
    }

    @Test
    void backstagePassIncreasesTwoQualityWhenTenDaysOrLess() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        qualityService.update(new ManagedItem(item));
        assertEquals(22, item.quality);
    }

    @Test
    void backstagePassIncreasesThreeQualityWhenFiveDaysOrLess() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        qualityService.update(new ManagedItem(item));
        assertEquals(23, item.quality);
    }

    @Test
    void backstagePassQualityBecomesZeroAfterConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20);
        qualityService.update(new ManagedItem(item));
        assertEquals(0, item.quality);
    }

    @Test
    void backstagePassQualityCannotExceedFifty() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        qualityService.update(new ManagedItem(item));
        assertEquals(50, item.quality);
    }

    @Test
    void conjuredItemLosesTwoQuality() {
        Item item = new Item("Conjured Mana Cake", 10, 20);
        qualityService.update(new ManagedItem(item));
        assertEquals(18, item.quality);
    }

    @Test
    void conjuredItemLosesFourQualityAfterSellByDate() {
        Item item = new Item("Conjured Mana Cake", -1, 20);
        qualityService.update(new ManagedItem(item));
        assertEquals(16, item.quality);
    }

    @Test
    void conjuredItemQualityCannotBecomeNegative() {
        Item item = new Item("Conjured Mana Cake", 10, 1);
        qualityService.update(new ManagedItem(item));
        assertEquals(0, item.quality);
    }
}
