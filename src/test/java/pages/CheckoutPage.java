package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#address-ui-widgets-enterAddressFullName")
    WebElement fullNameField;
    @FindBy(css = "#address-ui-widgets-enterAddressPhoneNumber")
    WebElement phoneNumberField;
    @FindBy(css = "#address-ui-widgets-enterAddressLine1")
    WebElement addressLine;
    @FindBy(css = "#address-ui-widgets-enterAddressPostalCode")
    WebElement postalCode;
    @FindBy(css = "#address-ui-widgets-enterAddressCity-dropdown-nativeId")
    WebElement selectCityDropDown;
    @FindBy(css = "#address-ui-widgets-form-submit-button")
    WebElement submitDataButton;
    @FindBy(css = "div[class='a-column a-span12'] span[class='a-size-medium a-text-bold']")
            WebElement waitForTextVisible;






    public void addThePersonalDataAndAddress(String fullName, String phoneNumber, String deliveryAddress, String zipCode) {
        fullNameField.sendKeys(fullName);
        phoneNumberField.sendKeys(phoneNumber);
        addressLine.sendKeys(deliveryAddress);
        postalCode.sendKeys(zipCode);
    }
    public void selectTheCityAndSubmit() {
        waitForWebElementToBeClickable(selectCityDropDown);
        Select dropDown = new Select(selectCityDropDown);
        dropDown.selectByVisibleText("Warsaw");
        submitDataButton.click();
    }
    public void waitForMethodsOfPaymentLoad(){
        waitForWebElementToAppear(waitForTextVisible);
    }
    public String getTextOfMyPaymentMethods(){
        return waitForTextVisible.getText();
    }

}
