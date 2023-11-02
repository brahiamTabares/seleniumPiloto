package StepsTest;


import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    //Datos quemados para el logueo(Opcion no recomenadle hay que  mejorarlo)

    private static  WebDriver driver;


    public  static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setUp(Scenario scenario)
    {
        driver = chromeDriverConnection();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://localhost:8080");
        driver.manage().window().maximize();
        screenShotStepBefore(scenario);

    }
    private WebDriver chromeDriverConnection() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }
    @After
    public void tearDown(Scenario scenario){
        screenShotStepBefore(scenario);
        driver.quit();
    }
    @BeforeStep
    public void screenShotStepBefore(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "screenshot step");

    }
}








