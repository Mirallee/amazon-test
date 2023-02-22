package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.AbstractComponents;

public class CartPage extends AbstractComponents {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".a-dropdown-prompt")
    WebElement quanityBox;
    @FindBy(css = "#quantity_4")
    WebElement select4ProductsInQuanityBox;
    @FindBy(css = "#sc-subtotal-label-activecart")
    WebElement getAmountOfProductsInCart;
    @FindBy(css = "span[class='a-size-small sc-action-delete'] span[class='a-declarative']")
    WebElement deleteProduct;
    @FindBy(css = "div[data-action='delete'] a[class='a-link-normal sc-product-link']")
    WebElement messageOfProductDelete;

    public void editAmountOfProduct() throws InterruptedException {
        quanityBox.click();
        select4ProductsInQuanityBox.click();
        Thread.sleep(1000);

    }
    public String getTextOfAmountCartProducts() {
        return getAmountOfProductsInCart.getText();
    }
    public void deleteProductFromCart() {
        deleteProduct.click();
    }
    public String getMessageOfProductIsDeleted(){
        return messageOfProductDelete.getText();
    }
}