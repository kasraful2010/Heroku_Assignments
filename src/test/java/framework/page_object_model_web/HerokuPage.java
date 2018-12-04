package framework.page_object_model_web;

import framework.actions_web.BasePage;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;
import util.StringUtil;

import java.util.List;

public class HerokuPage extends BasePage {

    StringUtil stringUtil = new StringUtil();

    private By signInButton = By.xpath("//a[contains(text(),'Sign In')]");
    private By loginPageTitle = By.xpath("//h1[@class='space-top text-center']");
    private By email = By.xpath("//input[@id='email']");
    private By passwordSignin = By.xpath("//input[@id='password']");
    private By submitButton = By.xpath("//button[@type='submit']");
    private By accountIcon = By.xpath("//img[@class='img-circle']");
    private By searchTextField = By.xpath("//input[@id='aa-search-input']");
    private By autoCompleteSearch = By.xpath("//span[@id='algolia-autocomplete-listbox-0']");
    private By joinButton = By.xpath("//a[@class='btn btn-success']");
    private By userNameTextField = By.xpath("//input[@name='username']");
    private By emailTextField = By.xpath("//input[@name='email']");
    private By passwordTextField = By.xpath("//input[@name='password']");
    private By logInMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    private By homePage = By.xpath("//a[@class='navbar-brand']");
    private By allPost = By.xpath("//div[@class='container section']//descendant::div[@class='gig-card']");
    private By allTag = By.xpath("//div[@class='container section']//descendant::h3");
    private By allTitle = By.xpath("//div[@class='container section']//descendant::h4");
    private By allImg = By.xpath("//div[@class='container section']//descendant::img");

    public void clickSignInButton() {
        clickOn(signInButton);
    }

    public void veryLogInPageTitle() {
        String message = getText(loginPageTitle);
        stringUtil.compareText(loginPageTitle, message);

    }

    public void enterEmailUsername(String userName, String password) {
        sendText(email, userName);
        sendText(passwordSignin, password);
    }

    public void clickSubmit() {
        clickOn(submitButton);
    }

    public void verifyLogoutButton(String text) {
        dropDownValue(accountIcon, text);
    }

    public void sendSearchText(String text) {
        sendText(searchTextField, text);
    }

    public void verifyAutoCompleteDisplayed(String text) {
        dropDownValue(autoCompleteSearch, text);
    }


    public void clickOnJoinButton() {
        clickOn(joinButton);
    }

    public void sendRegistrationText(String userName, String email, String password) {
        sendText(userNameTextField, userName);
        sendText(emailTextField, email);
        sendText(passwordTextField, password);

    }

    public void verifyRegistrationMessage() {
        String message = getText(logInMessage);
        stringUtil.compareText(logInMessage, message);
    }


    public void enterRegInfo(String userName, String email, String password) {
        sendText(userNameTextField, userName);
        sendText(emailTextField, email);
        sendText(passwordTextField, password);

    }

    public void clickOnHomePage() {clickOn(homePage);}

    public void verifyAllPost(int posts) {
        clickOnHomePage();
      List<WebElement> elements = SharedSD.getDriver().findElements(allPost);
        int numPost = elements.size();
        Assert.assertTrue(numPost == posts);
    }

    public void verifyAllPriceTags () {
        elementIsDisplayed(allTag);

    }

    public void verifyAllPostTitle(){
        elementIsDisplayed(allTitle);

    }

    public void verifyAllDisplayedImage(){

        elementIsDisplayed(allImg);

    }

}


