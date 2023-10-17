package pom;

import io.cucumber.java.AfterStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    private WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }

    //@Before
    public void setUpDriverConnetion() {
        driver = chromeDriverConnection();
        driver.get("http://localhost:8080");
        driver.manage().window().maximize();
    }

    @AfterStep
    public void tearDown()  {
        if (driver != null) {
            driver.quit();
        }
    }

    //Conexion a chrome y a la pagina SMS
    private WebDriver chromeDriverConnection(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        return driver;
    }
}