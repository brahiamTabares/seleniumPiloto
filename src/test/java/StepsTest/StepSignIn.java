package StepsTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import page.SMSpage;
import page.SignInPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepSignIn {

    private final StepBase stepBase;

    public StepSignIn(StepBase stepBase) {
        this.stepBase = stepBase;
    }

    String user = "brahiam";
    String password= "1234";
    SignInPage signInPage;


    @Given("Estoy en la página de inicio de sesión")
    public void estoy_en_la_página_de_inicio_de_sesión() {
        WebDriverManager.chromedriver().setup();

        stepBase.driver= new ChromeDriver();
        stepBase.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        stepBase.driver.navigate().to("http://189.50.209.188/");
    }
    @When("Ingreso mi nombre de usuario  y mi contraseña")
    public void ingreso_mi_nombre_de_usuario_y_mi_contraseña_valida() {

        signInPage = new SignInPage(stepBase.driver);
        signInPage.signIn(user,password);
    }
    @And("hago click en el boton Ingresar")
    public void hago_click_en_el_boton_ingresar() {

        signInPage.clickIngresar();
    }
    @Then("Me muestra la pantalla principal del SMS-Builder")
    public void me_muestra_la_pantalla_principal_del_sms_builder()throws InterruptedException {
        SMSpage smSpage = new SMSpage(stepBase.driver);
        assertTrue(smSpage.isHomePageDisplayed(),"No inicio sesión");
    }
}
