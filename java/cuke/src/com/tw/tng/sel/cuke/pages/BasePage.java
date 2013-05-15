package com.tw.tng.sel.cuke.pages;

import com.tw.tng.sel.cuke.hooks.Hooks;
import org.openqa.selenium.WebDriver;

import static com.tw.tng.sel.cuke.hooks.Hooks.*;

public class BasePage {

    protected WebDriver driver = Hooks.driver;

    public void visit(String pageUrl) {
        driver.get(baseUrl + "/" + pageUrl);
    }
}
