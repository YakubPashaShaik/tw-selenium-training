Feature: Cash Withdrawal

  As a User
  I want to withdraw some money from the Cash Machine
  So that I can use it

  Scenario: Withdrawal of an available amount
    Given I go to the cash machine
     When I select to withdraw $100
     Then I should receive 1 note of $100