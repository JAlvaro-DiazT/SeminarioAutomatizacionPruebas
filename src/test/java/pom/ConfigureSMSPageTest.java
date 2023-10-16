package pom;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ConfigureSMSPageTest extends BaseTest{

    SignInPage signInPage;
    ConfigureSMSPage configureSMSPage;
    Faker faker = new Faker();

    @BeforeEach
    void setUp() throws InterruptedException {
        setUpDriverConnetion();

        signInPage = new SignInPage(getDriver());
        String user = "alvaro";
        String key = "diaz";
        signInPage.signIn(user, key);

        configureSMSPage = new ConfigureSMSPage(getDriver());
        configureSMSPage.goFirstPage();
    }



    @Test
    void configureSMSTest() {
        String name = faker.lorem().sentence(10);
        String description = faker.lorem().sentence(30);

        configureSMSPage.configureSMS(name, description);
        //Thread.sleep(2000);
        String message = configureSMSPage.getTitleApp();
        System.out.println(message);
        assertEquals(  ":: SMS - Builder :: Objetivo ::", message);

    }

    @Test
    void configureSMSTestEmptyField(){
        String name = "";
        String description = "";

        configureSMSPage.configureSMS(name, description);
        //Thread.sleep(2000);
        String message = configureSMSPage.getTitleApp();
        assertEquals(  ":: SMS - Builder :: Objetivo ::", message);
    }
}