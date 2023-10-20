package pom;

import io.cucumber.java.en.And;

public class StepDPreconditionHomePageSMS {

    private PicoMain picoMain;
    public StepDPreconditionHomePageSMS(PicoMain picoMain) {

        this.picoMain = picoMain;

    }

    @And("The user is redirected to page {int}")
    public void theUserIsRedirectedToPage(int page) {
        picoMain.signInPage.goFirstPage();
        picoMain.signInPage.redirectPage(page);
    }

}
