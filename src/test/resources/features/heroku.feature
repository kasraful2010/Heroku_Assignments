@heroku-regression
Feature: herokuApp

  Background:
    Given User is on the Threely login page

  @heroku-login
  Scenario: Verify valid login
    When I enter username as “n12345@test.com” and password as “123456”
    And I click on submit button
    Then I verify logout button is displayed

  @heroku-auto-complete-search
  Scenario:Verify auto complete search result
    When When I search on top search bar with text "ios"
    Then I verify "TItle: I will teach you IOS" as displayed result

  @heroku-registration-valid-email
  Scenario: Verify a new user can register with a valid email address
    Given I am on Registration page
    When I enter name as "testuser" email as "test@test.com" password as "test12345"
    And I click 'submit' button
    Then I am signed-in as a new user

  @heroku-invalid-email
  Scenario Outline: Verify invalid email on registration

    When I enter name as "testuser" email as <email> password as "test12345"
    Then I verify invalid email address

    Examples:
      | email              |
      | test.com           |
      | test@test@test.com |

  @heroku-total-post
  Scenario: Verify total number of posts on home page
    Then I verify 94 total post is displayed
    And I verify all post has price tag
    And I verify all post has title
    And  I verify all post has displayed image
