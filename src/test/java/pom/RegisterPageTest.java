package pom;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class RegisterPageTest extends BaseTest {

    RegisterPage registerPage;
    Faker faker = new Faker();

    @BeforeEach
    void setUp() {
        setUpDriverConnetion();
        registerPage = new RegisterPage(getDriver());
    }


    @Test
    public void registerUser() throws InterruptedException {
        String name = faker.name().firstName();
        String username = faker.name().username();
        String key = faker.internet().password();
        registerPage.registerUser(name, username, key, key);

        String message = registerPage.receivePopupMessage();
        assertEquals(  "Operación completada", message);
    }

    @Test
    public void registerUserIncorrect() throws InterruptedException {
        String name = "alvaro diaz";
        String username = "alvaro";
        String key = "diaz";
        registerPage.registerUser(name, username, key, key);

        String message = registerPage.receivePopupMessage();
        assertEquals(  "Existing registration", message);


    }
}