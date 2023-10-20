package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class GoalPage extends Base{

    By goalCodeLocator = By.xpath("//div[@class='ui-panelgrid-cell ui-g-12 ui-md-7']/input[@id='formulario:j_idt83']");
    By goalDescriptionLocator = By.xpath("//div[@class='ui-panelgrid-cell ui-g-12 ui-md-6']/textarea");
    By goalButtonLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Aceptar']");
    By messageGoal = By.xpath("//div[@class='ui-growl-message']/span[@class='ui-growl-title']");
    By titleApp = By.xpath("//div[@id='tituloApp']/h1");


    By tableBody = By.id("tabla:j_idt89_data");
    By optionEditButton = By.xpath("//*[@id='tabla:j_idt89_data']//tr/td[3]/div//span[@class='ui-icon ui-icon-pencil']");

    By modifyCodeLocator = By.cssSelector(".ui-row-editing > td:nth-child(1) input");
    By modifyDescriptionLocator = By.cssSelector(".ui-row-editing > td:nth-child(2) textarea");
    By updateBtnCheckLocator = By.cssSelector(".ui-row-editing > td:nth-child(3) a.ui-row-editor-check");
    By cancelUpdateLocator = By. cssSelector(".ui-row-editing > td:nth-child(3) a.ui-row-editor-close");

    By deleteGoalLocator = By.xpath("//*[@id='tabla:j_idt89_data']//tr/td[3]/button//span[@class='ui-button-icon-left ui-icon ui-c pi pi-trash']");
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
        getEwait().until(ExpectedConditions.visibilityOfElementLocated(messageGoal));
    }

    public String receivePopupMessage(){
        return getText(messageGoal);
    }

    public boolean validateGoalSearch(String searchCode) {
        if(isDisplayed(messageGoal)){
            getEwait().until(ExpectedConditions.presenceOfElementLocated(tableBody));
        }
        return findGoalCodePosition(searchCode) >= 0;
    }

    public int findGoalCodePosition(String searchCode) {

        getEwait().until(ExpectedConditions.presenceOfElementLocated(tableBody));
        getEwait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#tabla\\:j_idt89_data tr")));

        List<WebElement> rows = findElements(By.cssSelector("#tabla\\:j_idt89_data tr"));
        if (rows.size() == 1 && rows.get(0).getText().contains("No se encontraron registros")) {
            System.out.println("No se encontraron registros.");
            return 0;
        }

        for (WebElement field : rows) {
            List<WebElement> fields = field.findElements(By.tagName("td"));
            String code = getText(fields.get(0));

            if (code.equalsIgnoreCase(searchCode)) {
                    System.out.println("Find Goal: " + searchCode);
                    return Integer.parseInt(field.getAttribute("data-ri"));
            }
        }
        return -1;
    }

    public void updateConfirmGoal(String searchCode, String newCode, String newDescription){

        updateGoal(searchCode, newCode, newDescription);
        click(updateBtnCheckLocator);
    }

    public void updateCancelGoal(String searchCode, String newCode, String newDescription){
        updateGoal(searchCode, newCode, newDescription);
        click(cancelUpdateLocator);
    }

    private void updateGoal(String searchCode, String newCode, String newDescription) {
        int position = findGoalCodePosition(searchCode);
        List<WebElement> btnEdit = findElements(optionEditButton);
        btnEdit.get(position).click();
        type(newCode, modifyCodeLocator);
        type(newDescription, modifyDescriptionLocator);
    }

    public void deleteGoal(String searchCode){
        clickDelete(searchCode);
        click(confirmDeleteObjLocator);

    }

    private void clickDelete(String searchCode) {
        int pos = findGoalCodePosition(searchCode);
        List<WebElement> btnDelete = findElements(deleteGoalLocator);
        btnDelete.get(pos).click();
        getEwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(alertDeleteGoalLocator));
    }

    public void deleteCancelGoal(String searchCode){
        clickDelete(searchCode);
        click(cancelDeleteObjLocator);

    }

    public String getRandomRow() {
        getEwait().until(ExpectedConditions.presenceOfElementLocated(tableBody));
        List<WebElement> rows = findElements(By.cssSelector("#tabla\\:j_idt89_data tr"));
        if (rows.size() == 1 && rows.get(0).getText().contains("No se encontraron registros")) {
            return null;
        }
        // Genera un número aleatorio entre 0 y rows.size() - 1
        Random random = new Random();
        int randomIndex = random.nextInt(rows.size());
        List<WebElement> field = rows.get(randomIndex).findElements(By.tagName("td"));
        System.out.println("Campo en el random " + getText(field.get(0)));
        return getText(field.get(0));

    }
}