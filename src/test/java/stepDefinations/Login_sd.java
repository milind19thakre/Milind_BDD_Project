package stepDefinations;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;
import utilities.ConfigReader;

import java.time.Duration;

import static utilities.DriverManager.driver;

public class Login_sd {

    public LoginPage lp;

    @Given("user launch chrome browser")
    public void userLaunchChromeBrowser() {

        lp = new LoginPage(driver);

    }

//    @When("user opens url {string}")
//    public void userOpensUrl(String url) {
//        driver.get(url);
//
//    }

    @When("user opens url")
    public void userOpensUrl() {
        String url = ConfigReader.getProperty("url");
        driver.get(url);
    }





//    @And("user enters userid as {string} and password as {string}")
//    public void userEntersUseridAsAndPasswordAs(String userid, String password) {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        lp.enter_username(userid);
//        lp.enter_password(password);
//    }

    @And("user enters correct userid and password")
    public void userEntersCorrectUseridAndPassword() {
       String userid  = ConfigReader.getProperty("userid");
       String password = ConfigReader.getProperty("password");
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



}
