package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/* Esta clase contendra los elementos base para el modelo POM, donde realizamos la conexion al navegador
 y realizamos el emboltorio ( los comando de selenium por si hay una actualizacion importante)para nuestros page objet*/
public class BasePage {
    // variable tipo Webdriver
    private  WebDriver driver;
    private  WebDriverWait ewait;

    public WebDriverWait getEwait() {
        return ewait;
    }

    // construcctor de la clase que obtiene como parametro un objeto Webdriver
    public BasePage(WebDriver driver) {

        this.driver = driver;
        ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // metodo que creara el emboltario (wraper) para los comandos de selenium Webdriver
    public WebElement findElement(By locator) {

        return driver.findElement(locator);
    }

    // este metodo nos devuelve una lista de elementos

    public List<WebElement> findElements(By locator) {

        return driver.findElements(locator);
    }

    // Este metodo devulve el texto del elemento que se pasa por parametro
    public String getText(WebElement element) {
        return element.getText();
    }

    //Este metodo nos devuelve el texto del elemento que estamos buscando por medio del locator
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    // Este metodo nos permite escribir texto en la prueba con el comando sendkeys o type(teclear)
    public void type(String inputText, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(inputText);
    }

    public  void click(By locator){
        ewait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    /* Este metodo nos dice si el elemento esta listo para ser utilizado, en el caso que no existe nos devuelve
    una excepcion de que el elemento no existe, no a cargado o fue modificado*/

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
