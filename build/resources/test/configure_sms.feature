Feature: Configure SMS

  Scenario: SMS-Builder :: Configure SMS

    Given I am connection on the SMS page
    And I enter user data correctly
    And Redirect to the "ConfigureSMS" page 1
    When Complete the requested information
    Then I see the title of the next page

