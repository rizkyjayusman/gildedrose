package com.cygnus.gildedrose.entity;

public class BackstageItem extends Item {
    public BackstageItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuantity() {
        increaseQuality();

        if (getSellIn() < 11) increaseQuality();
        if (getQuality() < 6) increaseQuality();

        decreaseSellIn();
        if(getSellIn() < 0) resetQuality();
    }
}
