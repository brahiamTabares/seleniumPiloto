package testPage;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.RegisterPage;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

// Otras importaciones de JUnit 5, según sea necesario

public class RegisterTest extends BaseTest {

    private WebDriver driver;
    RegisterPage registerPage;
    Faker faker = new Faker();

    @BeforeEach
    public void setUp() throws Exception {
        setUpDriver();
        registerPage= new RegisterPage(getDriver());

    }
    @AfterEach
    public void tearDown() throws Exception{
        //driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        String nombreC = faker.name().fullName();
        String nombreUsuario = faker.name().username();
        String password=faker.internet().password();

      registerPage.registerUser(nombreC,nombreUsuario,password,password);


    }

}
