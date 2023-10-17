Feature: Goal SMS

  Scenario: SMS-Builder :: Goal SMS Register goal

    Given I am connection on the SMS page
    And I enter user data correctly
    And Redirect to the "ObjetivoSMS" page 2
    When Complete the requested information Goal
    Then I see the message emergent

  Scenario: SMS-Builder :: Goal SMS Code is empty

    Given I am connection on the SMS page
    And I enter user data correctly
    And Redirect to the "ObjetivoSMS" page 2
    When Complete the requested information Goal with Code empty
    Then I see the message emergent code empty

  Scenario: SMS-Builder :: Goal SMS Code is duplicate

    Given I am connection on the SMS page
    And I enter user data correctly
    And Redirect to the "ObjetivoSMS" page 2
    When Complete the requested information Goal with Code duplicate
    Then I see the message emergent code duplicate