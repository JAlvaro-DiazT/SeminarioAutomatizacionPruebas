package pom.registerpagetest;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.BaseTest;
import pom.RegisterPage;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitionsRegisterUserCorrectly extends BaseTest {

    RegisterPage registerPage;
    Faker faker = new Faker();
    @Given("I am on the SMS page to register a new user")
    public void i_am_on_the_sms_page_to_register_a_new_user() {
        setUpDriverConnetion();
        registerPage = new RegisterPage(getDriver());
        faker = new Faker();
    }

    @When("I fill in the user data correctly")
    public void i_fill_in_the_user_data_correctly() throws InterruptedException {

        String name = faker.name().firstName();
        String username = faker.name().username();
        String key = faker.internet().password();
        registerPage.registerUser(name, username, key, key);

    }

    @Then("Validate if the \"Existing registration\" pop-up message does not appear")
    public void validate_if_the_pop_up_message_does_not_appear() {
        String message = registerPage.receivePopupMessage();
        assertEquals(  "Operación completada", message);
    }


}
