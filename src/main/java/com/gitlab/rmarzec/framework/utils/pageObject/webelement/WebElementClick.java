package com.gitlab.rmarzec.framework.utils.pageObject.webelement;

import com.gitlab.rmarzec.framework.utils.pageObject.PageObjectElement;
import com.gitlab.rmarzec.framework.utils.selenium.ApiRunner;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebElementClick {

    private static final Logger LOG = LoggerFactory.getLogger(ApiRunner.class);

    private static final String JS_SCROLL = "arguments[0].scrollIntoView(true);";
    private static final String JS_CLICK = "arguments[0].click();";

    private WebElementClick() {}

    public static void clickByXpath(String xpath) {
        LOG.info("Clicking element by xpath: " + xpath);
        PageObjectElement.getElementByXpath(xpath).click();
    }

    public static void clickById(String id) {
        LOG.info("Clicking element by id: " + id);
        PageObjectElement.getElementById(id).click();
    }

    public static void clickByCss(String css) {
        LOG.info("Clicking element by css: " + css);
        PageObjectElement.getElementByCss(css).click();
    }

    public static void clickBy(By by) {
        LOG.info("Clicking element.");
        PageObjectElement.getElementBy(by).click();
    };
}
