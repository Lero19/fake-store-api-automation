# Fake Store API Automation Framework

## Overview
This project is an end-to-end REST API automation framework built using:
- Java
- REST Assured
- Cucumber (BDD)
- TestNG
- Jenkins (CI/CD)
- Allure Reporting

## Features
- Full CRUD automation for:
    - Users
    - Carts
    - Products
- Authentication testing
- Positive and Negative test scenarios
- Scenario Outline (data-driven testing)
- Framework based on layered architecture:
  Client → Service → Validator → Step Definitions

## ⚙️ CI/CD
- Jenkins pipeline integration
- Automated test execution on push
- Scheduled runs supported

## Reporting
- Allure integrated reports
- Execution insights with graphs and logs

## Design Approach
- Separation of concerns
- Reusable components
- Scalable structure for enterprise usage

## Known Limitations
- FakeStore API does not follow proper HTTP codes (e.g. returns 200 instead of 404)
- Tests adapted accordingly to handle API inconsistencies

## ▶️ How to Run -- bash mvn clean test