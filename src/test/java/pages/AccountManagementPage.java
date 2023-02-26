package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.AbstractComponents;

public class AccountManagementPage extends AbstractComponents {
    WebDriver driver;
    public AccountManagementPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
        @FindBy(css = "div[data-card-identifier='YourOrders']")
                WebElement myOrdersButton;
    @FindBy(css = ".a-section.a-spacing-top-medium.a-text-center")
    WebElement messageOfNoOrdersDisplayed;
    public void clickMyOrdersButton(){
        myOrdersButton.click();
    }
    public String noOrdersInLastThreeMonths(){
        return messageOfNoOrdersDisplayed.getText();
    }


    }

