package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.AbstractComponents;

import java.util.List;

public class SearchPage extends AbstractComponents {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".s-spacing-small")
    List<WebElement> products;
    @FindBy(css = "#productTitle")
            WebElement productTitle;

    By productsBy = By.cssSelector(".s-spacing-small");
    By clickOnTheSearchProduct = By.cssSelector(".a-text-normal");

    public List<WebElement> getProductList() {
        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductByName(String productName) {
        WebElement prod = getProductList().stream().filter(product ->
                product.findElement(By.cssSelector(".a-text-normal")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }

    public void clickOnSearchedProduct(String productName) {
        WebElement prod = getProductByName(productName);
        prod.findElement(clickOnTheSearchProduct).click();
    }
    public String getProductTitle(){
        return productTitle.getText();
    }
}
