package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class SignInPage extends Base{

    By enterUserNameLocator = By.id("nombreUsuario");
    By enterKeyLocator = By.id("clave");

    By registerEnterLocator = By.id("j_idt74");

    By registerGoOut = By.xpath("//span[@class='ui-button-text ui-c' and text()='Salir']");

    By registerMenu = By.xpath("//span[@class='ui-button-text ui-c' and text()='ui-button']");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void signIn(String user, String key) {

        type(user, enterUserNameLocator);
        type(key, enterKeyLocator);
        click(registerEnterLocator);
    }

    public By getRegisterGoOut() {
        return registerGoOut;
    }

    public By getRegisterMenu() {
        return registerMenu;
    }

    public By getEnterUserNameLocator() {
        return enterUserNameLocator;
    }

    public By getEnterKeyLocator() {
        return enterKeyLocator;
    }

    public boolean isHomePageDisplayed(){
        return true;
    }
}
