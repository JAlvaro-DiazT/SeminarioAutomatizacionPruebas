package pom.goalsmstest;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.GoalPage;
import pom.PicoHomePageSMS;

import static org.junit.Assert.*;

public class StepDefinitionsDeleteConfirm {
    Faker faker = new Faker();
    PicoHomePageSMS picoHomePageSMS;

    public StepDefinitionsDeleteConfirm(PicoHomePageSMS picoHomePageSMS) {

        this.picoHomePageSMS = picoHomePageSMS;
        picoHomePageSMS.goalPage = new GoalPage(picoHomePageSMS.baseTest.getDriver());
    }

    @When("Complete the requested information para eliminar y confirmar")
    public void completeTheRequestedInformation() {

        String codigoObjetivo= "1";
        picoHomePageSMS.goalPage.eliminarObjetivo(codigoObjetivo);


/*
        String code = faker.lorem().sentence(3);;
        String description = faker.lorem().sentence(10);

        GoalDataRecord goalData = new GoalDataRecord(code, description);
        picoHomePageSMS.goalPage.registerGoal(goalData.code(), goalData.description());

        picoHomePageSMS.goalPage.registerGoal(goalData.code(), goalData.description());

 */

    }

    @Then("I see the message emergent de eliminar confirmado")
    public void i_see_the_message_emergent_de_eliminar_cancelado() {
        //String message = picoHomePageSMS.goalPage.receivePopupMessage();
        //assertEquals(  "Error Registro ya existente", message);
        String codigoObjetivo= "1";
        String message = picoHomePageSMS.goalPage.receivePopupMessage();
        assertEquals(  "Operación completada", message);
        assertFalse(picoHomePageSMS.goalPage.buscarObjetivo(codigoObjetivo));

        //tbody, tr, td comparacion del valor ingresado si este en la tabla (code)
        //picoHomePageSMS.baseTest.tearDown();
    }
}
