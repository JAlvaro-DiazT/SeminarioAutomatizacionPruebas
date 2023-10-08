package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.fail;
public class SignInPage extends Base{

    By enterUserNameLocator = By.id("nombreUsuario");
    By enterKeyLocator = By.id("clave");

    By registerEnterLocator = By.id("j_idt74");

    By registerGoOut = By.id("j_idt374:j_idt375");

    By registerMenu = By.id("j_idt371:j_idt372");
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void signIn(String user, String key)throws InterruptedException {
        type(user, enterUserNameLocator);
        type(key, enterKeyLocator);
        click(registerEnterLocator);

        if (isDisplayed(registerGoOut) && isDisplayed(registerMenu)) {
            System.out.println("Logueo Exitoso");
        }else{
            fail("Credenciales incorrectas");
            System.out.println("Credenciales incorrectas");
        }
    }

    public boolean isHomePageDisplayed(){
        return true;
    }
}
