package pom.goalsmstest;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pom.GoalPage;
import pom.Hook;
import pom.PicoMain;
import pom.RegisterPage;
import record.GoalDataRecord;

import static org.junit.Assert.assertTrue;

public class StepDefinitionsRegisterGoal {
    Faker faker = new Faker();
    String code;
    PicoMain picoMain;

    WebDriver driver = Hook.getDriver();
    public StepDefinitionsRegisterGoal(PicoMain picoMain) {

        this.picoMain = picoMain;
        picoMain.goalPage = new GoalPage(driver);
        picoMain.registerPage = new RegisterPage(driver);

    }

    @When("The user enters the code and description")
    public void theUserEntersTheCodeAndDescription() {

        code = faker.lorem().sentence(3);
        String description = faker.lorem().sentence(10);

        GoalDataRecord goalData = new GoalDataRecord(code, description);

        picoMain.goalPage.registerGoal(goalData.code(), goalData.description());
    }
    @Then("The user should see the code in the goal table")
    public void theUserShouldSeeTheCodeInTheGoalTable() {

        assertTrue(picoMain.goalPage.validateGoalSearch(code));
    }
}
