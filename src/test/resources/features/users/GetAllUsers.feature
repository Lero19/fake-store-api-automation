Feature: Get All Users

  @Regression
  Scenario: Get all users successfully
    When I request all users
    Then response status should be 200
    And response should contain list of users