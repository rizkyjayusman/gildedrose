package com.cygnus.gildedrose;

import com.cygnus.gildedrose.entity.Item;

public class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.updateQuantity();
        }
    }
}
