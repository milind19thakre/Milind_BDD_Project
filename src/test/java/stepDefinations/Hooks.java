package stepDefinations;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.DriverManager;
import utilities.ExtentReportManager;
import com.aventstack.extentreports.Status;
import io.cucumber.java.Scenario;


import java.time.Duration;

public class Hooks {

    static ExtentTest test;

    // driver setup

    @Before
    public void setup(Scenario scenario) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);

        test = ExtentReportManager.getReportInstance().createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
            DriverManager.setDriver(null);
        }
        // extent report setup code
        if (scenario.isFailed()) {
            test.log(Status.FAIL, "Scenario Failed: " + scenario.getName());
        } else {
            test.log(Status.PASS, "Scenario Passed: " + scenario.getName());
        }
        ExtentReportManager.getReportInstance().flush();
    }






}
