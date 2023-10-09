Feature: Configure SMS

  Scenario: SMS-Builder :: Configurar SMS
    Given I am on the SMS page
    And I enter user data correctly
    And Redirect to the "Configure SMS" page
    When Complete the requested information
    And click the OK button
    Then click on the "Objetivo" link
    And click on the "2" link
