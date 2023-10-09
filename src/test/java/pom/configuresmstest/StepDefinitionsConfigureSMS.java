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

    @And("click the OK button")
    public void clickTheOKButton() {
        configureSMSPage.sumbit();
    }

    @Then("click on the \"Objetivo\" link")
    public void clickOnTheLink() {
        By titleTwoLocater = By.xpath("//span[@class='ui-steps-title' and text()='Objetivo']");
        configureSMSPage.click(titleTwoLocater);
    }

    @And("click on the \"2\" link")
    public void clickOnTheLink(String arg0) {
        By numberTwoLocater = By.xpath("//span[@class='ui-steps-number' and text()='2']");
        configureSMSPage.click(numberTwoLocater);
    }
}