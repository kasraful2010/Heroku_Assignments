package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.AppiumWrapper;
import framework.page_object_model_web.HerokuPage;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class HerokuSD {

private HerokuPage herokuPage = new HerokuPage();


@Given("^User is on the Threely login page$")
    public void homePage (){}

// Heroku login senario
@When("^I enter username as “n12345@test.com” and password as “123456”$")
    public void enterUserName(){}

 @And("^I click on submit button$")
    public void clickonSubmitButton (){}

  @Then("^I verify logout button is displayed$")
    public void verifyLogoutButtonDisplayed(){}

}