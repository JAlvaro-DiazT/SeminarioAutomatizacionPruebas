package pom.configuresmstest;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pom.ConfigureSMSPage;
import pom.Hook;
import pom.PicoMain;
import record.SMSConfigurationDataRecord;

import static org.junit.Assert.assertEquals;

public class StepDefinitionsConfigureSMS {

    Faker faker = new Faker();

    private PicoMain picoMain;
    WebDriver driver = Hook.getDriver();

    public StepDefinitionsConfigureSMS(PicoMain picoMain) {

        this.picoMain = picoMain;
        picoMain.configureSMSPage = new ConfigureSMSPage(driver);
    }

    @When("The user enters the name and description")
    public void theUserEntersTheNameAndDescription() {

        String name = faker.lorem().sentence(10);
        String description = faker.lorem().sentence(30);
        SMSConfigurationDataRecord configData = new SMSConfigurationDataRecord(name, description);

        picoMain.configureSMSPage.configureSMS(configData.name(), configData.description());
    }

    @Then("The user should be on the following page seeing the title {string}")
    public void theUserShouldBeOnTheFollowingPageSeeingTheTitle(String title) {
        String message = picoMain.configureSMSPage.getTitleApp();
        System.out.println(message);
        assertEquals(  title, message);
        //picoSignInRegister.baseTest.tearDown();
    }
}