package com.gildedrose.domain;

public enum ItemType {

    NORMAL,
    AGED_BRIE,
    SULFURAS,
    BACKSTAGE_PASS,
    CONJURED;

    public static ItemType fromName(String name) {
        if (name.contains("Aged Brie")) {
            return AGED_BRIE;
        }

        if (name.contains("Sulfuras")) {
            return SULFURAS;
        }

        if (name.contains("Backstage passes")) {
            return BACKSTAGE_PASS;
        }

        if (name.contains("Conjured")) {
            return CONJURED;
        }

        return NORMAL;
    }
}
