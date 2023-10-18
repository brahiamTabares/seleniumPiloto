package picoContainers;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class BaseTest {
    //Datos quemados para el logueo(Opcion no recomenadle hay que  mejorarlo)

    private WebDriver driver;
    //Metodo para inicializar el navegador
    public WebDriver getDriver() {
        return driver;
    }
    //Metodo que permite la conexcion con el navegador chrome y la pagina de pruebas sms-builder
    public WebDriver chromeDriverConnection(){
        WebDriverManager.chromedriver().setup();// aca se le indica el navegador a trabajar
        driver= new ChromeDriver();// se le indica al programa que inicialize y habra el navegador/
        return driver;
    }

    //Este metodo remplaza el metodo visit que usamos para indicar la url de la pagina de pruebas
    public void setUpDriver(){
        driver= chromeDriverConnection();
        // Waint implicito, el cual nos permite esperar que uno o varios elementos esten en la pagina ya cargados
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://189.50.209.188/");

        driver.manage().window().maximize();
    }


}








