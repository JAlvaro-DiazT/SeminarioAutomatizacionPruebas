package pom.SignInPageTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.BaseTest;
import pom.SignInPage;
import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitionsSignInSuccessfully extends BaseTest {

    SignInPage signInPage;
    @Given("I am on the SMS page to log in correctly")
    public void i_am_on_the_sms_page() {
        setUpDriverConnetion();
        signInPage = new SignInPage(getDriver());
    }

    @When("I enter the correct user data")
    public void i_enter_the_correct_user_data() {

        String user = "alvaro";
        String key = "diaz";
        signInPage.signIn(user, key);
    }

    @Then("Validate if the Exit button is found")
    public void validate_if_the_exit_button_is_found() {
        assertTrue(signInPage.isDisplayed(signInPage.getRegisterGoOut()));
    }

    @And("Validate if dropdown menu is found")
    public void validate_if_dropdown_menu_is_found() {
        assertTrue(signInPage.isDisplayed(signInPage.getRegisterMenu()));
    }
}