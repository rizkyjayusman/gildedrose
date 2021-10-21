package com.cygnus.gildedrose.control.quality;

import com.cygnus.gildedrose.entity.Item;

public class AgedBrieQualityControl implements IQualityControl {
    public AgedBrieQualityControl() {
    }

    public void updateQuantity(Item item) {
        item.increaseQuality();
        item.decreaseSellIn();
        if (item.getSellIn() < 0) {
            item.increaseQuality();
        }

    }
}
