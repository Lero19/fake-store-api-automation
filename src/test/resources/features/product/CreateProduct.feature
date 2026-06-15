@Regression
  Feature: Create Product
    Scenario: Create product
      When I create a new product
      Then response status should be 201
      And product should be created successfully
