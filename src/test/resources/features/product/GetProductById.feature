@Regression
  Feature: Get Product by Id
    Scenario Outline: Get product by id
      When I request product with id <id>
      Then response status should be 200
      And response should contain product with id <id>

      Examples:
        | id |
        | 1  |