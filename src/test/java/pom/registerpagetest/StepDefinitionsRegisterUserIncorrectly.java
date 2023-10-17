package pom.registerpagetest;

import record.RegisterUserDataRecord;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.PicoSignInRegister;

import static org.junit.Assert.assertEquals;

public class StepDefinitionsRegisterUserIncorrectly {

    PicoSignInRegister picoSignInRegister;

    public StepDefinitionsRegisterUserIncorrectly(PicoSignInRegister picoSignInRegister) {

        this.picoSignInRegister = picoSignInRegister;
    }
    @When("I fill in the data of the user that already exists")
    public void i_fill_in_the_data_of_the_user_that_already_exists() {
        String name = "alvaro diaz";
        String username = "alvaro";
        String password = "diaz";

        // Crear una instancia del record con los datos del usuario
        RegisterUserDataRecord registerUserDataRecord = new RegisterUserDataRecord(name, username, password);

        // Llamar al método de registro con los datos del record
        picoSignInRegister.registerPage.registerUser(
                registerUserDataRecord.name(),
                registerUserDataRecord.username(),
                registerUserDataRecord.password(),
                registerUserDataRecord.password()
        );
    }

    @Then("Validate if the \"Existing registration\" pop-up message appears")
    public void validate_if_the_pop_up_message_does_appear() {
        String message = picoSignInRegister.registerPage.receivePopupMessage();
        assertEquals(  "Existing registration", message);
        picoSignInRegister.baseTest.tearDown();
    }
}
