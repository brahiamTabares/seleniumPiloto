package testPage;

import page.SignInPage;

public class BaseTestSMS extends BaseTest {

    SignInPage signInPage;

    public void login() {
        setUpDriver();
        signInPage = new SignInPage(getDriver());
        signInPage.signIn(usuario, password);
    }

}
