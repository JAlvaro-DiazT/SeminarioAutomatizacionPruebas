package pom;

import record.LoginDataRecord;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class StepDPreconditionHomePageSMS {
    private PicoHomePageSMS picoHomePageSMS;
    public StepDPreconditionHomePageSMS(PicoHomePageSMS picoHomePageSMS) {

        this.picoHomePageSMS = picoHomePageSMS;
    }

    @Given("I am connection on the SMS page")
    public void iAmConnectionOnTheSMSPage() {
        picoHomePageSMS.baseTest = new BaseTest();
        picoHomePageSMS.baseTest.setUpDriverConnetion();
    }

    @And("I enter user data correctly")
    public void i_enter_user_data_correctly() {
        picoHomePageSMS.signInPage = new SignInPage(picoHomePageSMS.baseTest.getDriver());
        String user = "alvaro";
        String key = "diaz";
        LoginDataRecord loginDataRecord = new LoginDataRecord(user, key);
        picoHomePageSMS.signInPage.signIn(loginDataRecord.user(), loginDataRecord.key());
    }

    @And("Redirect to the {string} page {int}")
    public void redirectToThePage(String arg0, int arg1) {
        System.out.println(arg0);
        picoHomePageSMS.signInPage.goFirstPage();
        picoHomePageSMS.signInPage.redirectPage(arg1);

    }
}
