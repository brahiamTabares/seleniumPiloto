package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ConfigurarSMSPage extends BasePage {

    By configSMSLocator= By.xpath("//span[@class='ui-steps-number' and text()='1']");
    By nameSMSLocator=By.id("registro:nombre");
    By descriptionLocator= By.id("registro:descripcion");
    By configBtnLocator= By.id("registro:j_idt84");
    public ConfigurarSMSPage(WebDriver driver) {
        super(driver);
    }
    public void configurarSms()  {

        click(configSMSLocator);
        type("Automatizacion",nameSMSLocator);
        type("Este mapeo tiene como enfoque la automatizacion de pruebas",descriptionLocator);
        click(configBtnLocator);


    }

    public boolean isHomePageDisplayed(){
        return  true;

    }
}
