package com.cygnus.gildedrose.control.quality;

import com.cygnus.gildedrose.entity.Item;

public class BackstageQualityControl implements IQualityControl {
    public BackstageQualityControl() {
    }

    public void updateQuantity(Item item) {
        item.increaseQuality();
        if (item.getSellIn() < 11) {
            item.increaseQuality();
        }

        if (item.getQuality() < 6) {
            item.increaseQuality();
        }

        item.decreaseSellIn();
        if (item.getSellIn() < 0) {
            item.resetQuality();
        }

    }
}

