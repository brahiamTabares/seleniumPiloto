package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import static org.junit.jupiter.api.Assertions.fail;


public class SignInPage extends BasePage {

    By userLocator = By.name("nombreUsuario");
    By passLocator = By.id("clave");
    By signInBtnLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Ingresar']");
    By message = By.xpath("//div[@id='content']/span[contains(text(),'No tiene permiso para acceder a este recurso')]");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void signIn(String usuario, String password) {
        type(usuario, userLocator);
        type(password, passLocator);
        click(signInBtnLocator);
    }

    public String messageLogin(){
        // WaitforVisibleElement
        getEwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(message));
        // Se manda el elemento para obtener el texto
        return getText(message);

    }
}
