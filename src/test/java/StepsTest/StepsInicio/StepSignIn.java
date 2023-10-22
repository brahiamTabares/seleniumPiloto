package StepsTest.StepsInicio;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import page.SMSpage;
import StepsTest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepSignIn {

    WebDriver driver =BaseTest.getDriver();


    @Then("Me muestra la pantalla principal del SMS-Builder y valido que se observe el sms")
    public void me_muestra_la_pantalla_principal_del_sms_builder_y_valido_que_se_observe_el_sms() throws InterruptedException {
        SMSpage smspage = new SMSpage(driver);
        assertTrue(smspage.isHomePageDisplayed(), "No inicio sesión");

    }

}
