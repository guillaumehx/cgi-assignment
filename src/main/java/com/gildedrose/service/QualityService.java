package com.gildedrose.service;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.ManagedItem;

public class QualityService {

    public void update(ManagedItem managedItem) {
        Item item = managedItem.getItem();

        switch (managedItem.getType()) {
            case NORMAL -> updateNormal(item);
            case AGED_BRIE -> updateAgedBrie(item);
            case BACKSTAGE_PASS -> updateBackstagePass(item);
            case CONJURED -> updateConjured(item);
        }
    }

    private void updateNormal(Item item) {
        decreaseQuality(item, 1);

        if (item.sellIn < 0) {
            decreaseQuality(item, 1);
        }
    }

    private void updateConjured(Item item) {
        decreaseQuality(item, 2);

        if (item.sellIn < 0) {
            decreaseQuality(item, 2);
        }
    }

    private void updateAgedBrie(Item item) {
        increaseQuality(item, 1);

        if (item.sellIn < 0) {
            increaseQuality(item, 1);
        }
    }

    private void updateBackstagePass(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
            return;
        }

        increaseQuality(item, 1);

        if (item.sellIn < 11) {
            increaseQuality(item, 1);
        }

        if (item.sellIn < 6) {
            increaseQuality(item, 1);
        }
    }

    private void increaseQuality(Item item, int amount) {
        item.quality = Math.min(50, item.quality + amount);
    }

    private void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }
}
