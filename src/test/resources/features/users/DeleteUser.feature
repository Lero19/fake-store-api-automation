@Regression
Feature: User Management

  Scenario Outline: Delete user by id
    When I delete user with id <id>
    Then response status should be 200
    And user should be deleted successfully

    Examples:
      | id |
      | 1  |