package com.example;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InventoryStepDefinitions {

    private Inventory inventory;
    private ByteArrayOutputStream outputStream;

    @Given("the inventory is empty")
    public void the_inventory_is_empty() {
        inventory = new Inventory();
    }

    @When("I add an item with name {string}, quantity {int}, and price {double}")
    public void i_add_an_item_with_name_quantity_and_price(String name, int quantity, double price) {
        inventory.addItem(name, quantity, price);
    }

    @Then("the inventory should contain {int} item")
    public void the_inventory_should_contain_item(int itemCount) {
        assertEquals(itemCount, inventory.getItems().size());
    }

    @Then("the item {string} should have quantity {int} and price {double}")
    public void the_item_should_have_quantity_and_price(String name, int quantity, double price) {
        Item item = inventory.getItems().stream().filter(i -> i.getName().equals(name)).findFirst().orElse(null);
        assertNotNull(item);
        assertEquals(quantity, item.getQuantity());
        assertEquals(price, item.getPrice(), 0.01);
    }

    @Given("the inventory has an item with name {string}, quantity {int}, and price {double}")
    public void the_inventory_has_an_item_with_name_quantity_and_price(String name, int quantity, double price) {
        inventory = new Inventory();
        inventory.addItem(name, quantity, price);
    }

    @When("I display the inventory")
    public void i_display_the_inventory() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        inventory.displayInventory();
    }

    @Then("the output should be {string}")
    public void the_output_should_be(String expectedOutput) {
        String output = outputStream.toString().trim();
        assertEquals(expectedOutput, output);
    }



    @Then("the inventory should contain {int} items")
    public void the_inventory_should_contain_items(int itemCount) {
        assertEquals(itemCount, inventory.getItems().size());}


    @Then("the output should contain {string}")
    public void the_output_should_contain(String expectedOutput) {
        String actualOutput = outputStream.toString(); // Assuming outputStream is available
    }
}
