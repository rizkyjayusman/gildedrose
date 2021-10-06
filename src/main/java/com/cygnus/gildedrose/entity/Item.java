package com.cygnus.gildedrose.entity;

public class Item {

    private final String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void decreaseSellIn() {
        sellIn--;
    }

    public void resetQuality() {
        quality = 0;
    }

    public void increaseQuality() {
        if(! isQualityFull()) {
            quality++;
        }
    }

    public void decreaseQuality() {
        this.quality--;
    }

    public boolean hasQuality() {
        return quality > 0;
    }

    public boolean isQualityFull() {
        return quality >= 50;
    }

    public void updateQuantity() {
        decreaseQuality();
        decreaseSellIn();
        if(hasQuality() && getSellIn() < 0) {
            decreaseQuality();
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

}
