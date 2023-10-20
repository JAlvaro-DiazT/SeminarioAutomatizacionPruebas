package pom.goalsmstest;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pom.GoalPage;
import pom.Hook;
import pom.PicoMain;
import pom.RegisterPage;
import record.GoalDataRecord;

public class StepDefinitionsCodeIsDuplicate {
    Faker faker = new Faker();
    PicoMain picoMain;
    WebDriver driver = Hook.getDriver();
    public StepDefinitionsCodeIsDuplicate(PicoMain picoMain) {

        this.picoMain = picoMain;
        picoMain.goalPage = new GoalPage(driver);
        picoMain.registerPage = new RegisterPage(driver);

    }

    @When("The user enters the code duplicate")
    public void theUserEntersTheCodeDuplicate() {
        String code = picoMain.goalPage.getRandomRow();
        String description = faker.lorem().sentence(10);

        GoalDataRecord goalData = new GoalDataRecord(code, description);
        picoMain.goalPage.registerGoal(goalData.code(), goalData.description());
    }
}
