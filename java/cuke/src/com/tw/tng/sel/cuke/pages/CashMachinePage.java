package com.tw.tng.sel.cuke.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CashMachinePage extends BasePage {

    private static final String PAGE_URL = "cashman";

    private By withdrawalAmount    = By.id("cashmachine_withdrawalAmount");
    private By withdrawalConfirm   = By.id("cashmachine_Withdraw");
    private By withdrawalNotes      = By.id("cashmachine_Withdrawal");

    public void visit() {
        super.visit(PAGE_URL);
    }

    public void withdraw(int amount) {
        driver.findElement(withdrawalAmount).sendKeys(String.valueOf(amount));
        driver.findElement(withdrawalConfirm).click();
    }

    public int numDispencedNotes(String note) {
        List<WebElement> elements = driver.findElement(withdrawalNotes).findElements(By.tagName("tr"));
        for(WebElement element : elements) {
            List<WebElement> dispensedNote = element.findElements(By.tagName("td"));
            if(dispensedNote.size()<=1) continue;
            String typeOfDispensedNote =  dispensedNote.get(0).getText();
            String numOfDispensedNote  =  dispensedNote.get(1).getText();
            if(typeOfDispensedNote.equals(note)) {
                return Integer.parseInt(numOfDispensedNote);
            }
        }
        return -1;
    }

}
