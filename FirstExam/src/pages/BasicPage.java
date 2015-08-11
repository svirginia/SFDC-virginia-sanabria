package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Virginia Sanabria on 8/10/2015.
 */
public abstract class BasicPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css = "input[title = 'New']")
    @CacheLookup
    protected WebElement newBtn;
}
