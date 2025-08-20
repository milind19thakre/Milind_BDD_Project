package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

import java.time.Duration;

public class LoginPage{




    public LoginPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

        @FindBy(xpath ="//input[@name='username']")
        WebElement username_txt_xpath;

        @FindBy(xpath ="//input[@name='password']")
        WebElement password_txt_xpath;

        @FindBy(xpath="//button[text()=' Login ']")
        WebElement login_btn_xpath;

        public void enter_username(String username ){
            DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            username_txt_xpath.sendKeys(username);
        }

        public void enter_password(String password){
            DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            password_txt_xpath.sendKeys(password);
        }
        public void click_login(){
            DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            login_btn_xpath.click();
        }





}
