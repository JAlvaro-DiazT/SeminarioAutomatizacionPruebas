package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends Base {

    By registerButtonLocator = By.id("j_idt76");
    //  By registerNameLocator =  By.name("registro:nombre");
    By registerNameLocator =  By.id("registro:nombre");
    By registerUserNameLocator = By.id("registro:nombreUsuario");
    By registerKeyLocator = By.id("registro:clave");
    By registerRepeatKeyLocator = By.id("registro:verificacionClave");
    By registerButtonAcceptLocator = By.id("registro:j_idt88");

    //By messageExistingRegistration = By.xpath("//span[@class='ui-growl-title' and text()='Existing registration']");
    //By messageOperationCompleted = By.xpath("//span[@class='ui-growl-title' and text()='Operación completada']");
    By messageRegister = By.xpath("//div[@class='ui-growl-message']/span[@class='ui-growl-title']");
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerUser(String name, String username, String key, String keyVerification) {
        click(registerButtonLocator);
        type(name, registerNameLocator);
        type(username,registerUserNameLocator);
        type(key, registerKeyLocator);
        type(keyVerification, registerRepeatKeyLocator);
        click(registerButtonAcceptLocator);

    }
    public String receivePopupMessage(){
        return getText(messageRegister);
    }
}