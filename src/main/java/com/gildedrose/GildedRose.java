package com.gildedrose;

import com.gildedrose.domain.ManagedItem;
import com.gildedrose.service.QualityService;
import com.gildedrose.service.SellInService;

import java.util.List;

class GildedRose {

    private final List<ManagedItem> items;
    private final QualityService qualityService;
    private final SellInService sellInService;

    public GildedRose(List<ManagedItem> items) {
        this.items = items;
        this.qualityService = new QualityService();
        this.sellInService = new SellInService();
    }

    public void updateQuality() {
        for (ManagedItem item : items) {
            qualityService.update(item);
            sellInService.update(item);
        }
    }
}
