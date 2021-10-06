package com.cygnus.gildedrose.entity;

public class SulfurasItem extends Item {
    public SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuantity() {
        // doing nothing
    }
}
