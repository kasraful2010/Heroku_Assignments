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

#  @Scenario: Verify a new user can register with a valid email address
#    Given I am on Registration page
#    When I enter name as "testuser" email as "test@test.com" password as "test12345"
#    And I click 'submit' button
#    Then  I am signed-in as a new user