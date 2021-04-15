Feature: Transfer funds between different users

  Scenario: Transfer funds between different users
    Given Following users have positive bill
    When User is willing to perform Person To Person transfer amount to another User
    And Success message is displayed
    Then The funds were debited in the amount in which they were sent
    And The outgoing Person To Person transfer operation appears on the client's statement
    And The user's account has increased by the amount of money that was sent
    And The incoming Person To Person transfer operation appears on another client's statement