package framework.actions_web;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.lang.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;
import stepdefinition.SharedSD;

public class BasePage {

    //This method allows the chrome driver to wait.

    public static WebElement webAction(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");
        WebElement element = wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver){
                return driver.findElement(locator);
            }
        });
        return element;
    }

    public void clickOn(By locator)  {

        try{
            webAction(locator).click();
        }catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }

    }

    public void clear(By locator) {
        try {
            webAction(locator).clear();
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }

    public void sendText(By locator, String text) {
        try {
            webAction(locator).sendKeys(text);
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }

    public String getText(By locator) {
        String text = null;
        try {
            text = webAction(locator).getText();
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }

        return text;
    }

    public String getHour(int range) {
        Date day = new Date(); //Getting current date
        SimpleDateFormat sdf = new SimpleDateFormat("ha"); //Formating day variable into a particular pattern
        String currentHour = sdf.format(day);
        return currentHour;
    }

    public void clickOnBrowserBackArrow() {
        SharedSD.getDriver().navigate().back();
    }

    public void clickOnBrowserForwardArrow() {
        SharedSD.getDriver().navigate().forward();
    }

    public void refreshBrowser() {
        SharedSD.getDriver().navigate().refresh();
    }

    public void dropDownValue(By locator, String expectedText) {
        List<WebElement> dropDownList = SharedSD.getDriver().findElements(locator);
        for (WebElement list : dropDownList) {

            if (list.getText().equals(expectedText)) {
                break;

            }
        }
    }

    public void elementIsDisplayed (By locator) {
        List<WebElement> elements = SharedSD.getDriver().findElements(locator);
        for (WebElement ele : elements) {
            if (ele.isDisplayed()){
                System.out.println("Present");
                break;
            }
        }

    }



}
