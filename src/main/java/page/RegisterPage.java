package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
      //Elementos de la pagina registrer
     ////button/span[text()='Registrarse']
    By registerBtnLocator = By.id("j_idt76");
    By userNameCompleteLocator = By.name("registro:nombre");
    By userNameLocator = By.id("registro:nombreUsuario");
    By passwordLocator = By.id("registro:clave");
    By confirmPasswordLocator=By.name("registro:verificacionClave");

    By acceptBtnLocator=By.name("registro:j_idt88");


    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    public  void registerUser (String nombreC, String nombreUsuario, String password, String s) throws InterruptedException {
        click(registerBtnLocator);
        type(nombreC,userNameCompleteLocator);
        type(nombreUsuario,userNameLocator);
        type(password,passwordLocator);
        type(password,confirmPasswordLocator);
        click(acceptBtnLocator);

    }
}
