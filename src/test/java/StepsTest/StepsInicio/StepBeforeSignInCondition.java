package StepsTest.StepsInicio;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.SignInPage;
import picoContainers.BasePageSMS;
import StepsTest.BaseTest;
import recordDTO.SignInRecord;


public class StepBeforeSignInCondition {

    BasePageSMS basePageSMS;
    SignInRecord signInRecord;

    WebDriver driver= BaseTest.getDriver();

    public StepBeforeSignInCondition(BasePageSMS basePageSMS) {
        this.basePageSMS = basePageSMS;
    }

    @Given("Ya estoy registrado en el sms")
    public void ya_estoy_registrado_en_el_sms() {

        basePageSMS.signInPage = new SignInPage(driver);
    }

    @When("Ingreso mi nombre de usuario {string} y mi contraseña {string} para ingresar al SMS1")
    public void ingreso_mi_nombre_de_usuario_y_mi_contraseña_para_ingresar_al_sms1(String usuario, String password) {
        signInRecord = new SignInRecord(usuario, password);
        basePageSMS.signInPage.signIn(signInRecord.user(), signInRecord.password());
    }
}
