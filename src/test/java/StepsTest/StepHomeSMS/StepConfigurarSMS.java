package StepsTest.StepHomeSMS;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import page.ConfigurarSMSPage;
import picoContainers.BasePageSMS;
import StepsTest.BaseTest;
import recordDTO.ConfigurarSMSRecord;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepConfigurarSMS {

    BasePageSMS basePageSMS;
    WebDriver driver= BaseTest.getDriver();
    Faker faker = new Faker();

    public StepConfigurarSMS(BasePageSMS basePageSMS) {
        this.basePageSMS = basePageSMS;
    }

    @And("Me encuentro en la pagina del SMS y selecciono una de las opciones del sms")
    public void me_encuentro_en_la_pagina_del_sms_y_selecciono_una_de_las_opciones_del_sms2() {

        basePageSMS.configurarSMSPage = new ConfigurarSMSPage(driver);
        assertTrue(basePageSMS.configurarSMSPage.isHomePageDisplayed(), "No inició sesión correctamente");
        if (!basePageSMS.configurarSMSPage.getTitleSMS().contains("Configurar SMS")) {
            basePageSMS.configurarSMSPage.goStep("Configurar SMS");
        }

    }
    @And("Tengo un nombre al sms y una descripcion diligenciada")
    public void tengo_un_nombre_al_sms_y_una_descripcion_diligenciada() {
        String codigo = faker.app().name();
        String descripcionP = faker.lorem().sentence();
        basePageSMS.configurarSMSRecord= new ConfigurarSMSRecord(codigo,descripcionP);
        basePageSMS.configurarSMSPage.configurarSms(basePageSMS.configurarSMSRecord.nombreSMS(),basePageSMS.configurarSMSRecord.descripCionMSM());
    }
    @Then("visualizo que me encuentro en la pagina de objetivo despues de configurar el sms")
    public void visualizo_que_me_encuentro_en_la_pagina_de_objetivo_despues_de_configurar_el_sms() {
        System.out.println(basePageSMS.configurarSMSPage.getTitleSMS());
        assertTrue(basePageSMS.configurarSMSPage.getTitleSMS().contains("Objetivo"));
    }

}
