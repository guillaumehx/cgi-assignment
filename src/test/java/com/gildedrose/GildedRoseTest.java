package com.gildedrose;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.ManagedItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void normalItemLosesOneQualityPerDay() {

        ManagedItem item = new ManagedItem(
            new Item("+5 Dexterity Vest", 10, 20)
        );

        GildedRose app = new GildedRose(List.of(item));

        app.updateQuality();

        assertEquals(19, item.getItem().quality);
        assertEquals(9, item.getItem().sellIn);
    }

}
