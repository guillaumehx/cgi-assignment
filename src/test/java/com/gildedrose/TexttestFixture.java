package com.gildedrose;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.ManagedItem;

import java.util.List;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        List<ManagedItem> items = List.of(
            new ManagedItem(new Item("+5 Dexterity Vest", 10, 20)),
            new ManagedItem(new Item("Aged Brie", 2, 0)),
            new ManagedItem(new Item("Elixir of the Mongoose", 5, 7)),
            new ManagedItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80)),
            new ManagedItem(new Item("Sulfuras, Hand of Ragnaros", -1, 80)),
            new ManagedItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)),
            new ManagedItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49)),
            new ManagedItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)),
            new ManagedItem(new Item("Conjured Mana Cake", 3, 6))
        );

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (ManagedItem item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
