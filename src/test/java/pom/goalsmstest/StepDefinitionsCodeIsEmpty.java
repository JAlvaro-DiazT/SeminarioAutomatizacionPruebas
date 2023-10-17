package pom.goalsmstest;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.GoalPage;
import pom.PicoHomePageSMS;
import record.GoalDataRecord;

import static org.junit.Assert.assertEquals;

public class StepDefinitionsCodeIsEmpty {
    Faker faker = new Faker();
    PicoHomePageSMS picoHomePageSMS;

    public StepDefinitionsCodeIsEmpty(PicoHomePageSMS picoHomePageSMS) {

        this.picoHomePageSMS = picoHomePageSMS;
        picoHomePageSMS.goalPage = new GoalPage(picoHomePageSMS.baseTest.getDriver());
    }

    @When("Complete the requested information Goal with Code empty")
    public void completeTheRequestedInformation() {

        String code = "";
        String description = faker.lorem().sentence(10);
        GoalDataRecord goalData = new GoalDataRecord(code, description);

        picoHomePageSMS.goalPage.registerGoal(goalData.code(), goalData.description());

    }

    @Then("I see the message emergent code empty")
    public void i_see_the_title_of_the_next_page() {
        String message = picoHomePageSMS.goalPage.receivePopupMessage();
        assertEquals(  "formulario:j_idt83: Error de validación: se necesita un valor.", message);

        //tbody, tr, td comparacion del valor ingresado si este en la tabla (code)
        //picoHomePageSMS.baseTest.tearDown();
    }
}
