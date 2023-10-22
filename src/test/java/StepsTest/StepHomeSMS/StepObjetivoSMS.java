package StepsTest.StepHomeSMS;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import page.ObjetivoPage;
import picoContainers.BasePageSMS;
import StepsTest.BaseTest;
import recordDTO.ObjetivoRecord;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepObjetivoSMS {

    BasePageSMS basePageSMS;
    Faker faker= new Faker();
    String codigoO;
    String descripcionO;
    WebDriver driver= BaseTest.getDriver();

    public StepObjetivoSMS(BasePageSMS basePageSMS) {
        this.basePageSMS = basePageSMS;
    }

    @And("Me encuentro en la pagina del SMS y selecciono una de las opciones del sms3")
    public void me_encuentro_en_la_pagina_del_sms_y_selecciono_una_de_las_opciones_del_sms3() throws InterruptedException {

        basePageSMS.objetivoPage = new ObjetivoPage(driver);
        assertTrue(basePageSMS.objetivoPage.isHomePageDisplayed(), "No inició sesión correctamente");
        if(!basePageSMS.objetivoPage.getTitleSMS().contains("Objetivo")) {
            basePageSMS.objetivoPage.goStep("Objetivo");
        }

    }

    @And("ingreso los datos del codigo y descripcion y creo el objetivo")
    public void ingreso_los_datos_del_codigo_y_descripcion_y_creo_el_objetivo(){
        codigoO = faker.code().asin();
        descripcionO = faker.lorem().sentence();
        basePageSMS.objetivoPage = new ObjetivoPage(driver);
        ObjetivoRecord objetivoRecord= new ObjetivoRecord(codigoO,descripcionO);
        basePageSMS.objetivoPage.declararObjetivo(objetivoRecord.codigoO(), objetivoRecord.descripcionO());

    }

    @Then("muestra mensaje de operación completada y objetivo en tabla")
    public void muestra_mensaje_de_operación_completada() {
        String menssage = basePageSMS.objetivoPage.confirMsgObjetivo();
        assertEquals(  "Operación completada",menssage);
        assertTrue(basePageSMS.objetivoPage.isDisplayeObjetivePage());
        assertTrue(basePageSMS.objetivoPage.buscarObjetivo(codigoO));
    }
}
