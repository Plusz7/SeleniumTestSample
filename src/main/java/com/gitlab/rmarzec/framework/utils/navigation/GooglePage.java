package com.gitlab.rmarzec.framework.utils.navigation;

import com.gitlab.rmarzec.framework.utils.pageObject.PageObjectElement;
import com.gitlab.rmarzec.framework.utils.pageObject.webelement.SwitchTo;
import com.gitlab.rmarzec.framework.utils.pageObject.webelement.WebElementWait;
import org.openqa.selenium.WebElement;

public class GooglePage {
    private static final long GOOGLE_WAIT_TIME_LONG = 5;
    private static final String GOOGLE_ACCEPT_COOKIES_XPATH = "//button[.//div[contains(text(), 'Zaakceptuj wszystko')]]";
    private static final String GOOGLE_TEXT_AREA_TAGNAME = "textarea";
    private static final String GOOGLE_LUCKY_HIT_CSS = "input[value='Szczęśliwy traf']";

    public W3SchoolsPage w3SchoolsPage = new W3SchoolsPage();

    public GooglePage() {
    }

    public void acceptCookiesClick() {
        WebElementWait.waitForElementByXpath(GOOGLE_ACCEPT_COOKIES_XPATH, GOOGLE_WAIT_TIME_LONG);
        PageObjectElement.getElementByXpath(GOOGLE_ACCEPT_COOKIES_XPATH).click();
    }

    public void inputTextArea(String searchBarInput) {
        WebElementWait.waitForTagNamePresent(GOOGLE_TEXT_AREA_TAGNAME, GOOGLE_WAIT_TIME_LONG);
        WebElement textarea = PageObjectElement.getElementByTagName(GOOGLE_TEXT_AREA_TAGNAME);
        textarea.click();
        textarea.sendKeys(searchBarInput);
    }

    public void clickLuckyHit() {
        PageObjectElement.getElementByCss(GOOGLE_LUCKY_HIT_CSS).click();
    }
    public class W3SchoolsPage {

        private static final String W3_ACCEPT_COOKIES_ID = "accept-choices";
        private static final String W3_TRY_IT_YOURSELF_BUTTON_CSS = "a.w3-btn.w3-margin-bottom";
        private static final String W3_EXERCISE_TAB_CONTAINER_ID = "container";
        private static final String W3_EXERCISE_IFRANE_ID = "iframeResult";

        private W3SchoolsPage() {
        }

        public void acceptCookies() {
            WebElementWait.waitForElementById(W3_ACCEPT_COOKIES_ID, GOOGLE_WAIT_TIME_LONG);
            PageObjectElement.getElementById(W3_ACCEPT_COOKIES_ID).click();
        }

        public void clickTryItYourselfButton() {
            PageObjectElement.getElementByCss(W3_TRY_IT_YOURSELF_BUTTON_CSS).click();
        }

        public void switchToNewTab() {
            SwitchTo.switchToWindow();
            WebElementWait.waitForElementById(W3_EXERCISE_TAB_CONTAINER_ID, GOOGLE_WAIT_TIME_LONG);
        }

        public void switchToExerciseIframe() {
            WebElement iFrame = PageObjectElement.getElementById(W3_EXERCISE_IFRANE_ID);
            SwitchTo.switchToFrame(iFrame);
        }

    }
}

