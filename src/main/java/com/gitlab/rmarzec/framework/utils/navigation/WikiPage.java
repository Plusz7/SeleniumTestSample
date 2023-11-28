package com.gitlab.rmarzec.framework.utils.navigation;

import com.gitlab.rmarzec.framework.utils.pageObject.PageObjectElement;
import com.gitlab.rmarzec.framework.utils.pageObject.webelement.WebElementWait;
import com.gitlab.rmarzec.framework.utils.selenium.ApiRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WikiPage {

    private static final Logger LOG = LoggerFactory.getLogger(ApiRunner.class);


    private static final long WIKI_WAIT_TIME_LONG = 5;
    private static final String WIKI_LOGO_ID = "mw-logo";
    private static final String LANGUAGE_DROPDOWN_MENU_BUTTON_ID = "p-lang-btn-checkbox";
    private static final String LANGUAGE_DROPDOWN_MENU_LIST_CLASSNAME = "uls-language-list";
    private static final String LIST_OF_LANGUAGES_CSS = "div.uls-language-list a[title][hreflang]";

    public WikiPage() {}

    public void confirmWikiLogoPresent() {
        WebElementWait.waitForElementByClassName(WIKI_WAIT_TIME_LONG, WIKI_LOGO_ID);
        LOG.info("Wiki logo present. Element by class name " + WIKI_LOGO_ID);
    }

    public void clickLanguageDropdownMenuButton() {
        WebElementWait.waitForElementById(LANGUAGE_DROPDOWN_MENU_BUTTON_ID, WIKI_WAIT_TIME_LONG);
        PageObjectElement.getElementById(LANGUAGE_DROPDOWN_MENU_BUTTON_ID).click();
    }

    public void confirmLanguageDropdownMenuListPresent() {
        WebElementWait.waitForClassNamePresent(LANGUAGE_DROPDOWN_MENU_LIST_CLASSNAME, WIKI_WAIT_TIME_LONG);
        LOG.info("Language dropdown manu present. Element class name: " + LANGUAGE_DROPDOWN_MENU_LIST_CLASSNAME);
    }

    public void printLanguagesFromDropDownMenu(List<WebElement> list) {
        for (WebElement link : list) {
            System.out.println(link.getText());
        }
    }

    public List<WebElement> getListOfLanguages() {
        return PageObjectElement.getElementsBy(By.cssSelector(LIST_OF_LANGUAGES_CSS));
    }
}
