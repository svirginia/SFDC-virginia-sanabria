package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Virginia Sanabria on 8/10/2015.
 */
public class NavigationTab {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Opportunities")
    @CacheLookup
    private WebElement opportunitiesTab;

    @FindBy(linkText = "Accounts")
    @CacheLookup
    private WebElement accountsTab;

    public NavigationTab(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public OpportunitiesPage goToOpportunitiesTab() {
        opportunitiesTab.click();
        return new OpportunitiesPage(driver);
    }

    public AccountsPage goToAccountsTab() {
        accountsTab.click();
        return new AccountsPage(driver);
    }
}
