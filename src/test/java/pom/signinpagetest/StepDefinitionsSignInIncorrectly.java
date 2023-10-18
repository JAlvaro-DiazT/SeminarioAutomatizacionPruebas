package pom.signinpagetest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.PicoSignInRegister;
import record.LoginDataRecord;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitionsSignInIncorrectly {
    PicoSignInRegister picoSignInRegister;

    public StepDefinitionsSignInIncorrectly(PicoSignInRegister picoSignInRegister) {

        this.picoSignInRegister = picoSignInRegister;
    }

    @When("I entered incorrect user data")
    public void i_entered_incorrect_user_data() {
        // Crear una instancia del DTO con los datos del usuario
        ////picoSignInRegister.signInPage.signIn(userData.getUsername(), userData.getPassword());

        String user = "prueba erronea";
        String key = "123qw";
        LoginDataRecord loginDataRecord = new LoginDataRecord(user, key);
        picoSignInRegister.signInPage.signIn(loginDataRecord.user(), loginDataRecord.key());
    }

    @Then("Validate if the Exit button is not found")
    public void validate_if_the_exit_button_is_not_found() {
        assertTrue(picoSignInRegister.signInPage.isDisplayed(picoSignInRegister.signInPage.getEnterUserNameLocator()));
    }

    @And("Validate if dropdown menu is not found")
    public void validate_if_dropdown_menu_is_not_found(){
        assertTrue(picoSignInRegister.signInPage.isDisplayed(picoSignInRegister.signInPage.getEnterKeyLocator()));
        picoSignInRegister.baseTest.tearDown();
    }
}