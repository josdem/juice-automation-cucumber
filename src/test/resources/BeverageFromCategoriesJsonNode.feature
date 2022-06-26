Feature: Get a specific beverage by category using JsonNode
  Scenario: User navigate from categories to specific beverage
    Given List of json node categories
    When I get a json node beverages by category
    Then I get a json node specific beverage
