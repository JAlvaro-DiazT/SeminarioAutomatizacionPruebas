package pom.signinpagetest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pom.PicoMain;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitionsSignInIncorrectly {
    PicoMain picoMain;

    public StepDefinitionsSignInIncorrectly(PicoMain picoMain) {

        this.picoMain = picoMain;
    }

    @Then("The user should not see the Logout button")
    public void theUserShouldNotSeeTheLogoutButton() {
        assertTrue(picoMain.signInPage.isDisplayed(picoMain.signInPage.getEnterUserNameLocator()));
    }

    @And("The user should not see the Menu button")
    public void theUserShouldNotSeeTheMenuButton() {
        assertTrue(picoMain.signInPage.isDisplayed(picoMain.signInPage.getEnterKeyLocator()));
        //picoSignInRegister.baseTest.tearDown();
    }
}