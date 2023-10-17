package StepsTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.BasePage;
import page.SMSpage;
import page.SignInPage;
import picoContainers.BasePagePicoContainer;
import picoContainers.BasePicoContainer;
import recordDTO.SignInRecord;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepSignIn {

    private BasePagePicoContainer basePagePicoContainer;
    public StepSignIn(BasePagePicoContainer basePagePicoContainer) {
        this.basePagePicoContainer = basePagePicoContainer;
    }

    String user = "brahiam";
    String password= "1234";


    @When("Ingreso mi nombre de usuario  y mi contraseña para ingresar al SMS")
    public void ingreso_mi_nombre_de_usuario_y_mi_contraseña_para_ingresar_al_sms() {

        SignInRecord signInRecord = new SignInRecord(user,password);
        basePagePicoContainer.signInPage.signIn(signInRecord.user(),signInRecord.password());


    }
    @Then("Me muestra la pantalla principal del SMS-Builder y valido que se observe el sms")
    public void me_muestra_la_pantalla_principal_del_sms_builder_y_valido_que_se_observe_el_sms() throws InterruptedException {

        basePagePicoContainer.smSpage =new SMSpage(basePagePicoContainer.basePicoContainer.getDriver());
        assertTrue(basePagePicoContainer.smSpage.isHomePageDisplayed(),"No inicio sesión");

    }




}
