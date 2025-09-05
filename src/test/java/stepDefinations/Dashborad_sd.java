package stepDefinations;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.DashboardPage;
import utilities.DriverManager;

import java.time.Duration;

import static utilities.DriverManager.driver;

public class Dashborad_sd {

    WebDriver driver;
    public DashboardPage dp;

    public Dashborad_sd() {
        this.driver = DriverManager.getDriver();
        dp = new DashboardPage(driver);
    }



    @Then("validate {} on dashboard")
    public void validateOnDashboard(String elementName) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Build dynamic xpath using text
        String xpath = "//*[text()='" + elementName + "']";
        WebElement element =  driver.findElement(By.xpath(xpath));
        Assert.assertTrue("Element not displayed: " + elementName, element.isDisplayed());
    }

    @Then("validate {} left pane")
    public void validateElementsLeftPane(String elementName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        String xpath = "//*[text()='"+ elementName + "']";
        WebElement element_lp = driver.findElement(By.xpath(xpath));
        Assert.assertTrue("Element not displayed" + elementName, element_lp.isDisplayed());
    }

    @Then("click on {} from left pane")
    public void clickOnElementsFromLeftPane(String elementName) {

        String xpath = "//*[text()='" + elementName + "']";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();

    }

    @Then("check {} is present")
    public void checkElementsIsPresent(String elementName) {
        String xpath = "//*[text()='" + elementName + "']";
        WebElement element_btn = driver.findElement(By.xpath(xpath));
        Assert.assertTrue("Element not displayed" + elementName, element_btn.isDisplayed());
    }
}
