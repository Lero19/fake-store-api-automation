@Regression
  Feature: Delete Product
    Scenario Outline: Delete product
      When I delete product with id <id>
      Then response status should be 200
      And product should be deleted successfully

      Examples:
        | id |
        | 1  |