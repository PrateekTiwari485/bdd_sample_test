package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver ldriver;

    public LoginPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(name="username")
    @CacheLookup
    WebElement inputUserName;

    @FindBy(name="password")
    @CacheLookup
    WebElement inputPassword;

    @FindBy(xpath="//*[contains(@class,'login-button')]")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath="//*[text()='Account disabled']")
    @CacheLookup
    WebElement txtAccountDisabled;

    public String getTitle(){
        return ldriver.getTitle();
    }
    public void setUser(String user){
        inputUserName.clear();
        inputUserName.sendKeys(user);
    }
    public void setPassword(String pwd){
        inputPassword.clear();
        inputPassword.sendKeys(pwd);
    }
    public void clickLogin() {
        btnLogin.click();
    }

    public boolean isAccountDiasabled(){
        return txtAccountDisabled.isDisplayed();
    }
}
