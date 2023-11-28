package com.gitlab.rmarzec.framework.utils.pageObject.webelement;

import com.gitlab.rmarzec.framework.utils.selenium.ApiRunner;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Set;

import static com.gitlab.rmarzec.framework.utils.DriverFactory.getDriver;

public class SwitchTo {

    private static final Logger LOG = LoggerFactory.getLogger(ApiRunner.class);
    private static LinkedList<String> parentStack = new LinkedList<>();

    private SwitchTo() {}

    public static void switchToFrame(WebElement element) {
        LOG.info("Switching to frame.");
        getDriver().switchTo().frame(element);
    }

    public static void switchToWindow() {
        Set<String> windowHandles = getDriver().getWindowHandles();
        for (String iterHandle : windowHandles) {
            if (!parentStack.contains(iterHandle)) {
                parentStack.push(iterHandle);
                getDriver().switchTo().window(iterHandle);
                LOG.info("Switched to window " + iterHandle);
            }
        }
    }
}
