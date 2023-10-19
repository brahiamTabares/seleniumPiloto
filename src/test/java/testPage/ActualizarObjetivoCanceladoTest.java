package testPage;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.ObjetivoPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActualizarObjetivoCanceladoTest extends BaseTestSMS {

    Faker faker = new Faker();


    ObjetivoPage objetivoPage;
    String codigoObjetivo;

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
        String nuevoCod = faker.app().name();
        String nuevaDesc = faker.lorem().sentence();
        codigoObjetivo=objetivoPage.elementoAleatorio();
        objetivoPage.cancelarActualizarObjetivo(codigoObjetivo,nuevoCod,nuevaDesc);
        String message = objetivoPage.confirMSGAcualizarObjetivo();
        assertEquals(  "Operación cancelada", message);
        assertTrue(objetivoPage.buscarObjetivo(codigoObjetivo));

    }


}
