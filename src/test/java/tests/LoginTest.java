package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LandingPage;
import pages.ProductCatalogue;
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
    @Test(dataProvider = "getData")
    public void cartFuncionality(HashMap<String, String> input) throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginApplication(input.get("email"), input.get("password"));
        landingPage.clickMyAmazonButton();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        productCatalogue.addProductToCart(input.get("product"));
        landingPage.clickCartPageButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.editAmountOfProduct();
        String amountOfProductsInCart = cartPage.getTextOfAmountCartProducts();
        Assert.assertTrue(amountOfProductsInCart.equalsIgnoreCase("Suma (liczba produktów: 4):"));
        cartPage.deleteProductFromCart();
        String messageOfDeletedProducts = cartPage.getMessageOfProductIsDeleted();
        Assert.assertTrue(messageOfDeletedProducts.equalsIgnoreCase("– przedmiot usunięty z Koszyk."));
    }
    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
                + "//src//test//java//utilities//dataFile.json");
        return new Object[][]{{data.get(0)}};
    }
}
