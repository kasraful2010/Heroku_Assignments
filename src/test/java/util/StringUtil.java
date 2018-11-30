package util;

import framework.actions_web.BasePage;
import org.openqa.selenium.By;

public class StringUtil extends BasePage {

    public int subStringToInt(By locator, int start, int end) {
        String result = getText(locator).substring(start, end);
        return Integer.parseInt(result);
    }


}
