@Regression
  Feature: Get All Products

    Scenario: Get all products
    When I request all products
    Then response status should be 200
    And response should contain list of products