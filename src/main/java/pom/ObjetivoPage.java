package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObjetivoPage extends Base{

    By goalNumberLocator = By.xpath("//span[@class='ui-steps-number' and text()='2']");
    By goalCodigoLocator = By.id("formulario:j_idt173");
    By goalDescriptionLocator = By.id("formulario:j_idt175");

    By goalButtonLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Aceptar']");

    By messageErrorRegister = By.xpath("//span[@class='ui-growl-title' and text()='Error Registro ya existente']");
    By messageOperationCompleted = By.xpath("//span[@class='ui-growl-title' and text()='Operación completada']");
    By messageErrorValue = By.xpath("//span[@class='ui-growl-title' and text()='formulario:j_idt173: Error de validación: se necesita un valor.']");

    public ObjetivoPage(WebDriver driver) {
        super(driver);
    }

    public void registerGoal(String code, String description){
        type(code, goalCodigoLocator);
        type(description, goalDescriptionLocator);
        click(goalButtonLocator);
    }

    public By getMessageErrorRegister() {
        return messageErrorRegister;
    }

    public By getMessageOperationCompleted() {
        return messageOperationCompleted;
    }

    public By getMessageErrorValue() {
        return messageErrorValue;
    }
}
