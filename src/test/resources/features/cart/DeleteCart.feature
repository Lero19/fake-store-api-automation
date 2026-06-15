@Regression
Feature: Cart Management

  Scenario Outline: Delete cart by id
    When I delete cart with id <id>
    Then response status should be 200
    And cart should be deleted successfully

    Examples:
      | id |
      | 1  |