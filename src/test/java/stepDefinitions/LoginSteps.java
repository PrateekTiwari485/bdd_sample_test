package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObject.DashboardPage;
import pageObject.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    public WebDriver driver;
    public LoginPage lp;
    public DashboardPage dsp;
    public static Logger log;
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver","C://Users//prateek.tiwari//IdeaProjects//bdd_sample_test//src//main//Driver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Before
    public void initLogger() {
        log= (Logger) LogManager.getLogger(LoginSteps.class);
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
    }

    @Given("I navigate to {string}")
    public void i_navigate_to(String string) {
       /* System.setProperty("webdriver.chrome.driver","C://Users//prateek.tiwari//IdeaProjects//bdd_sample_test//src//main//Driver//chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();*/
        driver.get(string);
        log.info("Successfully navigated to the URL "+string);
    }

    @When("I enter user as {string} and password as {string}")
    public void i_enter_user_as_and_password_as(String user, String pwd) {
        lp = new LoginPage(driver);
        lp.setUser(user);
        lp.setPassword(pwd);
        log.info("Entered login credentials");
    }

    @When("I click on login")
    public void i_click_on_login() throws InterruptedException {
        lp = new LoginPage(driver);
        lp.clickLogin();
        log.info("Clicked login button");
    }

    @Then("I navigated to the dashboard page where title is {string}")
    public void i_navigated_to_the_dashboard_page_where_title_is(String string) {
        dsp = new DashboardPage(driver);
        Assert.assertTrue(dsp.getTitle().equalsIgnoreCase(string));
        log.info("User navigated to the dashboard");
    }

    @When("I click on logout")
    public void i_click_on_logout() {
        dsp = new DashboardPage(driver);
        dsp.clickLogout();
        log.info("User clicked on logout");
    }

    @Then("I navigated to the login page where title is {string}")
    public void i_navigated_to_the_login_page_where_title_is(String string) {
        lp = new LoginPage(driver);
        Assert.assertTrue(lp.getTitle().equalsIgnoreCase(string));
        log.info("User logout successfully");
        ExtentTest test = extent.createTest("Logout and back to login page");
        test.log(Status.PASS,"User logged out successfully");
        test.pass("User logout verified");
    }
}
