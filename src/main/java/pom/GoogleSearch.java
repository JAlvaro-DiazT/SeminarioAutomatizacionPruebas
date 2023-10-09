package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearch {
    private WebDriver driver;

    public GoogleSearch(WebDriver driver) {
        this.driver = driver;
    }

    // Encontrar el cuadro de búsqueda utilizando el selector CSS
    WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));

    public void obtenerId(){
        // Obtener el ID del cuadro de búsqueda
        String id = searchBox.getAttribute("id");
        System.out.println("ID del cuadro de búsqueda: " + id);

        // Obtener el nombre (name) del cuadro de búsqueda
        String name = searchBox.getAttribute("name");
        System.out.println("Nombre del cuadro de búsqueda: " + name);

        // Obtener el XPath del cuadro de búsqueda
        //String xpath = getXPath(driver, searchBox);
        //System.out.println("XPath del cuadro de búsqueda: " + xpath);
    }

    public void search(String query) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }
}
