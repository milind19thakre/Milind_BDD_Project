package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.DashboardPage;
import utilities.DriverManager;

public class Logout_sd {

    WebDriver driver;
    public DashboardPage dp;

    public Logout_sd() {

            this.driver = DriverManager.getDriver();
            dp = new DashboardPage(driver);

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
