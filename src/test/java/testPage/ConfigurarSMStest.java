package testPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.ConfigurarSMSPage;
import page.SignInPage;

public class ConfigurarSMStest extends BaseTest {

    private WebDriver driver;
     ConfigurarSMSPage configurarSMSPage;
     SignInPage signInPage;

    @BeforeEach
    public void setUp() throws Exception {
        setUpDriver();
        signInPage= new SignInPage(getDriver());
        configurarSMSPage= new ConfigurarSMSPage(driver);

    }
    @AfterEach
    public void tearDown() throws Exception{
        //driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        signInPage.signIn(usuario,password);
        configurarSMSPage.configurarSms();
    }
}
