@heroku-regression
Feature: herokuApp

  Background:
    Given User is on the Threely login page

  @heroku-Login
  Scenario: Verify valid login
    When I enter username as “n12345@test.com” and password as “123456”
    And I click on submit button
    Then I verify logout button is displayed

   @heroku-Auto-Complete-Search
   Scenario:Verify auto complete search result
    When When I search on top search bar with text "ios"
    Then I verify "TItle: I will teach you IOS" as displayed result

