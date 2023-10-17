package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
;

public class ConfigurarSMSPage extends SMSpage {

    By nameSMSLocator = By.id("registro:nombre");
    By descriptionLocator = By.id("registro:descripcion");
    By configBtnLocator = By.xpath("//button/span[@class='ui-button-text ui-c' and text()='Aceptar']");

    public ConfigurarSMSPage(WebDriver driver) {
        super(driver);
    }

    public void configurarSms(String codigo, String descripcionP) {
        type(codigo, nameSMSLocator);
        type(descripcionP, descriptionLocator);
        click(configBtnLocator);


    }

    public boolean isHomePageDisplayed() {
        return true;

    }
}
