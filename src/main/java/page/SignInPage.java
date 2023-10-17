package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import static org.junit.jupiter.api.Assertions.fail;


public class SignInPage extends BasePage {

    By userLocator = By.name("nombreUsuario");
    By passLocator = By.id("clave");
    By signInBtnLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Ingresar']");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void signIn(String usuario, String password) {
        type(usuario, userLocator);
        type(password, passLocator);
        click(signInBtnLocator);
    }
}
