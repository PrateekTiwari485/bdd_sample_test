package testRunner;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//prateek.tiwari//IdeaProjects//bdd_sample_test//src//test//features//Login.feature",
        glue = "stepDefinitions",
        plugin = { "pretty", "html:target/HtmlReports/reports.html"}
        //plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class testRunner extends AbstractTestNGCucumberTests {
}
