package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfigureSMSPage extends Base{

    By configureSMSLocator = By.xpath("//span[@class='ui-steps-number' and text()='1']");
    By configureNameProjectLocator = By.name("registro:nombre");
    By configureDescriptionLocator = By.name("registro:descripcion");

    By configureSMSButtonLocator = By.id("registro:j_idt84");
    public ConfigureSMSPage(WebDriver driver) {
        super(driver);
    }

    public void configureSMS(String nameProject, String descriptionProject){
        click(configureSMSLocator);
        type(nameProject,configureNameProjectLocator);
        type(descriptionProject,configureDescriptionLocator);
        click(configureSMSButtonLocator);
    }
}
