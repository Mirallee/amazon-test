package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.AbstractComponents;

public class AccountPage extends AbstractComponents {
    WebDriver driver;
    public AccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "div[class='a-row a-spacing-base'] h1")
    WebElement myAccountText;

    public String getMyAccountMessage(){
        return myAccountText.getText();
    }
}
