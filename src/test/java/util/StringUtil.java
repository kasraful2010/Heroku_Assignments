package util;

import framework.actions_web.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class StringUtil extends BasePage {

    public int subStringToInt(By locator, int start, int end) {
        String result = getText(locator).substring(start, end);
        return Integer.parseInt(result);
    }

    public void compareText(By locator,String expectedText){

        try{
            Assert.assertEquals(getText(locator),expectedText);
        }catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }

    }
}
