package pom;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigureSMSPageTest extends BaseTest{

    SignInPage signInPage;
    ConfigureSMSPage configureSMSPage;
    Faker faker = new Faker();

    @BeforeEach
    void setUp() throws InterruptedException {
        signInPage = new SignInPage(getDriver());
        String user = "alvaro";
        String key = "diaz";
        signInPage.signIn(user, key);

        //

        configureSMSPage = new ConfigureSMSPage(getDriver());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void configureSMSTest() {
        String name = faker.lorem().sentence(10);
        String description = faker.lorem().sentence(30);
        configureSMSPage.configureSMS(name,description);
    }
}