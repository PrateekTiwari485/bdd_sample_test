package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.DashboardPage;
import pageObject.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    public WebDriver driver;
    public LoginPage lp;
    public DashboardPage dsp;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver","C://Users//prateek.tiwari//IdeaProjects//bdd_sample_test//src//main//Driver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Given("I navigate to {string}")
    public void i_navigate_to(String string) {
       /* System.setProperty("webdriver.chrome.driver","C://Users//prateek.tiwari//IdeaProjects//bdd_sample_test//src//main//Driver//chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();*/
        driver.get(string);
    }

    @When("I enter user as {string} and password as {string}")
    public void i_enter_user_as_and_password_as(String user, String pwd) {
        lp = new LoginPage(driver);
        lp.setUser(user);
        lp.setPassword(pwd);
    }

    @When("I click on login")
    public void i_click_on_login() throws InterruptedException {
        lp = new LoginPage(driver);
        lp.clickLogin();
    }

    @Then("I navigated to the dashboard page where title is {string}")
    public void i_navigated_to_the_dashboard_page_where_title_is(String string) {
        dsp = new DashboardPage(driver);
        Assert.assertTrue(dsp.getTitle().equalsIgnoreCase(string));
    }

    @When("I click on logout")
    public void i_click_on_logout() {
        dsp = new DashboardPage(driver);
        dsp.clickLogout();
    }

    @Then("I navigated to the login page where title is {string}")
    public void i_navigated_to_the_login_page_where_title_is(String string) {
        lp = new LoginPage(driver);
        Assert.assertTrue(lp.getTitle().equalsIgnoreCase(string));
    }
}
