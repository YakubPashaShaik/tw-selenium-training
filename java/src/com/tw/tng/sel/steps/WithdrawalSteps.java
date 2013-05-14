package com.tw.tng.sel.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

public class WithdrawalSteps extends BaseSteps {

    @Given("^I go to the cash machine$")
    public void I_go_to_the_cash_machine() {
        CashMachine().visit();
    }

    @When("^I select to withdraw \\$(\\d+)$")
    public void I_select_to_withdraw_$(int amount) {
        CashMachine().withdraw(amount);
    }

    @Then("^I should receive (\\d+) note of (.*)$")
    public void I_should_receive_$(int numNote, String noteType) {
        assertEquals(numNote, CashMachine().numDispencedNotes(noteType));
    }
}
