package testPage;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.ConfigurarSMSPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigurarSMSTest extends BaseTestSMS {
    ConfigurarSMSPage configurarSMSPage;
    Faker faker = new Faker();

    @BeforeEach
    public void setUp() throws InterruptedException {
        login();
        configurarSMSPage = new ConfigurarSMSPage(getDriver());
        assertTrue(configurarSMSPage.isHomePageDisplayed(), "No inició sesión correctamente");
        if (!configurarSMSPage.getTitleSMS().contains("Configurar SMS")) {
            configurarSMSPage.goStep("Configurar SMS");
        }

    }

    @AfterEach
    public void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        String codigo = faker.app().name();
        String descripcionP = faker.lorem().sentence();
        configurarSMSPage.configurarSms(codigo, descripcionP);
        System.out.println(configurarSMSPage.getTitleSMS());
        assertTrue(configurarSMSPage.getTitleSMS().contains("Objetivo"));
    }
}
