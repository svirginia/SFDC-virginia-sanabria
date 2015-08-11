package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Virginia Sanabria on 8/10/2015.
 */
public class OpportunityForm {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "opp3")
    @CacheLookup
    private WebElement opyNameTxt;

    @FindBy(id = "opp9")
    @CacheLookup
    private WebElement closeDateTxt;

    @FindBy(id = "opp11")
    @CacheLookup
    private WebElement stageComBox;

    @FindBy(css = "img[title *= 'Account Name Lookup']")
    @CacheLookup
    private WebElement lookupIcon;


    @FindBy(css = ".pbHeader input[title = 'Save']")
    @CacheLookup
    private WebElement saveBtn;

    public OpportunityForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);

    }

    public OpportunityForm setOpyName(String opyName) {
        wait.until(ExpectedConditions.visibilityOf(opyNameTxt));
        opyNameTxt.clear();
        opyNameTxt.sendKeys(opyName);
        return this;
    }

    public OpportunityForm setCloseDate(String closeDate) {
        wait.until(ExpectedConditions.visibilityOf(closeDateTxt));
        closeDateTxt.clear();
        closeDateTxt.sendKeys(closeDate);
        return this;
    }

    public OpportunityForm selectStage(String stageName) {
        Select select = new Select(stageComBox);
        select.selectByVisibleText(stageName);
        return this;
    }

    public OpportunityForm selectAccount(String accountName) {
        String windowID = driver.getWindowHandle();
        System.out.println("main window" + windowID);
        lookupIcon.click();

        Set<String> setWindows = driver.getWindowHandles();
        LinkedList<String> listWindows = new LinkedList<>(setWindows);
        System.out.println("Windows ->" + listWindows.size() + ":" + listWindows.getLast() + "ALL:" + listWindows);
        driver.switchTo().window(listWindows.getLast());

        LookupPage lookupPage = new LookupPage(driver);
        lookupPage.searchByAccountName(accountName);
        lookupPage.clickAccountName(accountName);

        driver.switchTo().window(windowID);
        return this;
    }

    public OpportunityDetailsPage clickSaveBtn() {
        saveBtn.click();
        return new OpportunityDetailsPage(driver);
    }
}
