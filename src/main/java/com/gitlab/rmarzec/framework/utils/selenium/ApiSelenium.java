package com.gitlab.rmarzec.framework.utils.selenium;

import com.gitlab.rmarzec.framework.utils.pageObject.webelement.WebElementWait;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import static com.gitlab.rmarzec.framework.utils.pageObject.PageObjectElement.*;

public class ApiSelenium {

    private ApiSelenium() {}

    public static boolean isDisplayedByClassName(String className) {
        return getElementByClassName(className).isDisplayed();
    }

    public static boolean isDisplayedById(String id) {
        return getElementById(id).isDisplayed();
    }

    public static boolean isPresent(By by, int wait) {
        try {
            WebElementWait.waitForElementBy(by, wait);
        } catch (TimeoutException | NoSuchElementException ie) {
//            LOGGER.info(ie);
//            LOGGER.info(ELEMENT + id + NOT_PRESENT);
            return false;
        }
        return true;
    }


}
