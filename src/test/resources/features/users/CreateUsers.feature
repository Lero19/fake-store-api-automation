@Regression

Feature: Create Users

  Scenario: Create a new user
    When I create a new user
    Then response status should be 201
    And user should be created successfully
