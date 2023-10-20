Feature: Goal SMS
  As a user
  I want to be able to log in and be on the second page.
  To create and manipulate Goal records in the table

  Scenario: SMS-Builder :: Goal SMS record goal in the table

    Given The user is on the login page
    And The user enters their username "alvaro" and password "diaz"
    And The user is redirected to page 2
    When The user enters the code and description
    Then The user should see the code in the goal table
    And The user should then see the message "Operación completada"

  Scenario: SMS-Builder :: Goal SMS Code is empty

    Given The user is on the login page
    And The user enters their username "alvaro" and password "diaz"
    And The user is redirected to page 2
    When The user enters the code empty
    Then The user should then see the message "formulario:j_idt83: Error de validación: se necesita un valor."

  Scenario: SMS-Builder :: Goal SMS Code is duplicate

    Given The user is on the login page
    And The user enters their username "alvaro" and password "diaz"
    And The user is redirected to page 2
    When The user enters the code duplicate
    Then The user should then see the message "Error Registro ya existente"

  Scenario: SMS-Builder :: Goal SMS Update code but cancel the action.

    Given The user is on the login page
    And The user enters their username "alvaro" and password "diaz"
    And The user is redirected to page 2
    When The user enters code to update new data
    And The user cancels the action of updating the fields
    Then The user should see the unchanged code in the goals table
    And The user should then see the message "Operación cancelada"

  Scenario: SMS-Builder :: Goal SMS Update code and confirm

    Given The user is on the login page
    And The user enters their username "alvaro" and password "diaz"
    And The user is redirected to page 2
    When The user enters code to update new data
    And The user confirm the action of updating the fields
    Then The user should see the changed code in the goals table
    And The user should then see the message "Operación completada"

  Scenario: SMS-Builder :: Goal SMS Delete code but cancel the action.

    Given The user is on the login page
    And The user enters their username "alvaro" and password "diaz"
    And The user is redirected to page 2
    When The user some code to delete from the table
    And The user cancels the action of deleting the fields
    #Then The user should see the code that was not removed from the goals table
    Then The user should be on the following page seeing the title ":: SMS - Builder :: Objetivo ::"

  Scenario: SMS-Builder :: Goal SMS Delete code and confirm

    Given The user is on the login page
    And The user enters their username "alvaro" and password "diaz"
    And The user is redirected to page 2
    When The user some code to delete from the table
    And The user confirm the action of deleting the fields
    Then The user sees what code was removed from the goals table
    And The user should then see the message "Operación completada"