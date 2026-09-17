package com.gildedrose.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTypeTest {

    @Test
    void shouldIdentifyNormalItem() {
        assertEquals(ItemType.NORMAL, ItemType.fromName("+5 Dexterity Vest"));
    }

    @Test
    void shouldIdentifyAgedBrie() {
        assertEquals(ItemType.AGED_BRIE, ItemType.fromName("Aged Brie"));
    }

    @Test
    void shouldIdentifySulfuras() {
        assertEquals(ItemType.SULFURAS, ItemType.fromName("Sulfuras, Hand of Ragnaros"));
    }

    @Test
    void shouldIdentifyBackstagePass() {
        assertEquals(ItemType.BACKSTAGE_PASS, ItemType.fromName("Backstage passes to a TAFKAL80ETC concert"));
    }

    @Test
    void shouldIdentifyConjuredItem() {
        assertEquals(ItemType.CONJURED, ItemType.fromName("Conjured Mana Cake"));
    }

    @Test
    void shouldIdentifyBackstagePassRegardlessOfConcertName() {
        assertEquals(ItemType.BACKSTAGE_PASS, ItemType.fromName("Backstage passes to an Eminem concert"));
    }

    @Test
    void shouldIdentifyConjuredItemRegardlessOfItemName() {
        assertEquals(ItemType.CONJURED, ItemType.fromName("Conjured pear Cake"));
    }
}
