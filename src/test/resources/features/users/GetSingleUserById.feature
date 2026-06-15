@Regression
Feature: Get A Single User By Id

  Scenario Outline: Get a single user by id
    When I request user with id <id>
    Then response status should be 200
    And response should contain user with id <id>

    Examples:
      | id |
      | 1  |