package pom.goalsmstest;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pom.GoalPage;
import pom.Hook;
import pom.PicoMain;
import pom.RegisterPage;
import record.GoalDataRecord;

public class StepDefinitionsCodeIsEmpty {
    Faker faker = new Faker();
    PicoMain picoMain;
    WebDriver driver = Hook.getDriver();
    public StepDefinitionsCodeIsEmpty(PicoMain picoMain) {

        this.picoMain = picoMain;
        picoMain.goalPage = new GoalPage(driver);
        picoMain.registerPage = new RegisterPage(driver);

    }

    @When("The user enters the code empty")
    public void theUserEntersTheCodeEmpty() {
        String code = "";
        String description = faker.lorem().sentence(10);
        GoalDataRecord goalData = new GoalDataRecord(code, description);

        picoMain.goalPage.registerGoal(goalData.code(), goalData.description());
    }
}
