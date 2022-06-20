Feature: Get a specific beverage by category
  Scenario: User navigate from categories to specific beverage
    Given List of categories
    When I get beverages by category
    Then I get specific beverage