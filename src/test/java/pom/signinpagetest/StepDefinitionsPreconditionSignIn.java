package pom.signinpagetest;

import io.cucumber.java.en.Given;
import pom.BaseTest;
import pom.PicoSignInRegister;
import pom.SignInPage;

public class StepDefinitionsPreconditionSignIn {
    private PicoSignInRegister picoSignInRegister;

    public StepDefinitionsPreconditionSignIn(PicoSignInRegister picoSignInRegister) {

        this.picoSignInRegister = picoSignInRegister;

    }

    @Given("I am on the SMS page to sign in")
    public void iAmOnTheSMSPageToSignIn() {
        picoSignInRegister.baseTest = new BaseTest();
        picoSignInRegister.baseTest.setUpDriverConnetion();
        picoSignInRegister.signInPage = new SignInPage(picoSignInRegister.baseTest.getDriver());
    }
}
