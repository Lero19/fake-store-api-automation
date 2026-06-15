@Regression
Feature: Update Users

  Scenario Outline: Update user by id
    When I update user with id <id>
    Then response status should be 200
    And user should be updated with id <id>

    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
