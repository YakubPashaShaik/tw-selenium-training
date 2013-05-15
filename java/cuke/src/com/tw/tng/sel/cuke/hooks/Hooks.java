package com.tw.tng.sel.cuke.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {

    public static WebDriver driver;
    public static String baseUrl;

    @Before
    public void beforeScenario() {
        if(driver==null) {
            driver = new FirefoxDriver();
        }
        if(baseUrl==null) {
            baseUrl = "http://tomcat.corsamore.com";
        }
    }

    @After
    public void afterScenario() {
         driver.close();
    }
}
