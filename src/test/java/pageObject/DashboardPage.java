package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage{
    public WebDriver ldriver;

    public DashboardPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath="//*[@class='oxd-userdropdown-tab']")
    @CacheLookup
    WebElement ddlUser;

    @FindBy(xpath="//a[text()='Logout']")
    @CacheLookup
    WebElement linkLogout;

    public String getTitle(){
        return ldriver.getTitle();
    }
    public void clickLogout(){
        ddlUser.click();
        Wait<WebDriver> wait = new WebDriverWait(ldriver, 30);
        wait.until(ExpectedConditions.visibilityOf(linkLogout));
        linkLogout.click();
    }
}
