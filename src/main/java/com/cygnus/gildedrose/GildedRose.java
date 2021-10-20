package com.cygnus.gildedrose;

import com.cygnus.gildedrose.control.quality.IQualityControl;
import com.cygnus.gildedrose.control.quality.QualityControlFactory;
import com.cygnus.gildedrose.entity.Item;

public class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            IQualityControl qualityControl = QualityControlFactory.getControl(item);
            qualityControl.updateQuantity(item);
        }
    }
}
