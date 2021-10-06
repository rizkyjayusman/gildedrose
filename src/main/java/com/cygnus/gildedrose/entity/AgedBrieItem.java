package com.cygnus.gildedrose.entity;

public class AgedBrieItem extends Item {
    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuantity() {
        increaseQuality();
        decreaseSellIn();
        if(getSellIn() < 0) increaseQuality();
    }
}
