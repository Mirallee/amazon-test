package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.AbstractComponents;

public class ProductDetailsPage extends AbstractComponents {
    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".a-size-base-plus.a-text-bold")
    WebElement informationAboutProduct;
    @FindBy(css = "tr[class='a-spacing-small po-brand'] span[class='a-size-base po-break-word']")
    WebElement brandNameOfProduct;

    public String verificationOfInformationsAboutProductIsDisplayed(){
        return informationAboutProduct.getText();
    }
    public String getBrandNameOfProduct(){
        return brandNameOfProduct.getText();
    }
}
