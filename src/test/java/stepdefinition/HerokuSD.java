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
@When("^I enter username as “(.+)” and password as “(.+)”$")
    public void enterUserName(String userName,String password)throws InterruptedException{
    herokuPage.clickSignInButton();
    herokuPage.enterEmailUsername(userName,password);
}

 @And("^I click on submit button$")
    public void clickonSubmitButton ()throws InterruptedException{herokuPage.clickSubmit();}

  @Then("^I verify (.+) button is displayed$")
    public void verifyLogoutButtonDisplayed(String text)throws InterruptedException{herokuPage.verifyLogoutButton(text);}

}