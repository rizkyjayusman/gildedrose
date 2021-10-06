# Introduction
The Gilded Rose is my kata refactoring challenge. I am create the solution about this challenge using Java programming language.

# The Problem

```` 
class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

}

````

````
class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

}
````

# How We Solve The Problem

First, we create a public getter and setter for the Item attributes and set the Item attributes access modifier from public into private.

````
class Item {
    
    ...
    
    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    ...
    
}
````

Then we replace all the Item attributes on GildedRose class using public setter and getter

````
class GildedRose {
    ...
    
        public void updateQuality() {
            ...
            
                // if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (!items[i].getName().equals("Aged Brie") && !items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {

            ...   

                // items[i].quality = items[i].quality + 1;
                items[i].setQuantity(items[i].getQuantity() + 1);
            
            ...
        }
    
    ...
}
````

Next, we take a look the first if condition GildedRose's updateQuality function.

We got the code check if the item's name was not "Aged Brie" and also not "Backstage passes to a TAFKAL80ETC concert" 
and do some logic to update the quality of item.
Then we break the else code into a single if that do a task to check the item is "Aged Brie" or "Backstaged passes to a TAFKAL80ETC concert" and do their logic in it.

````
if (items[i].getName().equals("Aged Brie") || item[i].getName().equals("Backstaged passes to a TAFKAL80ETC concert")) {
    // do unrefactored update quality of age brie or backstage passes to a TAFKAL80ETC concert
}
````

after we break the else then we continue to the inner if that contained on if condition above.
we got the code that check if the item quality less than 50 then add +1 to the item quality. we can move this condition to the
Item class like this:

````
class Item {
    ...
    public boolean isQualityFull() {
        return quality >= 50;
    }
    ...
}
````
````
class GildedRose {
    ...
         if (! items[i].isQualityFull()) {
            // do unrefactored update quality logic
         }
    ...
}
````

then we go to the next line of code and found code that check if the item was "Backstage passes to a TAFKAL80ETC concert".
Then we put it out the inner if condition and add check "Backstage passes to TAFKAL80ETC" into it 
and we also remove the condition that check the item quality not full cause already checked before.
````
if (items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert") && items[i].getSellIn() < 11) {
    item[i].increaseQuality();
}

if (items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert") && items[i].sellIn < 6) {
    item[i].increaseQuality();
}
````
and also we change the operation of increase quality and move it to the Item class

````
class Item {
    ...
    public void increaseQuality() {
        quality++;
    }
    ...
}
````

That is it! we finally break the else code of first if, then we continue into the condition that 
check if item was not "Aged Brie" or "Backstage passes to a TAFKAL80ETC concert". we could merge this condition with the inner condition of it so will be like this:

````
if (!items[i].getName().equals("Aged Brie") && 
    !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert") && 
    !items[i].name.equals("Sulfuras, Hand of Ragnaros") &&
    items[i].hasQuality()) {
        item[i].decreaseQuality();
}
````

and we create a function on Item class to check is the item has quality and also decrease quality function
````
class Item {
    ...
    public boolean hasQuality() {
        return this.quality > 0;
    }
    
    public void decreaseQuality() {
        quality--;
    }
    ...
}

````

and we put the check item name to like this:

````
class Item {
    ...
    public boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }
    
    public boolean isBackstage() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }
    
    public boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros")
    }
    ...
}

````

also we separate all nested condition from the root condition then  the first if would be like this after we change a bit:

````
class GildedRose {
    
    ...
    
    public void updateQuantity() {
        if((item[i].isAgedBrie() || item[i].isBackstage()) && ! items[i].isQualityFull()) {
            item[i].increaseQuality();
        }
        
        if (items[i].isBackstaged() && item[i].getSellIn() < 11) {
            item[i].increaseQuality();
        }

        if (items[i].isBackstaged() && items[i].sellIn < 6) {
            item[i].increaseQuality();
        }
        
        if (!items[i].isAgedBrie() && !items[i].isBackstaged() && !items[i].isSulfuras() && item[i].hasQuality()) {
            item[i].decreaseQuality();
        }
    }

    ...

}
````

we will comeback soon!
