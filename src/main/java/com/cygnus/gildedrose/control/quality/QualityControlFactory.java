package com.cygnus.gildedrose.control.quality;

import com.cygnus.gildedrose.entity.Item;

public class QualityControlFactory {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public QualityControlFactory() {
    }

    public static IQualityControl getControl(Item item) {
        IQualityControl control;
        switch(item.getName()) {
            case AGED_BRIE:
                control = new AgedBrieQualityControl();
                break;
            case BACKSTAGE:
                control = new BackstageQualityControl();
                break;
            case SULFURAS:
                control = new SulfurasQualityControl();
                break;
            default:
                control = new DefaultQualityControl();
        }

        return control;
    }
}
