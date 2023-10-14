package pom;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoalPageTest extends BaseTest {

    SignInPage signInPage;
    GoalPage goalPage;
    Faker faker = new Faker();
    @BeforeEach
    public void setUp() throws InterruptedException {
        setUpDriverConnetion();

        signInPage = new SignInPage(getDriver());
        String user = "alvaro";
        String key = "diaz";
        signInPage.signIn(user, key);

        goalPage = new GoalPage(getDriver());
        goalPage.goFirstPage();
        goalPage.redirectPage(2);

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void existingTargetRecord() {
        String code = "12";
        String description = faker.lorem().sentence(10);

        goalPage.registerGoal(code, description);

        Boolean displayed;
        displayed = goalPage.isDisplayed(goalPage.getMessageErrorRegister());
        System.out.println(displayed);
        assertTrue(displayed, "El codigo ya existe");
    }

    @Test
    public void registerGoalCompleted() {
        String code = faker.lorem().sentence(3);
        String description = faker.lorem().sentence(10);

        goalPage.registerGoal(code, description);

        Boolean displayed;
        displayed = goalPage.isDisplayed(goalPage.getMessageOperationCompleted());
        System.out.println(displayed);
        assertTrue(displayed, "Objetivo creado");
    }

    @Test
    public void codeIsEmpty() {
        //String code = faker.lorem().sentence(3);
        String description = faker.lorem().sentence(10);

        goalPage.registerGoal("", description);

        Boolean displayed;
        displayed = goalPage.isDisplayed(goalPage.getMessageErrorValue());
        System.out.println(displayed);
        assertTrue(displayed, "El campo codigo esta vacio");
    }
}
