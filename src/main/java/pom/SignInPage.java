package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.fail;
public class SignInPage extends Base{

    By enterUserNameLocator = By.id("nombreUsuario");
    By enterKeyLocator = By.id("clave");

    By registerEnterLocator = By.id("j_idt74");

    By registerGoOut = By.xpath("//span[@class='ui-button-text ui-c' and text()='Salir']");

    By registerMenu = By.xpath("//span[@class='ui-button-text ui-c' and text()='ui-button']");
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void signIn(String user, String key)throws InterruptedException {
        type(user, enterUserNameLocator);
        type(key, enterKeyLocator);
        click(registerEnterLocator);


    }

    public boolean isHomePageDisplayed(){
        return true;
    }
}
