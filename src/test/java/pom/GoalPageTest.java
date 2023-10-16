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
    public void existingTargetRecord() throws InterruptedException {
        String code = faker.lorem().sentence(3);;
        String description = faker.lorem().sentence(10);

        goalPage.registerGoal(code, description);

        //Thread.sleep(3000);
        String description2 = faker.lorem().sentence(10);
        goalPage.registerGoal(code, description2);
        // Thread.sleep(3000);
        String message = goalPage.receivePopupMessage();
        assertEquals(  "Error Registro ya existente", message);
    }

    @Test
    public void registerGoalCompleted() {
        String code = faker.lorem().sentence(3);
        String description = faker.lorem().sentence(10);

        goalPage.registerGoal(code, description);
        String message = goalPage.receivePopupMessage();
        assertEquals(  "Operación completada", message);

        //tbody, tr, td comparacion del valor ingresado si este en la tabla (code)

    }

    @Test
    public void codeIsEmpty() {
        //String code = faker.lorem().sentence(3);
        String description = faker.lorem().sentence(10);

        goalPage.registerGoal("", description);
        String message = goalPage.receivePopupMessage();
        assertEquals(  "formulario:j_idt83: Error de validación: se necesita un valor.", message);
    }
}
