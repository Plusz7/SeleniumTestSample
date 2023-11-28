package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import com.gitlab.rmarzec.framework.utils.navigation.GooglePage;
import com.gitlab.rmarzec.framework.utils.pageObject.PageObjectElement;
import com.gitlab.rmarzec.framework.utils.pageObject.webelement.SwitchTo;
import com.gitlab.rmarzec.framework.utils.pageObject.webelement.WebElementWait;
import com.gitlab.rmarzec.framework.utils.selenium.ApiRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static com.gitlab.rmarzec.framework.utils.DriverFactory.getDriver;

public class Task3Test extends ApiRunner {

    private static final String GOOGLE_URL = "https://www.google.com/";
    private static final String SEARCH_BAR_INPUT = "HTML select tag - W3Schools";
    private static final String DESIGNATED_URL = "https://www.w3schools.com/tags/tag_select.asp";
    private static final String SELECT_ELEMENT_XPATH = "//h1[text()='The select element']";
    private static final String OPEL_ELEMENT_XPATH = "//select[@id='cars']/option[@value='opel']";
    private static final String VALUE = "value";

    @Test
    public void Task3Test() {
        start(GOOGLE_URL);
        GooglePage googlePage = new GooglePage();
        googlePage.acceptCookiesClick();
        googlePage.inputTextArea(SEARCH_BAR_INPUT);
        googlePage.clickLuckyHit();
        checkIfDesignatedUrlPresent(DESIGNATED_URL);
        googlePage.w3SchoolsPage.acceptCookies();
        googlePage.w3SchoolsPage.clickTryItYourselfButton();
        googlePage.w3SchoolsPage.switchToNewTab();
        googlePage.w3SchoolsPage.switchToExerciseIframe();

        System.out.println(PageObjectElement.getElementByXpath(SELECT_ELEMENT_XPATH).getText());
        WebElement opelElement = PageObjectElement.getElementByXpath(OPEL_ELEMENT_XPATH);
        System.out.println(opelElement.getText() + " " + opelElement.getAttribute(VALUE));
    }

    private static void checkIfDesignatedUrlPresent(String url) {
        if (!getDriver().getCurrentUrl().equals(url)) {
            System.out.println("Designated url not present. Current URL is " + getDriver().getCurrentUrl());
        }
    }
}
