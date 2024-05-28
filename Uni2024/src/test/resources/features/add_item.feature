Feature: Add Item

  Scenario: Add a valid item
    Given the inventory is empty
    When I add an item with name "Tomatoes", quantity 10, and price 2.5
    Then the inventory should contain 1 item
    And the item "Tomatoes" should have quantity 10 and price 2.5

  Scenario: Add another valid item
    Given the inventory is empty
    When I add an item with name "Potatoes", quantity 5, and price 1.5
    Then the inventory should contain 1 item
    And the item "Potatoes" should have quantity 5 and price 1.5

  Scenario: Add multiple items
    Given the inventory is empty
    When I add an item with name "Tomatoes", quantity 10, and price 2.5
    And I add an item with name "Potatoes", quantity 5, and price 1.5
    Then the inventory should contain 2 items
    And the item "Tomatoes" should have quantity 10 and price 2.5
    And the item "Potatoes" should have quantity 5 and price 1.5

  Scenario: Add item with zero quantity
    Given the inventory is empty
    When I add an item with name "Cucumbers", quantity 0, and price 1.0
    Then the inventory should contain 1 item
    And the item "Cucumbers" should have quantity 0 and price 1.0

  Scenario: Add item with negative price
    Given the inventory is empty
    When I add an item with name "Cabbage", quantity 3, and price -2.0
    Then the inventory should contain 1 item
    And the item "Cabbage" should have quantity 3 and price -2.0
