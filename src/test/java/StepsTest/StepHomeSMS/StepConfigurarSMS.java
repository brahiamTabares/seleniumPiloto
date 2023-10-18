package StepsTest.StepHomeSMS;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import picoContainers.BasePageSMS;
import recordDTO.ConfigurarSMSRecord;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepConfigurarSMS {
    BasePageSMS basePageSMS;
    Faker faker = new Faker();

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
