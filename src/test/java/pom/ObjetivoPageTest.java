package pom;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjetivoPageTest extends BaseTest {

    SignInPage signInPage;
    ObjetivoPage objetivoPage;
    Faker faker = new Faker();
    @BeforeEach
    public void setUp() {
        setUpDriverConnetion();

        signInPage = new SignInPage(getDriver());
        String user = "alvaro";
        String key = "diaz";
        signInPage.signIn(user, key);

        objetivoPage = new ObjetivoPage(getDriver());
        objetivoPage.goFirstPage();
        objetivoPage.redirectPage(2);

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void existingTargetRecord() {
        String code = "12";
        String description = faker.lorem().sentence(10);

        objetivoPage.registerGoal(code, description);

        Boolean displayed;
        displayed = objetivoPage.isDisplayed(objetivoPage.getMessageErrorRegister());
        System.out.println(displayed);
        assertTrue(displayed, "El codigo ya existe");
    }

    @Test
    public void registerGoalCompleted() {
        String code = faker.lorem().sentence(3);
        String description = faker.lorem().sentence(10);

        objetivoPage.registerGoal(code, description);

        Boolean displayed;
        displayed = objetivoPage.isDisplayed(objetivoPage.getMessageOperationCompleted());
        System.out.println(displayed);
        assertTrue(displayed, "Objetivo creado");
    }

    @Test
    public void codeIsEmpty() {
        //String code = faker.lorem().sentence(3);
        String description = faker.lorem().sentence(10);

        objetivoPage.registerGoal("", description);

        Boolean displayed;
        displayed = objetivoPage.isDisplayed(objetivoPage.getMessageErrorValue());
        System.out.println(displayed);
        assertTrue(displayed, "El campo codigo esta vacio");
    }
}