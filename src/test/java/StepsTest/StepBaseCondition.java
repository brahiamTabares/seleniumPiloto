package StepsTest;

import io.cucumber.java.en.Given;
import picoContainers.BasePagePicoContainer;
import picoContainers.BasePicoContainer;

public class StepBaseCondition {
    private BasePagePicoContainer basePagePicoContainer;

    public StepBaseCondition(BasePagePicoContainer basePagePicoContainer) {
        this.basePagePicoContainer = basePagePicoContainer;
    }

    @Given("Estoy en la página SMS-Builder  para sesión")
    public void estoy_en_la_página_sms_builder_para_sesión() {
        basePagePicoContainer.basePicoContainer = new BasePicoContainer();
        basePagePicoContainer.basePicoContainer.conexionChrome();

    }
}
