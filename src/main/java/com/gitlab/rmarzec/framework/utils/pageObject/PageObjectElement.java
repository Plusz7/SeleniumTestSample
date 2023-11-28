package com.gitlab.rmarzec.framework.utils.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

import static com.gitlab.rmarzec.framework.utils.DriverFactory.getDriver;

public class PageObjectElement {

    private static final String VALUE = "value";

    protected PageObjectElement() {}

    public static WebElement getElementBy(By by) {
        return getDriver().findElement(by);
    }

    public static WebElement getElementByXpath(String xpath) {
        return getElementBy(By.xpath(xpath));
    }

    public static WebElement getElementByTagName(String tagName) {
        return getElementBy(By.tagName(tagName));
    }

    public static WebElement getElementByCss(String css) {
        return getElementBy(By.cssSelector(css));
    }


    public static WebElement getElementById(String id) {
        return getElementBy(By.id(id));
    }


    public static WebElement getElementByText(String text) { return getElementBy(By.linkText(text)); }



    public static List<WebElement> getElementsBy(By by) { return getDriver().findElements(by); }


    public static List<WebElement> getElementsByXpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    public static List<WebElement> getElementsById(String id) {
        return getElementsBy(By.id(id));
    }


    public static List<String> getTextValuesFromWebElementList(String xpath) {
        List<String> textValues = new LinkedList<>();
        for (WebElement value : getElementsByXpath(xpath)) {
            textValues.add(value.getText());
        }
        return textValues;
    }

    public static List<String> getAttributeValuesFromWebElementList(String xpath) {
        List<String> textValues = new LinkedList<>();
        for (WebElement value : getElementsByXpath(xpath)) {
            textValues.add(value.getAttribute(VALUE));
        }
        return textValues;
    }


    public static List<String> getAttrValuesFromWebElementList(String xpath, String attr) {
        List<String> attrValues = new LinkedList<>();
        for (WebElement value : getElementsByXpath(xpath)) {
            attrValues.add(value.getAttribute(attr));
        }
        return attrValues;
    }


    public static WebElement getElementByClassName(String className) {
        return getDriver().findElement(By.className(className));
    }
}
