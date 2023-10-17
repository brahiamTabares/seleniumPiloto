package testPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.ObjetivoPage;
import recordDTO.ObjetivoRecord;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuscarObjetivoTest extends BaseTestSMS {

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
        String codigoObjetivo = "Aerifie";
        ObjetivoRecord objetivoRecord= new ObjetivoRecord(codigoObjetivo,null);
        assertTrue(objetivoPage.buscarObjetivo(objetivoRecord.codigoO()),"no se encontro el objetivo");;

    }


}
