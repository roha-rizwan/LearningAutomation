package pages;

import cucumber.TestContext;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultsListPage {
    WebDriver driver;
    Wait<WebDriver> wait;

    @FindBy(how = How.XPATH, using = "(//ul/li[contains(@class,'s-item s-item__pl-on-bottom')])[1]//span[@role='heading']")
    private WebElement top1Result;

    public ResultsListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean verifyResultOnTop(String searchedItem)
    {
        return top1Result.getText().toUpperCase().contains(searchedItem.toUpperCase());
    }

    public boolean isResultListDisplayed()
    {
        try {
            wait.until((d -> top1Result.isDisplayed()));
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }

    public void clickTopResult() {
        top1Result.click();
    }
}
