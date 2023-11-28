package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.navigation.WikiPage;
import com.gitlab.rmarzec.framework.utils.selenium.ApiRunner;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

public class Task2Test extends ApiRunner {

    private static final String WIKI_URL = "https://pl.wikipedia.org/wiki/Wiki";
    private static final String ENGLISH_STRING = "English";
    private static final String HREF_ELEMENT_ATTRIBUTE = "href";

    @Test
    public void Task2Test(){
        start(WIKI_URL);
        WikiPage wikiPage = new WikiPage();
        wikiPage.confirmWikiLogoPresent();
        wikiPage.clickLanguageDropdownMenuButton();
        wikiPage.confirmLanguageDropdownMenuListPresent();
        List<WebElement> listOfLanguages = wikiPage.getListOfLanguages();
        wikiPage.printLanguagesFromDropDownMenu(listOfLanguages);

        printLinkForEnglishLanguageIfPresent(listOfLanguages);
    }

    private static void printLinkForEnglishLanguageIfPresent(List<WebElement> listOfLanguages) {
        Optional<WebElement> englishElement = listOfLanguages.stream().filter(element -> ENGLISH_STRING.equals(element.getText())).findFirst();
        englishElement.ifPresent(webElement -> System.out.println(webElement.getAttribute(HREF_ELEMENT_ATTRIBUTE)));
    }
}
