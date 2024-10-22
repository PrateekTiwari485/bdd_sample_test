package pageObject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.gson.annotations.Until;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepDefinitions.LoginSteps;
import utility.Utility;

import java.time.Duration;
import java.util.List;

public class HomePage {
    public WebDriver ldriver;
    public Utility ut;

    public HomePage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath="//img[@title='Flipkart']")
    @CacheLookup
    WebElement logo;

    @FindBy(xpath="//input[@title='Search for Products, Brands and More']")
    @CacheLookup
    WebElement searchBox;

    public boolean isLogoDisplayed(){
        /*Wait<WebDriver> wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
        wait.until(d -> logo.isDisplayed());*/
        /*Wait<WebDriver> wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(logo));*/
        return logo.isDisplayed();
    }

    public void isAllCategoriesDisplayed(DataTable dataTable){
        List<String> categories = dataTable.asList();
        Wait<WebDriver> wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
        wait.until(d -> ldriver.findElement(By.xpath("//a[@aria-label='"+categories.get(0)+"']")).isDisplayed());
        for (String category : categories) {
            Assert.assertTrue(ldriver.findElement(By.xpath("//a[@aria-label='" + category + "']//span[text()='" + category + "']")).isDisplayed());
        }
    }

    public void selectCategory(String category){
        Wait<WebDriver> wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
        wait.until(d -> ldriver.findElement(By.xpath("//a[@aria-label='"+category+"']")).isDisplayed());
        ldriver.findElement(By.xpath("//a[@aria-label='"+category+"']")).click();
    }

    public String getPageTitle(){
        Wait<WebDriver> wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
        wait.until(d -> ldriver.getTitle());
        return ldriver.getTitle();
    }

    public void setSearchBoxInput(String item){
        searchBox.sendKeys(item,Keys.ENTER);
    }

}
