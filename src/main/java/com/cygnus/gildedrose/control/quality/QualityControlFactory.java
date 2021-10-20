package com.cygnus.gildedrose.control.quality;

import com.cygnus.gildedrose.entity.Item;

public class QualityControlFactory {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public QualityControlFactory() {
    }

    public static IQualityControl getControl(Item item) {
        String var2 = item.getName();
        byte var3 = -1;
        switch(var2.hashCode()) {
            case -1097458151:
                if (var2.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    var3 = 1;
                }
                break;
            case -61479577:
                if (var2.equals("Aged Brie")) {
                    var3 = 0;
                }
                break;
            case 562738722:
                if (var2.equals("Sulfuras, Hand of Ragnaros")) {
                    var3 = 2;
                }
        }

        Object control;
        switch(var3) {
            case 0:
                control = new AgedBrieQualityControl();
                break;
            case 1:
                control = new BackstageQualityControl();
                break;
            case 2:
                control = new SulfurasQualityControl();
                break;
            default:
                control = new DefaultQualityControl();
        }

        return (IQualityControl)control;
    }
}
