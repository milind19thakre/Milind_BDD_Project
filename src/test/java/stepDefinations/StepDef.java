package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utilities.DriverManager;

import java.time.Duration;

import static utilities.DriverManager.driver;

public class StepDef {


    public LoginPage lp;
    public DashboardPage dp;
    //public String ex_logout_url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";


    @Given("user launch chrome browser")
    public void userLaunchChromeBrowser() {

        lp = new LoginPage(driver);
        dp = new DashboardPage(driver);
    }

    @When("user opens url {string}")
    public void userOpensUrl(String url) {
        driver.get(url);
    }

    @And("user enters userid as {string} and password as {string}")
    public void userEntersUseridAsAndPasswordAs(String userid, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        lp.enter_username(userid);
        lp.enter_password(password);
    }

    @And("click on login")
    public void clickOnLogin() {
        lp.click_login();
    }

    @Then("page title should be {string}")
    public void pageTitleShouldBe(String expectedtitle) {
        String actualtitle =  driver.getTitle();
        if (expectedtitle.equals(actualtitle)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @And("close browser")
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }




    @Then("validate {} on dashboard")
    public void validateOnDashboard(String elementName) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Build dynamic xpath using text
        String xpath = "//*[text()='" + elementName + "']";
        WebElement element =  driver.findElement(By.xpath(xpath));
        Assert.assertTrue("Element not displayed: " + elementName, element.isDisplayed());
    }


    @And("click on userdropdown icon")
    public void clickOnUserdropdownIcon() {

        dp.click_user_dropdown();

    }

    @And("click on logout")
    public void clickOnLogout()  {

        dp.click_logout();

    }

    @Then("the ex_logout_url should be {string}")
    public void theUrlShouldBe(String ex_logout_url)  {

        String ac_logout_url =  driver.getCurrentUrl();

//        if (ex_logout_url.equals(ac_logout_url)) {
//            Assert.assertTrue(true);
//        } else {
//            Assert.assertTrue(false);
//        }

        System.out.println(ac_logout_url);
        System.out.println(ex_logout_url);
        Assert.assertEquals("Logout URL mismatch!", ex_logout_url, ac_logout_url);
       }
    }





