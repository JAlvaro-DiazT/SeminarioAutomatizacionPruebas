package pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
/*
Contiene los elementos principales de un modelo POM
Conexion, entrada de texto, obtener algun elemento, enviar texto
 */
public class Base {

    private WebDriver driver;
    private WebDriverWait ewait;

    public WebDriverWait getEwait(){
        return ewait;
    }
    public Base(WebDriver driver){
        this.driver = driver;
        ewait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement finElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        ewait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public void visit(String url){
        driver.get(url);
    }
}
