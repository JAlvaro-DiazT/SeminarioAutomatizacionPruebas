package pom.registerpagetest;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.BaseTest;
import pom.RegisterPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitionsRegisterUserIncorrectly extends BaseTest {

    RegisterPage registerPage;
    Faker faker = new Faker();
    @Given("I am on the SMS page to register a user that already exists")
    public void i_am_on_the_sms_page_to_register_a_user_that_already_exists() {
        setUpDriverConnetion();
        registerPage = new RegisterPage(getDriver());
        faker = new Faker();
    }

    @When("I fill in the data of the user that already exists")
    public void i_fill_in_the_data_of_the_user_that_already_exists() throws InterruptedException {

        String name = "alvaro diaz";
        String username = "alvaro";
        String key = "diaz";
        registerPage.registerUser(name, username, key, key);
    }

    @Then("Validate if the \"Existing registration\" pop-up message appears")
    public void validate_if_the_pop_up_message_does_appear() {
        Boolean displayed;
        displayed = registerPage.isDisplayed(registerPage.getMessageExistingRegistration());

        assertTrue(displayed, "El usuario ya existe");
    }
}
