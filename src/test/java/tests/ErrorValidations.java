package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import utilities.BaseTest;


public class ErrorValidations extends BaseTest {

    @Test
    public void loginToAccountWithWrongEmail(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginWithWrongEmail("email");
        String wrongEmailMessage = landingPage.getErrorMessage();
        Assert.assertTrue(wrongEmailMessage.equalsIgnoreCase("Nie udało się znaleźć konta powiązanego z tym adresem e-mail."));
    }
    @Test
    public void loginToAccountWithWrongPassword() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginWithCorrectEmailButWrongPasswordValidation("testworker00@gmail.com", "123123");
        String wrongPasswordMessage = landingPage.getErrorMessage();
        Assert.assertTrue(wrongPasswordMessage.equalsIgnoreCase("Nieprawidłowe hasło"));
    }

}
