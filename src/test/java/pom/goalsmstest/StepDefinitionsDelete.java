package pom.goalsmstest;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pom.GoalPage;
import pom.Hook;
import pom.PicoMain;
import pom.RegisterPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StepDefinitionsDelete {
    Faker faker = new Faker();

    String searchCode;

    PicoMain picoMain;
    WebDriver driver = Hook.getDriver();
    public StepDefinitionsDelete(PicoMain picoMain) {

        this.picoMain = picoMain;
        picoMain.goalPage = new GoalPage(driver);
        picoMain.registerPage = new RegisterPage(driver);

    }

    @When("The user enters the code to delete from the table")
    public void theUserEntersTheCodeToDeleteFromTheTable() {
        searchCode = picoMain.goalPage.getRandomRow();
    }

    @When("The user some code to delete from the table")
    public void theUserSomeCodeToDeleteFromTheTable() {
        searchCode = picoMain.goalPage.getRandomRow();
    }

    @And("The user cancels the action of deleting the fields")
    public void theUserCancelsTheActionOfDeletingTheFields() {
        picoMain.goalPage.deleteCancelGoal(searchCode);
    }
    @Then("The user should see the code that was not removed from the goals table")
    public void theUserShouldSeeTheCodeThatWasNotRemovedFromTheGoalsTable() {
        assertTrue(picoMain.goalPage.validateGoalSearch(searchCode));
        //picoSignInRegister.baseTest.tearDown();
    }
    @And("The user confirm the action of deleting the fields")
    public void theUserConfirmTheActionOfDeletingTheFields() {
        picoMain.goalPage.deleteGoal(searchCode);
    }

    @Then("The user sees what code was removed from the goals table")
    public void theUserSeesWhatCodeWasRemovedFromTheGoalsTable() {
        assertFalse(picoMain.goalPage.validateGoalSearch(searchCode));
    }
}
