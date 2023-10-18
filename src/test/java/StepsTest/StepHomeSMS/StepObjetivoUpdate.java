package StepsTest.StepHomeSMS;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import page.ObjetivoPage;
import picoContainers.BasePageSMS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepObjetivoUpdate {

     BasePageSMS basePageSMS;
     Faker faker= new Faker();

    public StepObjetivoUpdate(BasePageSMS basePageSMS) {
        this.basePageSMS = basePageSMS;
    }

    @When("Busco el objetivo ,ingreso los datos nuevos del objetivo")
    public void busco_el_objetivo_ingreso_los_datos_nuevos_del_objetivo() {
        basePageSMS.objetivoPage = new ObjetivoPage(basePageSMS.baseTest.getDriver());
        String codigoObjetivo= "tah";
        String nuevoCod = faker.app().name();
        String nuevaDesc = faker.lorem().sentence();
        basePageSMS.objetivoPage.actualizarObjetivo(codigoObjetivo,nuevoCod,nuevaDesc);
        String message = basePageSMS.objetivoPage.confirMSGAcualizarObjetivo();
        assertEquals(  "Operación completada", message);
        assertTrue(basePageSMS.objetivoPage.buscarObjetivo(nuevoCod));
    }
}
