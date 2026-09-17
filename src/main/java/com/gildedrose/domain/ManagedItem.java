package com.gildedrose.domain;

public final class ManagedItem {

    private final Item item;
    private final ItemType type;

    public ManagedItem(Item item) {
        this.item = item;
        this.type = ItemType.fromName(item.name);
    }

    public Item getItem() {
        return item;
    }

    public ItemType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ManagedItem{" +
            "item=" + item +
            ", type=" + type +
            '}';
    }
}
