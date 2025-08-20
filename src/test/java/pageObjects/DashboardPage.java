package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;
import java.util.List;
import java.time.Duration;

public class DashboardPage  {



    public DashboardPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath ="(//p[@class='oxd-text oxd-text--p']/parent::div[@class='orangehrm-dashboard-widget-name'])[1]")
    WebElement TimeatWork_xpath;

    @FindBy(xpath ="(//p[@class='oxd-text oxd-text--p']/parent::div[@class='orangehrm-dashboard-widget-name'])[2]")
    WebElement MyActions_xpath;

    @FindBy(xpath ="(//p[@class='oxd-text oxd-text--p']/parent::div[@class='orangehrm-dashboard-widget-name'])[3]")
    WebElement QuickLaunch_xpath;

    @FindBy(xpath ="(//p[@class='oxd-text oxd-text--p']/parent::div[@class='orangehrm-dashboard-widget-name'])[4]")
    WebElement BuzzLatestPosts_xpath;

    @FindBy(xpath ="(//p[@class='oxd-text oxd-text--p']/parent::div[@class='orangehrm-dashboard-widget-name'])[5]")
    WebElement EmployeesonLeaveToday_xpath;

    @FindBy(xpath ="(//p[@class='oxd-text oxd-text--p']/parent::div[@class='orangehrm-dashboard-widget-name'])[6]")
    WebElement EmployeeDistributionbySubUnit_xpath;

    @FindBy(xpath ="(//p[@class='oxd-text oxd-text--p']/parent::div[@class='orangehrm-dashboard-widget-name'])[7]")
    WebElement EmployeeDistributionbyLocation_xpath;

    @FindBy(xpath ="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    WebElement user_dropdown_arrow_xpath;

    @FindBy(xpath ="//ul[@class='oxd-dropdown-menu']")
    WebElement user_dropdown_menu_xpath;

    @FindBy(xpath ="//a[text()='About']")
    WebElement user_dropdown_menu_opt_about_xpath;

    @FindBy(xpath ="//a[text()='Support']")
    WebElement user_dropdown_menu_opt_support_xpath;

    @FindBy(xpath ="//a[text()='Change Pasword']")
    WebElement user_dropdown_menu_opt_changepassword_xpath;

    @FindBy(xpath ="//a[text()='Logout']")
    WebElement user_dropdown_menu_opt_logout_xpath;

    public void click_user_dropdown(){
        DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        user_dropdown_arrow_xpath.click();
    }

    public void click_logout(){
//        DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        List<WebElement> options =  DriverManager.driver.findElements(By.xpath("//a[text()='Logout']"));
//        for (WebElement option : options) {
//            if (option.getText().equals("Logout")) {
//                option.click();
//                break;
//            }
//        }

        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        WebElement logoutOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")));
        logoutOption.click();


    }

}
