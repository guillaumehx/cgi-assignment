package com.gildedrose.service;

import com.gildedrose.domain.ItemType;
import com.gildedrose.domain.ManagedItem;

public class SellInService {

    public void update(ManagedItem managedItem) {
        if (managedItem.getType() != ItemType.SULFURAS) {
            managedItem.getItem().sellIn--;
        }
    }
}
