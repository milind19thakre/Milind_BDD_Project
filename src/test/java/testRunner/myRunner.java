package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {".//Features/2_DashboardFeature.feature"},
        glue = "stepDefinations",
        tags = "@Mvt",
        dryRun = false,
        plugin = {
                "pretty",// prints Gherkin steps in console
                "html:target/cucumber-reports.html", // HTML report
                "json:target/cucumber.json",        // JSON report
                "junit:target/cucumber.xml"
        }
)

public class myRunner extends AbstractTestNGCucumberTests {



}
