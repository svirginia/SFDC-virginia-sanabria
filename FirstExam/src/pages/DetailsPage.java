package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Virginia Sanabria on 8/10/2015.
 */
public abstract class DetailsPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = ".pbHeader input[title = 'Delete']")
    @CacheLookup
    protected WebElement deleteBtn;

    public void clickDeleteBtn() {
        System.out.println("deleting");
        wait.until(ExpectedConditions.elementToBeClickable(this.deleteBtn));
        deleteBtn.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
