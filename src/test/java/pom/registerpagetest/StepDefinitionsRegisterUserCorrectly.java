package pom.registerpagetest;

import com.github.javafaker.Faker;
import record.RegisterUserDataRecord;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.PicoSignInRegister;

import static org.junit.Assert.assertEquals;

public class StepDefinitionsRegisterUserCorrectly {

    Faker faker = new Faker();;
    PicoSignInRegister picoSignInRegister;

    public StepDefinitionsRegisterUserCorrectly(PicoSignInRegister picoSignInRegister) {

        this.picoSignInRegister = picoSignInRegister;
    }

    @When("I fill in the user data correctly")
    public void i_fill_in_the_user_data_correctly() {

        // Generar datos aleatorios para el usuario
        String name = faker.name().firstName();
        String username = faker.name().username();
        String password = faker.internet().password();

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

    @Then("Validate if the \"Existing registration\" pop-up message does not appear")
    public void validate_if_the_pop_up_message_does_not_appear() {
        String message = picoSignInRegister.registerPage.receivePopupMessage();
        assertEquals(  "Operación completada", message);
        picoSignInRegister.baseTest.tearDown();
    }


}
