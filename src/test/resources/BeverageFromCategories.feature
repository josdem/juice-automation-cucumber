Feature: Get a specific beverage by category using Map
  Scenario: User navigate from categories to specific beverage
    Given List of map categories
    When I get a map beverages by category
    Then I get a map specific beverage