package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoalPage extends Base{

    By goalCodeLocator = By.xpath("//div[@class='ui-panelgrid-cell ui-g-12 ui-md-6']/input");
    By goalDescriptionLocator = By.xpath("//div[@class='ui-panelgrid-cell ui-g-12 ui-md-6']/textarea");
    By goalButtonLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Aceptar']");
    By messageGoal = By.xpath("//div[@class='ui-growl-message']/span[@class='ui-growl-title']");
    By titleApp = By.xpath("//div[@id='tituloApp']/h1");


    By tableBody = By.xpath("//div[@class='ui-datatable-tablewrapper']/tbody");
    By optionEditButton = By.xpath("//*[@class='ui-datatable-tablewrapper']/tbody//tr/td[3]/div//span[@class='ui-icon ui-icon-pencil']");

    By modifyCodeLocator = By.cssSelector(".ui-row-editing > td:nth-child(1) input");
    By modifyDescriptionLocator = By.cssSelector(".ui-row-editing > td:nth-child(2) textarea");
    By updateBtnCheckLocator = By.cssSelector(".ui-row-editing > td:nth-child(3) a.ui-row-editor-check");
    By cancelUpdateLocator = By. cssSelector(".ui-row-editing > td:nth-child(3) a.ui-row-editor-close");

    By deleteGoalLocator = By.xpath("//*[@class='ui-datatable-tablewrapper']/tbody//tr/td[3]/button//span[@class='ui-button-icon-left ui-icon ui-c pi pi-trash']");
    //By alertDeleteObjLocator = By.cssSelector(".ui-confirm-dialog");
    By alertDeleteGoalLocator = By.xpath("//div[@class='ui-confirm-dialog ui-dialog ui-widget ui-widget-content ui-corner-all ui-shadow ui-hidden-container']/div[@class='ui-dialog-buttonpane ui-dialog-footer ui-widget-content ui-helper-clearfix']");
    By confirmDeleteObjLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Si']");
    By cancelDeleteObjLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='No']");
    public GoalPage(WebDriver driver) {
        super(driver);
    }

    public void registerGoal(String code, String description){
        type(code, goalCodeLocator);
        type(description, goalDescriptionLocator);
        click(goalButtonLocator);
        WebDriverWait ewait = getEwait();
        ewait.until(ExpectedConditions.visibilityOfElementLocated(messageGoal));
    }

    public String receivePopupMessage(){
        return getText(messageGoal);
    }

    public boolean buscarObjetivo(String codigoObjetivo) {
        // Espera a que la tabla esté presente en la página
        if (buscarPosObjetivo(codigoObjetivo)>=0){
            return true;
        } else{
            return false;
        }

    }

    public int buscarPosObjetivo(String codigoObjetivo) {
        // Espera a que la tabla esté presente en la página
        getEwait().until(ExpectedConditions.presenceOfElementLocated(tableBody));

        List<WebElement> filas = findElements(By.cssSelector("#tabla\\:j_idt602_data tr"));
        System.out.println("Cant filas: " + filas.size());
        if (filas.size() == 1 && filas.get(0).getText().contains("No se encontraron registros")) {
            // Si la tabla está vacía y muestra el mensaje "No se encontraron registros"
            System.out.println("La tabla está vacía. No se encontraron registros.");
            return 0;
        }

        for (WebElement fila : filas) {
            List<WebElement> celdas = fila.findElements(By.tagName("td"));

            if (celdas.size() >= 2) {  // Verifica si hay al menos 2 celdas (código y descripción)
                String codigo = getText(celdas.get(0));
                String descripcion = getText(celdas.get(1));

                if (codigo.equalsIgnoreCase(codigoObjetivo) || descripcion.equalsIgnoreCase(codigoObjetivo)) {
                    // Encontrar el objetivo en la tabla
                    System.out.println("Objetivo encontrado en la tabla: " + codigoObjetivo);
                    // Puedes agregar aquí cualquier acción adicional que desees realizar
                    return Integer.parseInt(fila.getAttribute("data-ri"));
                }
            }
        }

        return -1;
    }

    public void actualizarObjetivo (String codigoObjetivo, String newCod, String newDescription){

        int pos = buscarPosObjetivo(codigoObjetivo);
        List<WebElement> botonesEditar = findElements(optionEditButton);
        //presiona el botón para actualizar los datos
        botonesEditar.get(pos).click();
        type(newCod, modifyCodeLocator);
        type(newDescription, modifyDescriptionLocator);
        click(updateBtnCheckLocator);
    }

    public void actualizarCancelObjetivo (String codigoObjetivo, String newCod, String newDescription){

        int pos = buscarPosObjetivo(codigoObjetivo);

        List<WebElement> botonesEditar = findElements(optionEditButton);
        //presiona el botón para actualizar los datos
        botonesEditar.get(pos).click();
        type(newCod, modifyCodeLocator);
        type(newDescription, modifyDescriptionLocator);
        click(cancelUpdateLocator);

    }

    public void eliminarObjetivo (String codigoObjetivo){
        int pos = buscarPosObjetivo(codigoObjetivo);
        List<WebElement> botonesEliminar = findElements(deleteGoalLocator);
        //presiona el botón para actualizar los datos
        botonesEliminar.get(pos).click();
        getEwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(alertDeleteGoalLocator));
        click(confirmDeleteObjLocator);

    }

    // Eliminar ui-button-icon-left ui-icon ui-c pi pi-trash
    // Modal Eliminar Div class ui-confirm-dialog ui-dialog ui-widget ui-widget-content ui-corner-all ui-shadow ui-hidden-container
    // span class ui-confirm-dialog-message 'Está seguro de eliminar este registro'
    // NO <span class="ui-button-text ui-c">No</span>
    // SI <span class="ui-button-text ui-c">Si</span>
    // X <span class="ui-icon ui-icon-closethick"></span>

    // Mensajes fallidos "Ocurrio un error inesperado en el sistema"

}