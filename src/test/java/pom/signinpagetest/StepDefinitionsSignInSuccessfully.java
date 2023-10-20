package pom.signinpagetest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pom.PicoMain;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitionsSignInSuccessfully{

    PicoMain picoMain;

    public StepDefinitionsSignInSuccessfully(PicoMain picoMain) {

        this.picoMain = picoMain;
    }

    @Then("The user should see the Logout button")
    public void theUserShouldSeeTheLogoutButton() {
        assertTrue(picoMain.signInPage.isDisplayed(picoMain.signInPage.getRegisterGoOut()));
    }

    @And("The user should see the Menu button")
    public void theUserShouldSeeTheMenuButton() {
        assertTrue(picoMain.signInPage.isDisplayed(picoMain.signInPage.getRegisterMenu()));
       // picoSignInRegister.baseTest.tearDown();
    }
}