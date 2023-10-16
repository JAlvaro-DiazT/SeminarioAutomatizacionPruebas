package pom.configuresmstest;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pom.BaseTest;
import pom.ConfigureSMSPage;
import pom.SignInPage;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitionsConfigureSMS extends BaseTest {

    SignInPage signInPage;
    ConfigureSMSPage configureSMSPage;
    Faker faker = new Faker();
    @Given("I am on the SMS page")
    public void iAmOnTheSMSPage() {
        setUpDriverConnetion();
    }

    @And("I enter user data correctly")
    public void iEnterUserDataCorrectly() {
        signInPage = new SignInPage(getDriver());
        String user = "alvaro";
        String key = "diaz";
        signInPage.signIn(user, key);
    }
    @And("Redirect to the \"Configure SMS\" page")
    public void redirectToThePage() {
        configureSMSPage = new ConfigureSMSPage(getDriver());
        configureSMSPage.goFirstPage();
    }

    @When("Complete the requested information")
    public void completeTheRequestedInformation() {

        String name = faker.lorem().sentence(10);
        String description = faker.lorem().sentence(30);

        configureSMSPage.configureSMS(name, description);
    }

    @Then("I see the title of the next page")
    public void i_see_the_title_of_the_next_page() {
        String message = configureSMSPage.getTitleApp();
        System.out.println(message);
        assertEquals(  ":: SMS - Builder :: Objetivo ::", message);
    }
}