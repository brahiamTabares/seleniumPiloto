package testPage;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.RegisterPage;
import recordDTO.RegisterRecord;

import static org.junit.jupiter.api.Assertions.*;

// Otras importaciones de JUnit 5, según sea necesario

public class RegisterTest extends BaseTest {

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
        RegisterRecord registerRecord = new RegisterRecord(nombreC,nombreUsuario,password);

      registerPage.registerUser(registerRecord.nombre(),registerRecord.user(),registerRecord.password(),registerRecord.password());
      String menssage = registerPage.confirMsgRegister();
      assertEquals("Operación completada", menssage);

    }

}
