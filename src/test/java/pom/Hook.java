package pom;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hook {

    private static WebDriver driver;

    @Before
    public void setUp(Scenario scenario)
    {
        driver = chromeDriverConnection();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://localhost:8080");
        driver.manage().window().maximize();
        takeScreenshotBeforeStep(scenario);
    }

    private WebDriver chromeDriverConnection() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    @After
    public void tearDown(Scenario scenario){
        takeScreenshotBeforeStep(scenario);
        driver.quit();
    }

    @BeforeStep
    public void takeScreenshotBeforeStep(Scenario scenario)
    {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png", "My screenshot step");
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
