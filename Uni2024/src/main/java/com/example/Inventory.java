package com.example;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void addItem(String name, int quantity, double price) {
        items.add(new Item(name, quantity, price));
    }

    public List<Item> getItems() {
        return items;
    }

    public void displayInventory() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            items.forEach(System.out::println);
        }
    }
}
