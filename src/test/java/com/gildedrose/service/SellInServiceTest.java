package com.gildedrose.service;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.ManagedItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SellInServiceTest {

    private final SellInService sellInService = new SellInService();

    @Test
    void normalItemSellInDecreasesByOne() {
        Item item = new Item("+5 Dexterity Vest", 10, 20);
        sellInService.update(new ManagedItem(item));
        assertEquals(9, item.sellIn);
    }

    @Test
    void sellInCanBecomeNegative() {
        Item item = new Item("+5 Dexterity Vest", 0, 20);
        sellInService.update(new ManagedItem(item));
        assertEquals(-1, item.sellIn);
    }

    @Test
    void agedBrieSellInDecreasesByOne() {
        Item item = new Item("Aged Brie", 10, 20);
        sellInService.update(new ManagedItem(item));
        assertEquals(9, item.sellIn);
    }

    @Test
    void backstagePassSellInDecreasesByOne() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        sellInService.update(new ManagedItem(item));
        assertEquals(9, item.sellIn);
    }

    @Test
    void conjuredItemSellInDecreasesByOne() {
        Item item = new Item("Conjured Mana Cake", 10, 20);
        sellInService.update(new ManagedItem(item));
        assertEquals(9, item.sellIn);
    }

    @Test
    void sulfurasSellInDoesNotChange() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        sellInService.update(new ManagedItem(item));
        assertEquals(10, item.sellIn);
    }

    @Test
    void sulfurasWithNegativeSellInRemainsUnchanged() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        sellInService.update(new ManagedItem(item));
        assertEquals(-1, item.sellIn);
    }
}
