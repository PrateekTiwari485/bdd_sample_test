package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    public WebDriver ldriver;

    public HomePage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath="//*[@placeholder='Search Amazon.in']")
    @CacheLookup
    WebElement searchBox;

    @FindBy(xpath="(//*[text()='Add to cart'])[1]")
    @CacheLookup
    WebElement btn_AddToCart;

    @FindBy(id="nav-cart-count-container")
    @CacheLookup
    WebElement icon_cart;

    public void searchItemByName(String itemName) throws InterruptedException {
        searchBox.clear();
        searchBox.sendKeys(itemName, Keys.ENTER);
        Thread.sleep(8000);
        //Wait<WebDriver> wait = new WebDriverWait(ldriver, 30);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),"+itemName+"')]")));
    }

    public void clickAddToCart() throws InterruptedException {
        Actions act = new Actions(ldriver);
        act.moveToElement(btn_AddToCart).perform();
        btn_AddToCart.click();
        Thread.sleep(5000);
    }

    public void clickCartIcon() throws InterruptedException {
        Actions act = new Actions(ldriver);
        act.moveToElement(icon_cart).perform();
        icon_cart.click();
        Thread.sleep(5000);
    }
}
