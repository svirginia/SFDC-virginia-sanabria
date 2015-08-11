package pages;

import org.openqa.selenium.By;
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
public class OpportunitiesPage extends BasicPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public OpportunitiesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public OpportunityForm clickNewBtn() {
        super.newBtn.click();
        return new OpportunityForm(driver);
    }

    public OpportunityDetailsPage openDetailsPage(String opportunityName) {
        driver.findElement(By.linkText(opportunityName)).click();
        return new OpportunityDetailsPage(driver);
    }
}
