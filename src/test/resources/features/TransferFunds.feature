Feature: Transfer funds between different users

  @Run @TransferFunds
  Scenario: Transfer funds between different users
    Given Users have positive bill
    When User is willing to perform Person To Person transfer 'amount' to another User
      | amount | 50 |
    And Success message is displayed
    Then The funds were debited in the amount in which they were sent
    And The outgoing Person To Person transfer operation appears on the client's statement
    And The user's account has increased by the amount of money that was sent
    And The incoming Person To Person transfer operation appears on another client's statement