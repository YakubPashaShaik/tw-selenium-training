package com.tw.tng.sel.pages;

import com.tw.tng.sel.hooks.Hooks;
import org.openqa.selenium.WebDriver;

import static com.tw.tng.sel.hooks.Hooks.*;

public class BasePage {

    protected WebDriver driver = Hooks.driver;

    public void visit(String pageUrl) {
        driver.get(baseUrl + "/" + pageUrl);
    }
}
