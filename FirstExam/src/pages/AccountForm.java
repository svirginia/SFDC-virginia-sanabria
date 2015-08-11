package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Virginia Sanabria on 8/10/2015.
 */
public class AccountForm extends BasicForm{
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "acc2")
    @CacheLookup
    private WebElement accountNameTxt;

    public AccountForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public AccountForm setAccountName(String accountName) {
        wait.until(ExpectedConditions.visibilityOf(accountNameTxt));
        accountNameTxt.clear();
        accountNameTxt.sendKeys(accountName);
        return this;
    }

    public AccountDetailsPage clickSaveBtn() {
        super.saveBtn.click();
        return new AccountDetailsPage(driver);
    }
}
