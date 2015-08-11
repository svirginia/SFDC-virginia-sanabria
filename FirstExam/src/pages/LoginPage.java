package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Virginia Sanabria on 8/10/2015.
 */
public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @FindBy(id = "username")
    @CacheLookup
    private WebElement userNameTxt;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordTxt;

    @FindBy(id = "Login")
    @CacheLookup
    private WebElement loginBtn;


    public LoginPage() {
        driver = new FirefoxDriver();
        baseUrl = "https://login.salesforce.com/";
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);

    }


    public LoginPage setUserNameTxt(String userName) {
        wait.until(ExpectedConditions.visibilityOf(userNameTxt));
        this.userNameTxt.clear();
        this.userNameTxt.sendKeys(userName);
        return this;
    }

    public LoginPage setPasswordTxt(String password) {
        wait.until(ExpectedConditions.visibilityOf(this.passwordTxt));
        this.passwordTxt.clear();
        this.passwordTxt.sendKeys(password);
        return this;
    }

    public HomePage clickLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(this.loginBtn));
        this.loginBtn.click();
        return new HomePage(driver);
    }
}