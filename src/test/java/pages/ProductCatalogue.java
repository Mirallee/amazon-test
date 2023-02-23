package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.AbstractComponents;

import java.util.List;

public class ProductCatalogue extends AbstractComponents {
    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "input[name='submit.addToCart']")
            WebElement addToCart;
    @FindBy(css = ".a-button-text[href='/gp/cart/view.html?ref_=sw_gtc']")
    WebElement goToCartPageButton;
    @FindBy(css = ".a-column.a-span12.a-text-center._cDEzb_grid-column_UjCjt.p13n-grid-column-root")
    List<WebElement> products;
    By productsBy = By.cssSelector(".a-column.a-span12.a-text-center._cDEzb_grid-column_UjCjt.p13n-grid-column-root");
    By clickOnProduct = By.cssSelector(".p13n-sc-uncoverable-faceout");

    public List <WebElement> getProductList(){
        waitForElementToAppear(productsBy);
        return products;
    }
    public WebElement getProductByName(String productName)
    {
        WebElement prod = getProductList().stream().filter(product->
                product.findElement(By.cssSelector("div[class*='p13n-sc-truncate-desktop-type2  p13n-sc-truncated']")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }
    public void addProductToCart(String productName)
    {
        WebElement prod = getProductByName(productName);
        prod.findElement(clickOnProduct).click();
        addToCart.click();
        goToCartPageButton.click();
    }
}
