package StepsTest.StepHomeSMS;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.ConfigurarSMSPage;
import picoContainers.BasePageSMS;
import picoContainers.BaseTest;
import recordDTO.ConfigurarSMSRecord;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepConfigurarSMS {

    BasePageSMS basePageSMS;
    Faker faker = new Faker();
    @And("Me encuentro en la pagina del SMS y selecciono una de las opciones del sms")
    public void me_encuentro_en_la_pagina_del_sms_y_selecciono_una_de_las_opciones_del_sms() {
        {   basePageSMS.configurarSMSPage=new ConfigurarSMSPage(basePageSMS.baseTest.getDriver());
            assertTrue(basePageSMS.configurarSMSPage.isHomePageDisplayed(), "No inició sesión correctamente");
            if (!basePageSMS.configurarSMSPage.getTitleSMS().contains("Configurar SMS")) {
                basePageSMS.configurarSMSPage.goStep("Configurar SMS");
            }

        }
    }

    public StepConfigurarSMS(BasePageSMS basePageSMS) {
        this.basePageSMS = basePageSMS;
    }

    @When("Tengo un nombre al sms y una descripcion diligenciada")
    public void tengo_un_nombre_al_sms_y_una_descripcion_diligenciada() {
        String codigo = faker.app().name();
        String descripcionP = faker.lorem().sentence();
        ConfigurarSMSRecord configurarSMSRecord= new ConfigurarSMSRecord(codigo,descripcionP);
        basePageSMS.configurarSMSPage.configurarSms(configurarSMSRecord.nombreSMS(),configurarSMSRecord.descripCionMSM());
    }
    @Then("visualizo que me encuentro en la pagina de objetivo despues de configurar el sms")
    public void visualizo_que_me_encuentro_en_la_pagina_de_objetivo_despues_de_configurar_el_sms() {
        System.out.println(basePageSMS.configurarSMSPage.getTitleSMS());
        assertTrue(basePageSMS.configurarSMSPage.getTitleSMS().contains("Objetivo"));
    }
}
