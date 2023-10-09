Feature: Register User

  Scenario: Register a new user successfully
    Given I am on the SMS page to register a new user
    When I fill in the user data correctly
    Then Validate if the "Existing registration" pop-up message does not appear


  Scenario: Register a user that already exists
    Given I am on the SMS page to register a user that already exists
    When I fill in the data of the user that already exists
    Then Validate if the "Existing registration" pop-up message appears