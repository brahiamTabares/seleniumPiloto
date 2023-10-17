package testPage;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.ObjetivoPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ActualizarObjetivoTest extends BaseTestSMS{
    Faker faker = new Faker();

    //<span class="ui-icon ui-icon-pencil"></span>
    //<div id="tabla:j_idt602:0:j_idt612"
    //<span class="ui-icon ui-icon-pencil"></span>


    ObjetivoPage objetivoPage;

    @BeforeEach
    public void setUp() throws InterruptedException {
        login();
        objetivoPage = new ObjetivoPage(getDriver());
        assertTrue(objetivoPage.isHomePageDisplayed(), "No inició sesión correctamente");
        if (!objetivoPage.getTitleSMS().contains("Objetivo")) {
            objetivoPage.goStep("Objetivo");
        }
    }

    @AfterEach
    public void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        String codigoObjetivo= "Tempsoft";
        String nuevoCod = faker.app().name();
        String nuevaDesc = faker.lorem().sentence();
        objetivoPage.actualizarObjetivo(codigoObjetivo,nuevoCod,nuevaDesc);
        String message = objetivoPage.confirMSGAcualizarObjetivo();
        assertEquals(  "Operación completada", message);
        assertTrue(objetivoPage.buscarObjetivo(nuevoCod));

    }
}