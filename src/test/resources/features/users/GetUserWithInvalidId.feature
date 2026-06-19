@Regression
  Feature: Negative Scenarios
    Scenario: Get user with invalid id
      When I request user with id 9999
      Then response status should be 200

