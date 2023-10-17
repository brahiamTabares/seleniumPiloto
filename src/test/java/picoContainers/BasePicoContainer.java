package picoContainers;


import io.cucumber.java.AfterStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class BasePicoContainer {
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver conexionChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("http://189.50.209.188/");
        return  driver;
    }

}








