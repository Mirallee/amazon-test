package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LandingPage;
import utilities.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void loginToAccount(HashMap<String, String> input){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginApplication(input.get("email"), input.get("password"));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
                + "//src//test//java//utilities//dataFile.json");
        return new Object[][]{{data.get(0)}};
    }
}
