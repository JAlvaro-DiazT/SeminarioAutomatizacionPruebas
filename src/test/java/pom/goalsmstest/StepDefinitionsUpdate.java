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
import record.GoalDataRecord;

import static org.junit.Assert.assertTrue;

public class StepDefinitionsUpdate {
    Faker faker = new Faker();
;
    String newCode;
    String newDescription;
    String searchCode;
    PicoMain picoMain;
    WebDriver driver = Hook.getDriver();
    public StepDefinitionsUpdate(PicoMain picoMain) {

        this.picoMain = picoMain;
        picoMain.goalPage = new GoalPage(driver);
        picoMain.registerPage = new RegisterPage(driver);

    }

    @When("The user enters code to update new data")
    public void theUserEntersCodeToUpdateNewData() {
        searchCode= picoMain.goalPage.getRandomRow();

        newCode = faker.lorem().sentence(3);
        newDescription = faker.lorem().sentence(10);
    }

    @And("The user cancels the action of updating the fields")
    public void theUserCancelsTheActionOfUpdatingTheFields() {
        GoalDataRecord goalData = new GoalDataRecord(newCode, newDescription);
        picoMain.goalPage.updateCancelGoal(searchCode, goalData.code(), goalData.description());
    }

    @Then("The user should see the unchanged code in the goals table")
    public void theUserShouldSeeTheUnchangedCodeInTheGoalsTable() {
        assertTrue(picoMain.goalPage.validateGoalSearch(searchCode));
    }

    @And("The user confirm the action of updating the fields")
    public void theUserConfirmTheActionOfUpdatingTheFields() {
        GoalDataRecord goalData = new GoalDataRecord(newCode, newDescription);

        picoMain.goalPage.updateConfirmGoal(searchCode, goalData.code(), goalData.description());
    }

    @Then("The user should see the changed code in the goals table")
    public void theUserShouldSeeTheChangedCodeInTheGoalsTable() {
        assertTrue(picoMain.goalPage.validateGoalSearch(newCode));
        System.out.println("Code update:"+ newCode);
    }
}
