package StepsTest.StepHomeSMS;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import page.ObjetivoPage;
import picoContainers.BasePageSMS;
import StepsTest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StepEliminarObjetivo {


     BasePageSMS basePageSMS;
    String codigoObjetivo;
    WebDriver driver= BaseTest.getDriver();

    public StepEliminarObjetivo(BasePageSMS basePageSMS) {
        this.basePageSMS = basePageSMS;
    }

    @And("Busco el objetivo y elimino el objetivo")
    public void busco_el_objetivo_y_elimino_el_objetivo() {
        basePageSMS.objetivoPage = new ObjetivoPage(driver);
        codigoObjetivo=basePageSMS.objetivoPage.elementoAleatorio();
        System.out.println(codigoObjetivo);
        basePageSMS.objetivoPage.eliminarObjetivo(codigoObjetivo);

    }
    @Then("muestra mensaje de operación completada y busca el objetivo en la tabla;")
    public void muestra_mensaje_de_operación_completada_y_busca_el_objetivo_en_la_tabla() {
        String message = basePageSMS.objetivoPage.confirMsgObjetivo();
        assertEquals(  "Operación completada", message);
        assertFalse(basePageSMS.objetivoPage.buscarObjetivo(codigoObjetivo));
    }
}
