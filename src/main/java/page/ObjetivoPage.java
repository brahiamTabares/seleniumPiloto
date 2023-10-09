package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObjetivoPage extends SMSpage {

    By objetivoLocator = By.id("formulario:j_idt596");
    By descripObjLocator = By.id("formulario:j_idt598");
    By confirmObjLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Aceptar']");
    public ObjetivoPage(WebDriver driver) {
        super(driver);
    }
    public void declararObjetivo(String codigo, String descripcionO)  {
        type(codigo,objetivoLocator);
        type(descripcionO,descripObjLocator);
        click(confirmObjLocator);


    }

}