package testPage;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.ConfigurarSMSPage;
import page.ObjetivoPage;
import page.SignInPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class objetivoTest extends BaseTestSMS{
    ObjetivoPage objetivoPage;
    ConfigurarSMSPage configurarSMSPage;
    Faker faker = new Faker();

    @BeforeEach
    public void setUp() throws InterruptedException {
        login();
        objetivoPage = new ObjetivoPage(getDriver());
        configurarSMSPage= new ConfigurarSMSPage(getDriver());
        assertTrue(objetivoPage.isHomePageDisplayed(), "No inició sesión correctamente");
        if(!objetivoPage.getTitleSMS().contains("Objetivo")) {
            objetivoPage.goStep("Objetivo");
        }else if (configurarSMSPage.getTitleSMS().contains("Configurar SMS")){
            configurarSMSPage.corregirPaso();
        }
    }
    @AfterEach
    public void tearDown() throws Exception{
        //driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        String codigo = faker.app().name();
        String descripcionO = faker.lorem().sentence();
        objetivoPage.declararObjetivo(codigo,descripcionO);
    }
}
