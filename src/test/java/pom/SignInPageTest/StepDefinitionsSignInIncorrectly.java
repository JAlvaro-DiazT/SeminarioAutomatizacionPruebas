package pom.SignInPageTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.BaseTest;
import pom.SignInPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitionsSignInIncorrectly extends BaseTest {

    SignInPage signInPage;
    @Given("I am on the SMS page to log in incorrectly")
    public void i_am_on_the_sms_page() {
        setUpDriverConnetion();
        signInPage = new SignInPage(getDriver());
    }

    @When("I entered incorrect user data")
    public void i_entered_incorrect_user_data() {

        String user = "prueba erronea";
        String key = "123qw";
        signInPage.signIn(user, key);
    }

    @Then("Validate if the Exit button is not found")
    public void validate_if_the_exit_button_is_not_found() {
        assertFalse(signInPage.isDisplayed(signInPage.getRegisterGoOut()));
    }

    @And("Validate if dropdown menu is not found")
    public void validate_if_dropdown_menu_is_not_found() {
        assertFalse(signInPage.isDisplayed(signInPage.getRegisterMenu()));
    }
}