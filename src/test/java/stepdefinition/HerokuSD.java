package stepdefinition;

import cucumber.api.PendingException;
import framework.page_object_model_web.HerokuPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.AppiumWrapper;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class HerokuSD {
    private HerokuPage herokuPage = new HerokuPage();

// Heroku login scenario

    @Given("^User is on the Threely login page$")
    public void loginInPage() {
        herokuPage.clickSignInButton();
        herokuPage.veryLogInPageTitle();
    }


    @When("^I enter username as “(.+)” and password as “(.+)”$")
    public void enterUserName(String userName, String password) {
        //herokuPage.clickSignInButton();
        herokuPage.enterEmailUsername(userName, password);
    }

    @And("^I click on submit button$")
    public void clickonSubmitButton() {
        herokuPage.clickSubmit();
    }

    @Then("^I verify (.+) button is displayed$")
    public void verifyLogoutButtonDisplayed(String text) {
        herokuPage.verifyLogoutButton(text);
    }

    //Heroku auto complete search Scenario

    @When("^When I search on top search bar with text \"(.+)\"$")
    public void enterSearchValue(String text) {
        herokuPage.sendSearchText(text);
    }

    @Then("^I verify \"(.+)\" as displayed result$")
    public void verifyTitle(String text) {
        herokuPage.verifyAutoCompleteDisplayed(text);
    }

    //     Verify valid registration
    @Given("^I am on Registration page$")

    public void registrationPage() {
        herokuPage.clickOnJoinButton();
    }

    @When("^I enter name as \"(.+)\" email as \"(.+)\" password as \"(.+)\"$")
    public void enterName(String userName, String email, String password) {
        herokuPage.sendRegistrationText(userName, email, password);
    }

    @And("^I click 'submit' button$")

    public void Submit() {
        herokuPage.clickSubmit();
    }

    @Then("^I am signed-in as a new user$")
    public void UserSignIn() {
        herokuPage.verifyRegistrationMessage();
    }

    //     Verify invalid email on registration
    @When("^I enter name as \"([^\"]*)\" email as ([^\"]*) password as \"([^\"]*)\"$")
    public void iEnterNameAsEmailAsEmailPasswordAs(String userName, String email, String password)  {
        herokuPage.clickOnJoinButton();
        herokuPage.enterRegInfo(userName, email, password);
        herokuPage.clickSubmit();
    }

    @Then("^I verify invalid email address$")
    public void iVerifyInvalidEmailAddress() { }
}





