package com.gitlab.rmarzec.framework.utils.selenium;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;

public class ApiRunner {

    private static final Logger LOG = LoggerFactory.getLogger(ApiRunner.class);
    @AfterTest
    public static void endTest() {
        DriverFactory.quit();
    }

    public static void start(String url) {
        DriverFactory driverFactory = new DriverFactory();
        LOG.info("Initializing web-driver.");
        WebDriver webDriver = driverFactory.initDriver();
        LOG.info("Loading " + url);
        webDriver.get(url);
    }
}
