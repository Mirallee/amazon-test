package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utilities.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void loginToAccount(HashMap<String, String> input) {
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
        Assert.assertTrue(messageOfDeletedProducts.equalsIgnoreCase("Koszyk w serwisie Amazon jest pusty."));
    }

    @Test(dataProvider = "getData")
    public void searchFuncionality(HashMap<String, String> input) throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginApplication(input.get("email"), input.get("password"));
        landingPage.searchForProduct();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickOnSearchedProduct(input.get("searchProduct"));
        String productTitleVerify = searchPage.getProductTitle();
        Assert.assertTrue(productTitleVerify.equalsIgnoreCase("Nike U Nk Perf Stirrup-Team"));
    }
    @Test(dataProvider = "getData")
    public void checkoutFuncionality(HashMap<String, String> input) throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginApplication(input.get("email"), input.get("password"));
        landingPage.clickMyAmazonButton();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        productCatalogue.addProductToCart(input.get("product"));
        landingPage.clickCartPageButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnFinalizePurchase();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.addThePersonalDataAndAddress(input.get("fullName"), input.get("phoneNumber"), input.get("streetAndNumber"), input.get("zipCode"));
        checkoutPage.selectTheCityAndSubmit();
        checkoutPage.waitForMethodsOfPaymentLoad();
        String myMethodsPayment = checkoutPage.getTextOfMyPaymentMethods();
        Assert.assertTrue(myMethodsPayment.equalsIgnoreCase("Moje systemy płatności"));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
                + "//src//test//java//utilities//dataFile.json");
        return new Object[][]{{data.get(0)}};
    }
}
