package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.HomePage;

import java.time.Duration;
import java.util.List;

public class ProductSearchSteps {
    public HomePage homePage;
    public WebDriver driver = LoginSteps.getDriver();
    public static Logger log;
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");

    @When("I entered {string} in search box and enter")
    public void i_entered_in_search_box_and_enter(String string) {
        homePage = new HomePage(driver);
        homePage.setSearchBoxInput(string);
    }

    @Then("I navigated to the page contains title {string}")
    public void i_navigated_to_the_page_contains_title(String string) {
        homePage = new HomePage(driver);
        //homePage.pageTitlePresent(string);
        Assert.assertTrue(homePage.getPageTitle().contains(string));
    }

    @Then("I can see below filters present for search results")
    public void i_can_see_below_filters_present_for_search_results(io.cucumber.datatable.DataTable dataTable) {
        List<String> filters = dataTable.asList();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(d -> driver.findElement(By.xpath("//div[text()='"+filters.get(0)+"']")).isDisplayed());
        for (String filter : filters) {
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='"+filter+"']")).isDisplayed());
        }
    }
}
