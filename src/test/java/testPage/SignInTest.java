package testPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.SignInPage;

import java.util.concurrent.TimeUnit;


public class SignInTest extends BaseTest {

    private WebDriver driver;
    SignInPage signInPage;

    @BeforeEach
    public void setUp() throws Exception {
        setUpDriver();
        driver= getDriver();
        signInPage= new SignInPage(getDriver());
    }

    @AfterEach
    public void tearDown() throws Exception{
        //driver.quit();
    }
    @Test
    public void test() {
        signInPage.signIn(usuario,password);
    }
}
