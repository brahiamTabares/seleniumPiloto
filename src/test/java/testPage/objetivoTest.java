package testPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.ObjetivoPage;
import page.SignInPage;

public class objetivoTest extends BaseTest{
    SignInPage signInPage;
    ObjetivoPage objetivoPage;

    @BeforeEach
    public void setUp(){

        setUpDriver();
        signInPage = new SignInPage(getDriver());
        objetivoPage = new ObjetivoPage(getDriver());
    }
    @AfterEach
    public void tearDown()throws Exception {
        //driver.quit
    }

    @Test
    public void test() throws InterruptedException{

        signInPage.signIn(usuario,password);
        objetivoPage.objetivopage();
    }
}
