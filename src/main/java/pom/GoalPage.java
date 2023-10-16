package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoalPage extends Base{

    By goalNumberLocator = By.xpath("//span[@class='ui-steps-number' and text()='2']");
    By goalCodigoLocator = By.xpath("//div[@class='ui-panelgrid-cell ui-g-12 ui-md-6']/input");
    By goalDescriptionLocator = By.xpath("//div[@class='ui-panelgrid-cell ui-g-12 ui-md-6']/textarea");

    By goalButtonLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Aceptar']");

    //By messageErrorRegister = By.xpath("//span[@class='ui-growl-title' and text()='Error Registro ya existente']");
    //By messageOperationCompleted = By.xpath("//span[@class='ui-growl-title' and text()='Operación completada']");
    //By messageErrorValue = By.xpath("//span[@class='ui-growl-title' and text()='formulario:j_idt173: Error de validación: se necesita un valor.']");
    By messageGoal = By.xpath("//div[@class='ui-growl-message']/span[@class='ui-growl-title']");
    By titleApp = By.xpath("//div[@id='tituloApp']/h1");

    public GoalPage(WebDriver driver) {
        super(driver);
    }

    public void registerGoal(String code, String description){
        type(code, goalCodigoLocator);
        type(description, goalDescriptionLocator);
        click(goalButtonLocator);
        WebDriverWait ewait = getEwait();
        ewait.until(ExpectedConditions.visibilityOfElementLocated(messageGoal));
    }

    public String getTitleApp(){
        return getText(titleApp);
    }

    public String receivePopupMessage(){
        return getText(messageGoal);
    }
}