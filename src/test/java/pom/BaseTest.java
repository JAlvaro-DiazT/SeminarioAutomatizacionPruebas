package pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {

    private WebDriver driver;




    public WebDriver getDriver(){
        return driver;
    }

    public void setUpDriverConnetion() {
        driver = chromeDriverConnection();
        driver.get("http://localhost:8080");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
    }

    //Conexion a chrome y a la pagina SMS
    public WebDriver chromeDriverConnection(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }


}