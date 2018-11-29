@heroku-regression
Feature: herokuApp

  Background:
    Given User is on the Threely login page

  @heroku-Login
  Scenario: Verify valid login
    When I enter username as “n12345@test.com” and password as “123456”
    And I click on submit button
    Then I verify logout button is displayed