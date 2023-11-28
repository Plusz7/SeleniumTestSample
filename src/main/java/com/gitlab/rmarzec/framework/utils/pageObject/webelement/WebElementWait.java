package com.gitlab.rmarzec.framework.utils.pageObject.webelement;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import com.gitlab.rmarzec.framework.utils.selenium.ApiRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.gitlab.rmarzec.framework.utils.DriverFactory.getDriver;

public class WebElementWait {

    private static final Logger LOG = LoggerFactory.getLogger(ApiRunner.class);
    private static WebDriverWait wait;

    public WebElementWait() {
        // Empty
    }

    public static WebDriverWait getWait() {
        return wait;
    }


    public static void waitForElementBy(By by, long seconds) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public static void waitForClassNamePresent(String className, long seconds) {
        waitForElementBy(By.className(className), seconds);
    }

    public static void waitForTagNamePresent(String tagName, long seconds) {
        waitForElementBy(By.tagName(tagName), seconds);
    }

    public static void waitForElementByXpath(String xpath, long seconds) {
        waitForElementBy(By.xpath(xpath), seconds);
    }

    public static void waitForElementById(String id, long seconds) {
        waitForElementBy(By.id(id), seconds);
    }

    public static void waitForElementByCssSelector(String cssSelector, long seconds) {
        waitForElementBy(By.cssSelector(cssSelector), seconds);
    }

    public static void waitForElementByClassName(long time, String className) {

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(time));

        wait.until(d -> d.findElement(By.className(className)));
    }

    public static void waitForElementByCss(long time, String css) {

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(time));

        wait.until(d -> d.findElement(By.cssSelector(css)));
    }
}
