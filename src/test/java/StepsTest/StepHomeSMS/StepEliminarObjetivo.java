package StepsTest.StepHomeSMS;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import page.ObjetivoPage;
import picoContainers.BasePageSMS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StepEliminarObjetivo {

     BasePageSMS basePageSMS;
    String codigoObjetivo;

    public StepEliminarObjetivo(BasePageSMS basePageSMS) {
        this.basePageSMS = basePageSMS;
    }

    @When("Busco el objetivo y elimino el objetivo")
    public void busco_el_objetivo_y_elimino_el_objetivo() {
        basePageSMS.objetivoPage = new ObjetivoPage(basePageSMS.baseTest.getDriver());
        //codigoObjetivo= "npu";
         codigoObjetivo=basePageSMS.objetivoPage.elementoAleatorio();
         basePageSMS.objetivoPage.eliminarObjetivo(codigoObjetivo);

    }
    @Then("muestra mensaje de operación completada y busca el objetivo en la tabla;")
    public void muestra_mensaje_de_operación_completada_y_busca_el_objetivo_en_la_tabla() {
        String message = basePageSMS.objetivoPage.confirMsgObjetivo();
        assertEquals(  "Operación completada", message);
        assertFalse(basePageSMS.objetivoPage.buscarObjetivo(codigoObjetivo));
    }
}
