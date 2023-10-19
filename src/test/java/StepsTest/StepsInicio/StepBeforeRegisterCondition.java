package StepsTest.StepsInicio;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import page.RegisterPage;
import picoContainers.BaseInicioSMS;
import picoContainers.BaseTest;

public class StepBeforeRegisterCondition {

    WebDriver driver=BaseTest.getDriver();
    private BaseInicioSMS baseInicioSMS;

    public StepBeforeRegisterCondition(BaseInicioSMS baseInicioSMS) {
        this.baseInicioSMS = baseInicioSMS;
    }

    @Given("Estoy en la página SMS-Builder para registrarme")
    public void estoy_en_la_página_sms_builder_para_registrarme() {
        baseInicioSMS.baseTest = new BaseTest();
        baseInicioSMS.baseTest.setUpDriver();
        baseInicioSMS.registerPage = new RegisterPage(driver);

    }
}
