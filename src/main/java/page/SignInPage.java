package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage{

    By userLocator = By.name("nombreUsuario");
    By passLocator = By.id("clave");
    By signInBtnLocator = By.id("j_idt67");
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void signIn(String usuario, String password){
        type(usuario,userLocator);
        type(password,passLocator);
        click(signInBtnLocator);

    }

    public boolean isHomePageDisplayed(){
        return  true;

    }

}
