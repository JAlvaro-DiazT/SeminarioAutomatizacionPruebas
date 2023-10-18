package pom.goalsmstest;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.GoalPage;
import pom.PicoHomePageSMS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitionsUpdateConfirm {
    Faker faker = new Faker();
    PicoHomePageSMS picoHomePageSMS;

    public StepDefinitionsUpdateConfirm(PicoHomePageSMS picoHomePageSMS) {

        this.picoHomePageSMS = picoHomePageSMS;
        picoHomePageSMS.goalPage = new GoalPage(picoHomePageSMS.baseTest.getDriver());
    }

    @When("Complete the requested information para actualizar y confirmar")
    public void completeTheRequestedInformation() {

        String codigoObjetivo= "New2";
        String nuevoCod = "11";
        String nuevaDesc = "Description";
        picoHomePageSMS.goalPage.actualizarObjetivo(codigoObjetivo, nuevoCod, nuevaDesc);

/*
        String code = faker.lorem().sentence(3);;
        String description = faker.lorem().sentence(10);

        GoalDataRecord goalData = new GoalDataRecord(code, description);
        picoHomePageSMS.goalPage.registerGoal(goalData.code(), goalData.description());

        picoHomePageSMS.goalPage.registerGoal(goalData.code(), goalData.description());

 */

    }

    @Then("I see the message emergent de actualizar confirmado")
    public void i_see_the_message_emergent_de_actualizar_confirmado() {
        //String message = picoHomePageSMS.goalPage.receivePopupMessage();
        //assertEquals(  "Error Registro ya existente", message);
        String codigoObjetivo= "11";
        String message = picoHomePageSMS.goalPage.receivePopupMessage();
        assertEquals(  "Operación completada", message);
        assertTrue(picoHomePageSMS.goalPage.buscarObjetivo(codigoObjetivo));

        //tbody, tr, td comparacion del valor ingresado si este en la tabla (code)
        //picoHomePageSMS.baseTest.tearDown();
    }
}
