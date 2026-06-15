@Regression
Feature: Cart Management

  Scenario: Get all carts
    When I request all carts
    Then response status should be 200
    And response should contain list of carts