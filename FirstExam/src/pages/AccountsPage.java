package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Virginia Sanabria on 8/10/2015.
 */
public class AccountsPage extends BasicPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public AccountForm clickNewBtn() {
        super.newBtn.click();
        return new AccountForm(driver);
    }

    public AccountDetailsPage openDetailsPage(String accountName) {
        driver.findElement(By.linkText(accountName)).click();
        return new AccountDetailsPage(driver);
    }
}