package pom;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {
    private WebDriver driver;
    private GoogleSearch googleSearch;

    @Given("^I am on the Google search page$")
    public void i_am_on_the_Google_search_page() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();

        // Setup WebDriver
        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application");
        //driver = new ChromeDriver();
        googleSearch = new GoogleSearch(driver);
        //driver.get("https://www.google.com/");
    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String query) {
        googleSearch.search(query);
    }

    @Then("^I should see search results$")
    public void i_should_see_search_results() {
        assertTrue(driver.getTitle().contains("Cucumber with Selenium"));
        //driver.quit();
    }
}
