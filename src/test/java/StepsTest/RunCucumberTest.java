package StepsTest;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"}, // Ruta a tus archivos .feature
        glue = {"StepsTest"}, // Ruta a tus step definitions
        plugin = {"json:src/test/resources/reportucumber/cucumber_report.json", "html:src/test/resources/reportucumber/cucumber-html-report.html"}

)
public class RunCucumberTest {


}
