package pom.registerpagetest;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pom.Hook;
import pom.PicoMain;
import pom.RegisterPage;
import record.RegisterUserDataRecord;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class StepDefinitionsRegister {

    Faker faker = new Faker();
    PicoMain picoMain;
    WebDriver driver = Hook.getDriver();
    public StepDefinitionsRegister(PicoMain picoMain) {

        this.picoMain = picoMain;
    }
    @Given("The user is on the registration page")
    public void theUserIsOnTheRegistrationPage() throws IOException {
       // picoMain.baseTest = new BaseTest();
       // picoMain.baseTest.setUpDriverConnetion();
        picoMain.registerPage = new RegisterPage(driver);
        picoMain.registerPage.goRegistrationPage();
    }


    @When("The user enters his full name {string}, username {string} and password {string}")
    public void theUserEntersHisFullNameUsernameAndPassword(String name1, String username1, String password1) {
        RegisterUserDataRecord registerUserDataRecord;
        String name = "";
        String username = "";
        String password = "";

        if (name1.isEmpty() && username1.isEmpty() && password1.isEmpty()) {
            name = faker.name().firstName();
            username = faker.name().username();
            password = faker.internet().password();

        }else{
            name = name1;
            username = username1;
            password = password1;
        }

        registerUserDataRecord = new RegisterUserDataRecord(name, username, password);
        // Llamar al método de registro con los datos del record
        picoMain.registerPage.registerUser(
                registerUserDataRecord.name(),
                registerUserDataRecord.username(),
                registerUserDataRecord.password(),
                registerUserDataRecord.password()
        );
    }

    @Then("The user should then see the message {string}")
    public void theUserShouldThenSeeTheMessage(String parameterMessage) {
        String message = picoMain.registerPage.receivePopupMessage();
        assertEquals(  parameterMessage, message);
        //picoSignInRegister.baseTest.tearDown();
    }
}
