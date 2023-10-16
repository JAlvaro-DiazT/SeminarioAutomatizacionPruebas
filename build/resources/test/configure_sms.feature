Feature: Configure SMS

  Scenario: SMS-Builder :: Configurar SMS
    Given I am on the SMS page
    And I enter user data correctly
    And Redirect to the "Configure SMS" page
    When Complete the requested information
    Then I see the title of the next page

