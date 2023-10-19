package StepsTest.StepHomeSMS;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.ObjetivoPage;
import picoContainers.BasePageSMS;
import picoContainers.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepObjetivoCancelUpdate {

    BasePageSMS basePageSMS;
    Faker faker= new Faker();
    String codigoObjetivo;
    String nuevaDesc;
    String nuevoCod;

    public StepObjetivoCancelUpdate(BasePageSMS basePageSMS) {
        this.basePageSMS = basePageSMS;
    }

    @When("Busco el objetivo ,ingreso los datos nuevos y cancelo el actualizar")
    public void busco_el_objetivo_ingreso_los_datos_nuevos_y_cancelo_el_actualizar() {
        basePageSMS.objetivoPage = new ObjetivoPage(basePageSMS.baseTest.getDriver());
        nuevoCod = faker.app().name();
        nuevaDesc = faker.lorem().sentence();
        codigoObjetivo=basePageSMS.objetivoPage.elementoAleatorio();
        basePageSMS.objetivoPage.cancelarActualizarObjetivo(codigoObjetivo,nuevoCod,nuevaDesc);
    }

    @Then("muestra mensaje de operación cancelada y el objetivo en tabla")
    public void muestra_mensaje_de_operación_cancelada_y_el_objetivo_en_tabla() {
        String message = basePageSMS.objetivoPage.confirMSGAcualizarObjetivo();
        assertEquals(  "Operación cancelada", message);
        assertTrue(basePageSMS.objetivoPage.buscarObjetivo(codigoObjetivo));
    }

}
