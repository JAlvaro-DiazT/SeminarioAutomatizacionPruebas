package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfigureSMSPage extends Base{

    By configureSMSLocator = By.xpath("//span[@class='ui-steps-number' and text()='1']");
    By configureNameProjectLocator = By.id("registro:nombre");
    By configureDescriptionLocator = By.id("registro:descripcion");

    By configureSMSButtonLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Aceptar']");

    By titleApp = By.xpath("//div[@id='tituloApp']/h1");

    public ConfigureSMSPage(WebDriver driver) {
        super(driver);
    }

    public void configureSMS(String nameProject, String descriptionProject){
        click(configureSMSLocator);
        type(nameProject,configureNameProjectLocator);
        type(descriptionProject,configureDescriptionLocator);
        click(configureSMSButtonLocator);

    }

    public String getTitleApp(){
        return getText(titleApp);
    }
}