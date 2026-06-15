@Regression
  Feature: Update Product Details
    Scenario Outline: Update product
      When I update product with id <id>
      Then response status should be 200
      And product should be updated successfully

      Examples:
        | id |
        | 1  |