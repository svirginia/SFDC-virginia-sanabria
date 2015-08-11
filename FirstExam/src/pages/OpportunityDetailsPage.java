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
public class OpportunityDetailsPage extends DetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "opp3_ileinner")
    @CacheLookup
    private WebElement opportunityName;

    @FindBy(id = "opp9_ileinner")
    @CacheLookup
    private WebElement closeDate;

    @FindBy(id = "opp11_ileinner")
    @CacheLookup
    private WebElement stage;

    @FindBy(id = "opp4_ileinner")
    @CacheLookup
    private WebElement accountName;

    public OpportunityDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public String getOpportunityName() {
        return opportunityName.getText();
    }

    public String getCloseDateValue() {
        return closeDate.getText();
    }


    public String getStageValue() {
        return stage.getText();
    }

    public String getAccountName() {
        return accountName.getText();
    }
}
