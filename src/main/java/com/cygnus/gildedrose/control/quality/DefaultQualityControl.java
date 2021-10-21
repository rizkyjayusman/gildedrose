package com.cygnus.gildedrose.control.quality;

import com.cygnus.gildedrose.entity.Item;

public class DefaultQualityControl implements IQualityControl {
    public DefaultQualityControl() {
    }

    public void updateQuantity(Item item) {
        item.decreaseQuality();
        item.decreaseSellIn();
        if (item.hasQuality() && item.getSellIn() < 0) {
            item.decreaseQuality();
        }

    }
}

