package StepsTest.StepsInicio;

import io.cucumber.java.en.Given;
import page.SignInPage;
import picoContainers.BaseInicioSMS;
import picoContainers.BaseTest;

public class StepBeforeSignInCondition {
    private BaseInicioSMS baseInicioSMS;

    public StepBeforeSignInCondition(BaseInicioSMS baseInicioSMS) {
        this.baseInicioSMS = baseInicioSMS;
    }

    @Given("Estoy en la página SMS-Builder")
    public void estoy_en_la_página_sms_builder() {

        baseInicioSMS.baseTest = new BaseTest();
        baseInicioSMS.baseTest.setUpDriver();
        baseInicioSMS.signInPage = new SignInPage(baseInicioSMS.baseTest.getDriver());
    }
}
