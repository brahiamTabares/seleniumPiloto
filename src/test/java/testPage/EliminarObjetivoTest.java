package testPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.ObjetivoPage;

import static org.junit.jupiter.api.Assertions.*;

public class EliminarObjetivoTest extends BaseTestSMS{


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

        codigoObjetivo=objetivoPage.elementoAleatorio();
        objetivoPage.eliminarObjetivo(codigoObjetivo);
        String message = objetivoPage.confirMsgObjetivo();
        assertEquals(  "Operación completada", message);
        assertFalse(objetivoPage.buscarObjetivo(codigoObjetivo));

    }

}
