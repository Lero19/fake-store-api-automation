@Regression
Feature: Cart Management

  Scenario: Create a new cart
    When I create a new cart
    Then response status should be 201
    And cart should be created successfully