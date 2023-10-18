package StepsTest.StepsInicio;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import picoContainers.BaseInicioSMS;
import recordDTO.RegisterRecord;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepRegister {

    BaseInicioSMS baseInicioSMS;

    Faker faker = new Faker();

    public StepRegister(BaseInicioSMS baseInicioSMS) {
        this.baseInicioSMS = baseInicioSMS;
    }

    @When("Ingreso los datos para registrarme")
    public void ingreso_los_datos_para_registrarme() throws InterruptedException {

        String nombreC = faker.name().fullName();
        String nombreUsuario = faker.name().username();
        String password = faker.internet().password();
        RegisterRecord registerRecord = new RegisterRecord(nombreC, nombreUsuario, password);
        baseInicioSMS.registerPage.registerUser(registerRecord.nombre(), registerRecord.user(), registerRecord.password(), registerRecord.password());

    }

    @Then("Me muestra un mensaje de operacion completa por el registro")
    public void me_muestra_un_mensaje_de_operacion_completa_por_el_registro() {

        String menssage = baseInicioSMS.registerPage.confirMsgRegister();
        assertEquals("Operación completada", menssage);

    }

}
