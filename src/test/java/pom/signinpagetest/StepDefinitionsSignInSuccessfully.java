package pom.signinpagetest;

import record.LoginDataRecord;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.PicoSignInRegister;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitionsSignInSuccessfully{

    PicoSignInRegister picoSignInRegister;

    public StepDefinitionsSignInSuccessfully(PicoSignInRegister picoSignInRegister) {

        this.picoSignInRegister = picoSignInRegister;
    }

    @When("I enter the correct user data")
    public void i_enter_the_correct_user_data() {
        // Crear una instancia del DTO con los datos del usuario
        //LoginDataDTO userData = new LoginDataDTO("alvaro", "diaz");
        //picoSignInRegister.signInPage.signIn(userData.getUsername(), userData.getPassword());

        String user = "alvaro";
        String key = "diaz";
        LoginDataRecord loginDataRecord = new LoginDataRecord(user, key);
        picoSignInRegister.signInPage.signIn(loginDataRecord.user(), loginDataRecord.key());
    }

    @Then("Validate if the Exit button is found")
    public void validate_if_the_exit_button_is_found() {
        assertTrue(picoSignInRegister.signInPage.isDisplayed(picoSignInRegister.signInPage.getRegisterGoOut()));
    }

    @And("Validate if dropdown menu is found")
    public void validate_if_dropdown_menu_is_found() {
        assertTrue(picoSignInRegister.signInPage.isDisplayed(picoSignInRegister.signInPage.getRegisterMenu()));
        picoSignInRegister.baseTest.tearDown();
    }
}