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

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public boolean registerUser(String name, String username, String key, String keyVerification) throws InterruptedException{
        click(registerButtonLocator);
        //Thread.sleep(5000);
        type(name, registerNameLocator);
        type(username,registerUserNameLocator);
        type(key, registerKeyLocator);
        type(keyVerification, registerRepeatKeyLocator);
        Thread.sleep(1000);
        click(registerButtonAcceptLocator);

        return true;

    }
}
