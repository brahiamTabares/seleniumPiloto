package StepsTest.StepHomeSMS;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import page.ConfigurarSMSPage;
import page.SignInPage;
import picoContainers.BasePageSMS;
import picoContainers.BaseTest;
import recordDTO.SignInRecord;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepHomeSMS {

    BasePageSMS basePageSMS;

    public StepHomeSMS(BasePageSMS basePageSMS) {
        this.basePageSMS = basePageSMS;
    }

    @Given("Estoy en la página SMS-Builder")
    public void estoy_en_la_página_sms_builder() {

        basePageSMS.baseTest = new BaseTest();
        basePageSMS.baseTest.setUpDriver();

    }

    @And("Ingreso mi nombre de usuario  y mi contraseña para ingresar al SMS")
    public void ingreso_mi_nombre_de_usuario_y_mi_contraseña_para_ingresar_al_sms() {
        basePageSMS.signInPage= new SignInPage(basePageSMS.baseTest.getDriver());
        String usuario = "brahiam";

        String password = "1234";

        SignInRecord signInRecord = new SignInRecord(usuario, password);
        basePageSMS.signInPage.signIn(signInRecord.user(),signInRecord.password());
    }


}