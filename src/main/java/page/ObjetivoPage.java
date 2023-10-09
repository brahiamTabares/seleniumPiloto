package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObjetivoPage extends BasePage {

    By objSMSLocator = By.xpath("//span[@class='ui-steps-number' and text()='2']");
    By objetivoLocator = By.id("formulario:j_idt596");
    By descripObjLocator = By.id("formulario:j_idt598");
    By confirmObjLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Aceptar']");

    public ObjetivoPage(WebDriver driver) {
        super(driver);
    }

    public void objetivopage() {

        click(objSMSLocator);
        type("objetivo 2", objetivoLocator);
        type("Objetivo test", descripObjLocator);
        click(confirmObjLocator);

    }
}