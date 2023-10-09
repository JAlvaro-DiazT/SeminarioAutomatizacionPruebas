Feature: Sign in

  Scenario: Sign in successfully
    Given I am on the SMS page to log in correctly
    When I enter the correct user data
    Then Validate if the Exit button is found
    And Validate if dropdown menu is found

  Scenario: Sign in incorrectly
    Given I am on the SMS page to log in incorrectly
    When I entered incorrect user data
    Then Validate if the Exit button is not found
    And Validate if dropdown menu is not found