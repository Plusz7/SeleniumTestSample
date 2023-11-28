package com.gitlab.rmarzec.framework.utils.pageObject;

import com.gitlab.rmarzec.framework.utils.DriverFactory;

public class PageObject {

    private PageObject() {}

    /**
     * Back action in browser
     */
    public static void back() {
        DriverFactory.getDriver().navigate().back();
    }

    /**
     * Forward action in browser
     */
    public static void forward() {
        DriverFactory.getDriver().navigate().forward();
    }

    /**
     * Reload action in browser
     */
    public static void reload() {
        DriverFactory.getDriver().navigate().refresh();
    }

}
