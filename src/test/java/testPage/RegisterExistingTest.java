package testPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterExistingTest extends  BaseTest {
    RegisterPage registerPage;

    @BeforeEach
    public void setUp() throws Exception {
        setUpDriver();
        registerPage= new RegisterPage(getDriver());
    }
    @AfterEach
    public void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException{
        String nombreC = "brahiam David Tabares";
        String nombreUsuario = "brahiam";
        String password="1234";

        registerPage.registerUser(nombreC, nombreUsuario, password, password);
        String message = registerPage.confirMsgRegister();
        assertEquals(  "Existing registration", message);

    }
}
