package com.gitlab.rmarzec.framework.utils;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
    public WebDriver initDriver(){
        WebDriverManager.getInstance(FirefoxDriver.class).driverVersion("0.30.0").setup();
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        tlDriver.set(webDriver);
        return getDriver();
    }

    public static void quit() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
