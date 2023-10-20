package pom;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"pom"},
        //plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter::resources/cucumber-reports/report.html"}
        plugin = {"json:src/test/resources/reportucumber/cucumber_report.json"}
)
public class RunnerTest {
    //Documentacion nodejs reportes https://www.npmjs.com/package/multiple-cucumber-html-reporter
    @AfterClass
    public static void finish(){
        try {
            System.out.println("Generar reporte index.html");
            String[] cmd = {"cmd.exe", "/c", "npm run report"};
            Runtime.getRuntime().exec(cmd);
            System.out.println("¡Reporte generado!");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
