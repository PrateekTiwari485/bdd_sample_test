package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    public WebDriver ldriver;

    public CartPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(xpath="//h2[contains(text(),'Shopping Cart')]")
    @CacheLookup
    WebElement pageTitle;

    @FindBy(id="nav-cart-count")
    @CacheLookup
    WebElement productCount;

    public String getProductCount(){
        Wait<WebDriver> wait = new WebDriverWait(ldriver, 30);
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return productCount.getText();
    }
}
