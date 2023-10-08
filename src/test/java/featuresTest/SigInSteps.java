package featuresTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.SignInPage;

public class SigInSteps {
    private WebDriver driver;

    private SignInPage signInPage;
    @Given("El usuario está en la página de inicio de sesión")
    public void sigInUser() {

       driver.get("http://localhost:8080/");
    }

    @When("El usuario ingresa su nombre de usuario {string} y contraseña {string}")
    public void sigInValues(String username, String password) {

        signInPage.signIn(username,password);



    }

    @Then("El usuario debería estar en la página de inicio")
    public void sigIn() {



    }
}

