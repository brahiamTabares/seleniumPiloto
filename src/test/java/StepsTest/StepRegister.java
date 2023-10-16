package StepsTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import page.RegisterPage;
import page.SignInPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepRegister {

    private  StepBase stepBase;


    String nombreC= "Sandra Milena Quintero";
    String user ="samiquile";
    String clave ="1234";
    String confirmarC ="1234";



    RegisterPage registerPage;

    @Given("hago click en el  boton Registrarse")
    public void hago_click_en_el_boton_registrarse() {
        registerPage.clickRegistrarse();
    }
    @When("Ingreso mi nombre completo, el nombre de usurio,una clave y la confirmo")
    public void ingreso_mi_nombre_completo_el_nombre_de_usurio_una_clave_y_la_confirmo(){

        registerPage.registerUser(nombreC,user,clave,confirmarC);
    }

    @And("Hago Click en el boton Aceptar")
    public void hago_click_en_el_boton_aceptar() {
        registerPage.clickAceptar();
    }
    @Then("Me muestra un mensaje de Operación Completada")
    public void me_muestra_un_mensaje_de_operación_completada() {
        String menssage = registerPage.confirMsgRegister();
        assertEquals("Operación completada", menssage);

    }

}
