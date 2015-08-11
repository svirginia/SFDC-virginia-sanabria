package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Virginia Sanabria on 8/10/2015.
 */
public class LookupPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "lksrch")
    @CacheLookup
    private WebElement searchTxt;

    @FindBy(css = "input[title='Go!']")
    @CacheLookup
    private WebElement goBtn;

    public LookupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void searchByAccountName(String accountName) {
        driver.switchTo().frame(driver.findElement(By.id("searchFrame")));
        searchTxt.clear();
        searchTxt.sendKeys(accountName);
        goBtn.click();
        driver.switchTo().defaultContent();
    }

    public void clickAccountName(String accountName) {
        driver.switchTo().frame(driver.findElement(By.id("resultsFrame")));
        driver.findElement(By.linkText(accountName)).click();
 //       driver.switchTo().defaultContent();
    }
}
