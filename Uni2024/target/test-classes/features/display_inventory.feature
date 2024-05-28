Feature: Display Inventory

  Scenario: Display empty inventory
    Given the inventory is empty
    When I display the inventory
    Then the output should be "Inventory is empty."

  Scenario: Display inventory with one item
    Given the inventory has an item with name "Tomatoes", quantity 10, and price 2.5
    When I display the inventory
    Then the output should contain "Item{name='Tomatoes', quantity=10, price=2.5}"

  Scenario: Display inventory with multiple items
    Given the inventory has an item with name "Tomatoes", quantity 10, and price 2.5
    And the inventory has an item with name "Potatoes", quantity 5, and price 1.5
    When I display the inventory
    Then the output should contain "Item{name='Tomatoes', quantity=10, price=2.5}"
    And the output should contain "Item{name='Potatoes', quantity=5, price=1.5}"

  Scenario: Display inventory with zero quantity item
    Given the inventory has an item with name "Cucumbers", quantity 0, and price 1.0
    When I display the inventory
    Then the output should contain "Item{name='Cucumbers', quantity=0, price=1.0}"

  Scenario: Display inventory with negative price item
    Given the inventory has an item with name "Cabbage", quantity 3, and price -2.0
    When I display the inventory
    Then the output should contain "Item{name='Cabbage', quantity=3, price=-2.0}"
