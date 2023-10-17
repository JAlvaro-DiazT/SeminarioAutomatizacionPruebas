package pom.configuresmstest;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.ConfigureSMSPage;
import pom.PicoHomePageSMS;
import record.SMSConfigurationDataRecord;

import static org.junit.Assert.assertEquals;

public class StepDefinitionsConfigureSMS {

    Faker faker = new Faker();
    PicoHomePageSMS picoHomePageSMS;

    public StepDefinitionsConfigureSMS(PicoHomePageSMS picoHomePageSMS) {

        this.picoHomePageSMS = picoHomePageSMS;
        picoHomePageSMS.configureSMSPage = new ConfigureSMSPage(picoHomePageSMS.baseTest.getDriver());
    }

    @When("Complete the requested information")
    public void completeTheRequestedInformation() {

        String name = faker.lorem().sentence(10);
        String description = faker.lorem().sentence(30);
        SMSConfigurationDataRecord configData = new SMSConfigurationDataRecord(name, description);

        picoHomePageSMS.configureSMSPage.configureSMS(configData.name(), configData.description());
    }

    @Then("I see the title of the next page")
    public void i_see_the_title_of_the_next_page() {
        String message = picoHomePageSMS.configureSMSPage.getTitleApp();
        System.out.println(message);
        assertEquals(  ":: SMS - Builder :: Objetivo ::", message);
        picoHomePageSMS.baseTest.tearDown();
    }
}