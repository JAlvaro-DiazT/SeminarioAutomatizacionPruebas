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

    @AfterEach
    public void tearDown() {
    }

    @Test
    void configureSMSTest() {
        String name = faker.lorem().sentence(10);
        String description = faker.lorem().sentence(30);

        configureSMSPage.configureSMS(name, description);

        configureSMSPage.sumbit();

        By numberTwoLocater = By.xpath("//span[@class='ui-steps-number' and text()='2']");
        By titleTwoLocater = By.xpath("//span[@class='ui-steps-title' and text()='Objetivo']");

        configureSMSPage.click(numberTwoLocater);
        configureSMSPage.click(titleTwoLocater);
    }

    @Test
    void configureSMSTestError() {
        String name = faker.lorem().sentence(10);
        String description = faker.lorem().sentence(30);

        configureSMSPage.configureSMS(name, description);

        configureSMSPage.sumbit();

        //By codigoLocaterObjetivo = By.xpath("//span[@class='ui-outputlabel-label' and text()='C\\u00F3digo: ']");
        //By descripcionLocaterObjetivo = By.xpath("//span[@class='ui-outputlabel-label' and text()='Descripci\\u00F3n:']");

        //System.out.println(configureSMSPage.isDisplayed(codigoLocaterObjetivo));
        //System.out.println(configureSMSPage.isDisplayed(descripcionLocaterObjetivo));

    }
}