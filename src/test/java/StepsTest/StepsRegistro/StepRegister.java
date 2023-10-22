package StepsTest.StepsRegistro;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.RegisterPage;
import picoContainers.BasePageSMS;
import StepsTest.BaseTest;
import recordDTO.RegisterRecord;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepRegister {

    BasePageSMS basePageSMS;
    WebDriver driver = BaseTest.getDriver();

    Faker faker = new Faker();

    public StepRegister(BasePageSMS basePageSMS) {
        this.basePageSMS = basePageSMS;
    }

    @Given("Estoy en la página SMS-Builder para registrarme")
    public void estoy_en_la_página_sms_builder_para_registrarme() {

        basePageSMS.registerPage = new RegisterPage(driver);

    }

    @When("Ingreso los datos para registrarme")
    public void ingreso_los_datos_para_registrarme() throws InterruptedException {
        String nombreC = faker.name().fullName();
        String nombreUsuario = faker.name().username();
        String password = faker.internet().password();
        RegisterRecord registerRecord = new RegisterRecord(nombreC, nombreUsuario, password);
        basePageSMS.registerPage.registerUser(registerRecord.nombre(), registerRecord.user(), registerRecord.password(), registerRecord.password());

    }

    @Then("Me muestra un mensaje de operacion completa por el registro")
    public void me_muestra_un_mensaje_de_operacion_completa_por_el_registro() {

        String menssage = basePageSMS.registerPage.confirMsgRegister();
        assertEquals("Operación completada", menssage);

    }

}
