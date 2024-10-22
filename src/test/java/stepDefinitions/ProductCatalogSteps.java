package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.DashboardPage;
import pageObject.HomePage;
import pageObject.LoginPage;

import java.time.Duration;
import java.util.List;

public class ProductCatalogSteps{
    public HomePage homePage;
    public WebDriver driver = LoginSteps.getDriver();
    public static Logger log;
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");

    /*@Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver","C://Users//prateek.tiwari//IdeaProjects//bdd_sample_test//src//main//Driver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Before
    public void initLogger() {
        log= (Logger) LogManager.getLogger(ProductCatalogSteps.class);
    }
    @Before
    public void initExtentReport() {
        extent.attachReporter(spark);
    }

    @After
    public void teardown() {
        driver.quit();
        log.info("Quitting driver");
        extent.flush();
    }*/

    @When("I am at home page")
    public void i_am_at_home_page(){
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLogoDisplayed());
    }

    @Then("I can see below categories listed there")
    public void i_can_see_below_categories_listed_there(io.cucumber.datatable.DataTable dataTable) {
        homePage = new HomePage(driver);
        //homePage.isAllCategoriesDisplayed(dataTable);
        List<String> categories = dataTable.asList();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(d -> driver.findElement(By.xpath("//a[@aria-label='"+categories.get(0)+"']")).isDisplayed());
        for (String category : categories) {
            Assert.assertTrue(driver.findElement(By.xpath("//a[@aria-label='" + category + "']//span[text()='" + category + "']")).isDisplayed());
        }
    }

    @When("I selected {string} in the listed categories")
    public void i_can_select_in_the_listed_categories(String string) {
        homePage = new HomePage(driver);
        homePage.selectCategory(string);
    }

    @Then("I navigated to the page with title {string}")
    public void i_navigated_to_the_page_with_title(String string) {
        homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getPageTitle(),string);
    }
}
