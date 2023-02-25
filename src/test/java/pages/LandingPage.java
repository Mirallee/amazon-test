package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.AbstractComponents;

import java.util.List;

public class LandingPage extends AbstractComponents {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#nav-link-accountList-nav-line-1")
    WebElement loginButton;
    @FindBy(css = "#ap_email")
    WebElement userEmail;
    @FindBy(css = "#ap_password")
    WebElement userPassword;
    @FindBy(css = ".a-list-item")
    WebElement wrongDataMessage;
    @FindBy(css = "#nav-your-amazon-text")
    WebElement myAmazonButton;
    @FindBy(css = "#sp-cc-accept")
    WebElement cookiesButton;
    @FindBy(css = "#nav-cart-count-container")
    WebElement goToCartPageButton;
    @FindBy(css = "#twotabsearchtextbox")
    WebElement searchField;

    public void searchForProduct() {
        searchField.sendKeys("U Nk Perf Stirrup-Team" + Keys.ENTER);
    }

    public void clickCartPageButton() {
        goToCartPageButton.click();
    }

    public void clickAcceptCookiesButton() {
        cookiesButton.click();
    }

    public void clickMyAmazonButton() {
        waitForWebElementToAppear(myAmazonButton);
        myAmazonButton.click();
    }

    public void goTo() {
        driver.get("https://www.amazon.pl/");
    }

    public void loginApplication(String email, String password) {
        loginButton.click();
        userEmail.sendKeys(email + Keys.ENTER);
        userPassword.sendKeys(password + Keys.ENTER);
    }

    public void loginWithWrongEmail(String email) {
        loginButton.click();
        userEmail.sendKeys(email + Keys.ENTER);
    }

    public void loginWithCorrectEmailButWrongPasswordValidation(String email, String password) {
        loginButton.click();
        userEmail.sendKeys(email + Keys.ENTER);
        userPassword.sendKeys(password + Keys.ENTER);
    }

    public String getErrorMessage() {
        return wrongDataMessage.getText();
    }
}
