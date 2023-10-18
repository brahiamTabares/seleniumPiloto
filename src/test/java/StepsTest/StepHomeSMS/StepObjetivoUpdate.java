package StepsTest.StepHomeSMS;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.ObjetivoPage;
import picoContainers.BasePageSMS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepObjetivoUpdate {

     BasePageSMS basePageSMS;
     Faker faker= new Faker();
    String codigoObjetivo;
    String nuevaDesc;
    String nuevoCod;

    public StepObjetivoUpdate(BasePageSMS basePageSMS) {
        this.basePageSMS = basePageSMS;
    }

    @When("Busco el objetivo ,ingreso los datos nuevos del objetivo")
    public void busco_el_objetivo_ingreso_los_datos_nuevos_del_objetivo() {
        basePageSMS.objetivoPage = new ObjetivoPage(basePageSMS.baseTest.getDriver());
        nuevoCod = faker.app().name();
        nuevaDesc = faker.lorem().sentence();
        codigoObjetivo=basePageSMS.objetivoPage.elementoAleatorio();
        basePageSMS.objetivoPage.actualizarObjetivo(codigoObjetivo,nuevoCod,nuevaDesc);
    }

    @Then("muestra mensaje de operación completada y el nuevo objetivo en tabla")
    public void muestra_mensaje_de_operación_completada_y_el_nuevo_objetivo_en_tabla() {
        String message = basePageSMS.objetivoPage.confirMSGAcualizarObjetivo();
        assertEquals(  "Operación completada", message);
        assertTrue(basePageSMS.objetivoPage.buscarObjetivo(nuevoCod));
    }


}
