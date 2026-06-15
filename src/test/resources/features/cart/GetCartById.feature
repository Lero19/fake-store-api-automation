@Regression
Feature: Cart Management

  Scenario Outline: Get cart by id
    When I request cart with id <id>
    Then response status should be 200
    And response should contain cart with id <id>

    Examples:
      | id |
      | 1  |
      | 2  |