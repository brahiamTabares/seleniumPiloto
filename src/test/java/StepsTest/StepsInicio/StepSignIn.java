package StepsTest.StepsInicio;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.SMSpage;
import picoContainers.BaseInicioSMS;
import picoContainers.BaseTest;
import recordDTO.SignInRecord;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepSignIn {

   ;
    WebDriver driver = BaseTest.getDriver();
    String usuario=BaseTest.getUsuario();
    String password=BaseTest.getPassword();
            BaseInicioSMS baseInicioSMS;


    public StepSignIn(BaseInicioSMS baseInicioSMS) {
        this.baseInicioSMS = baseInicioSMS;
    }

    @When("Ingreso mi nombre de usuario  y mi contraseña para ingresar al SMS")
    public void ingreso_mi_nombre_de_usuario_y_mi_contraseña_para_ingresar_al_sms() {

        SignInRecord signInRecord = new SignInRecord(usuario, password);
        baseInicioSMS.signInPage.signIn(signInRecord.user(), signInRecord.password());


    }

    @Then("Me muestra la pantalla principal del SMS-Builder y valido que se observe el sms")
    public void me_muestra_la_pantalla_principal_del_sms_builder_y_valido_que_se_observe_el_sms() throws InterruptedException {

        SMSpage smspage = new SMSpage(driver);
        assertTrue(smspage.isHomePageDisplayed(), "No inicio sesión");

    }

}
