Feature: Account statement

  Background:
    Given Account exists for Acc No. "12345678" with Name "Bob Smith"
    And deposits are made
      | INIT | 200 |
      | DEP1 | 100 |
      | DEP2 | 450 |
      | DEP3 | 50  |
      
       @regression
  Scenario: Statement includes account details
    Then statement includes "Name: Bob Smith"
    * statement includes "Account: 12345678"