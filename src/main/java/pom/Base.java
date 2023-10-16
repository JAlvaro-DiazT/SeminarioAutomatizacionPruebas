package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
/*
Contiene los elementos principales de un modelo POM
Conexion, entrada de texto, obtener algun elemento, enviar texto
 */
public class Base {

    By goForward = By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c pi pi-arrow-circle-right']");
    By goBack = By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c pi pi-arrow-circle-left']");

    By numberOneLocater = By.xpath("//span[@class='ui-steps-number' and text()='1']");
    By titleOneLocater = By.xpath("//span[@class='ui-steps-title' and text()='Configurar SMS']");
    private WebDriver driver;
    private WebDriverWait ewait;

    public WebDriverWait getEwait(){
        return ewait;
    }
    public Base(WebDriver driver){
        this.driver = driver;
        ewait = new WebDriverWait(driver, Duration.ofSeconds(7));
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
        ewait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        ewait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator){
        try{
            //ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            ewait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public void visit(String url){
        driver.get(url);
    }

    //nuevos metodos
    public void goForward(){
        click(goForward);
    }

    public void goBack(){
        click(goBack);
    }

    public void goFirstPage(){
        click(numberOneLocater);
        //click(titleOneLocater);
    }

    public void redirectPage(int page){
        goFirstPage();
        for (int i = 1; i < page ; i++) {
            goForward();
        }
    }
}