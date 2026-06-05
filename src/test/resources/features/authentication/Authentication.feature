@Regression
Feature: Authentication

  Scenario: Login with valid credentials
    When I login with valid credentials
    Then login should be successful