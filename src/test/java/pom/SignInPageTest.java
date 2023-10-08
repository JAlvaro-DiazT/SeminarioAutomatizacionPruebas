package pom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SignInPageTest extends BaseTest {

    SignInPage signInPage;

    @BeforeEach
    void setUp() {
        setUpDriverConnetion();
        signInPage = new SignInPage(getDriver());
        //signInPage.visit("http://189.50.209.188");
    }

    @Test
    public void iniciarSesionTestCorrectamente() throws InterruptedException{
        String user = "alvaro";
        String key = "diaz";
        signInPage.signIn(user, key);

        //metodo desde el page con un boolean
    }

    @Test
    public void iniciarSesionTestError() throws InterruptedException{
        String user = "error prueba";
        String key = "error123";
        signInPage.signIn(user, key);
    }
}