package com.tw.tng.sel.unit;


import junit.extensions.TestSetup;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class WithdrawalTest {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testWithdrawal$100() {
        visitCashman();
        withdraw(100);
        assertEquals(100, totalDispensed());
    }

    private void visitCashman() {
        driver.get("http://tomcat.corsamore.com/cashman");
    }

    private void withdraw(int amount) {
        driver.findElement(By.id("cashmachine_withdrawalAmount")).sendKeys(String.valueOf(amount));
        driver.findElement(By.id("cashmachine_Withdraw")).click();
    }

    private int totalDispensed() {
        int total = 0;
        List<WebElement> elements = driver.findElement(By.id("cashmachine_Withdrawal")).findElements(By.tagName("tr"));
        for(WebElement element : elements) {
            List<WebElement> dispensedNote = element.findElements(By.tagName("td"));
            if(dispensedNote.size()<=1) continue;
            String typeOfDispensedNote =  dispensedNote.get(0).getText();
            String numOfDispensedNote  =  dispensedNote.get(1).getText();
            total += Integer.parseInt(numOfDispensedNote)*Integer.parseInt(typeOfDispensedNote.replaceAll("\\$", ""));
        }
        return total;
    }

}
