package testPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.SMSpage;
import page.SignInPage;

import static org.junit.jupiter.api.Assertions.*;

public class SignInTest extends BaseTest {

    SignInPage signInPage;

    @BeforeEach
    public void setUp() throws Exception {
        setUpDriver();
        signInPage = new SignInPage(getDriver());
    }

    @AfterEach
    public void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        signInPage.signIn(usuario, password);

        SMSpage smspage = new SMSpage(getDriver());
        assertTrue(smspage.isHomePageDisplayed(), "No inicio sesión");

    }
}
