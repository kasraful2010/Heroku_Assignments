package framework.page_object_model_web;

import framework.actions_web.BasePage;
import org.openqa.selenium.By;

public class HerokuPage extends BasePage {

private By signIn = By.xpath("//a[contains(text(),'Sign In')]");
private By email = By.xpath("//input[@id='email']");
private By passwordSignin = By.xpath("//input[@id='password']");
private By submitButton = By.xpath("//button[@type='submit']");
private By accountIcon = By.xpath("//img[@class='img-circle']");



public void clickSignInButton()throws InterruptedException{
    clickOn(signIn);
}

public void enterEmailUsername(String userName,String password)throws InterruptedException{
    sendText(email,userName);
    sendText(passwordSignin,password);
}

public void clickSubmit()throws InterruptedException{
    clickOn(submitButton);
}

public void verifyLogoutButton(String text)throws InterruptedException{
    dropDownValue(accountIcon,text);

}

}
