package pom.signinpagetest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pom.Hook;
import pom.PicoMain;
import pom.SignInPage;
import record.LoginDataRecord;

public class StepDefinitionsPreconditionSignIn {
    private PicoMain picoMain;
    WebDriver driver = Hook.getDriver();

    public StepDefinitionsPreconditionSignIn(PicoMain picoMain) {

        this.picoMain = picoMain;

    }

    @Given("The user is on the login page")
    public void theUserIsOnTheLoginPage() {
        //picoMain.baseTest = new BaseTest();
        //picoMain.baseTest.setUpDriverConnetion();
        picoMain.signInPage = new SignInPage(driver);

    }

    @When("The user enters their username {string} and password {string}")
    public void theUserEntersTheirUsernameAndPassword(String user, String key) {
        LoginDataRecord loginDataRecord = new LoginDataRecord(user, key);
        picoMain.signInPage.signIn(loginDataRecord.user(), loginDataRecord.key());
    }
}
