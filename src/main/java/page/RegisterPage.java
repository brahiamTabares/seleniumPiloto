package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.fail;

public class RegisterPage extends BasePage {
      //Elementos de la pagina registrer

    By registerBtnLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Registrarse']");
    By userNameCompleteLocator = By.name("registro:nombre");
    By userNameLocator = By.id("registro:nombreUsuario");
    By passwordLocator = By.id("registro:clave");
    By confirmPasswordLocator=By.name("registro:verificacionClave");
    By acceptBtnLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Aceptar']");
    By confirMsgRegister = By.xpath("//div[@class='ui-growl-message']/span[@class='ui-growl-title']");







    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public  void registerUser (String nombreC, String nombreUsuario, String password, String confirmPassword) throws InterruptedException {
        click(registerBtnLocator);
        type(nombreC,userNameCompleteLocator);
        type(nombreUsuario,userNameLocator);
        type(password,passwordLocator);
        type(confirmPassword,confirmPasswordLocator);
        click(acceptBtnLocator);
    }

    public String confirMsgRegister(){

        getEwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(confirMsgRegister));

        return getText(confirMsgRegister);

    }
}
