@Regression
Feature: Cart Management

  Scenario Outline: Update cart by id
    When I update cart with id <id>
    Then response status should be 200
    And cart should be updated successfully

    Examples:
      | id |
      | 1  |