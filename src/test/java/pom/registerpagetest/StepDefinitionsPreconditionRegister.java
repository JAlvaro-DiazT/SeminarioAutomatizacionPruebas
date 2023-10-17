package pom.registerpagetest;

import io.cucumber.java.en.Given;
import pom.BaseTest;
import pom.RegisterPage;
import pom.PicoSignInRegister;

public class StepDefinitionsPreconditionRegister {
    private PicoSignInRegister picoSignInRegister;

    public StepDefinitionsPreconditionRegister(PicoSignInRegister picoSignInRegister) {

        this.picoSignInRegister = picoSignInRegister;
    }

    @Given("I am on the SMS page to register")
    public void i_am_on_the_sms_page_to_register() {
        picoSignInRegister.baseTest = new BaseTest();
        picoSignInRegister.baseTest.setUpDriverConnetion();
        picoSignInRegister.registerPage = new RegisterPage(picoSignInRegister.baseTest.getDriver());

    }
}
