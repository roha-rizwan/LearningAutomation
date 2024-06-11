package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ResultsListPage;

import java.time.Duration;

public class SearchResultsPageSteps {
    TestContext testContext;
    Wait<WebDriver> wait;
    ResultsListPage resultsListPage;

    public SearchResultsPageSteps(TestContext context) {
        testContext = context;
        resultsListPage = testContext.getPageObjectManager().getResultsListPage();
        //itemDetailsPage = testContext.getPageObjectManager().getItemDetailsPage();
        wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(), Duration.ofSeconds(10));
    }
    @And("he views the top result")
    public void heViewsTheTopResult() {
        resultsListPage.clickTopResult();
        testContext.getGenericUtils().switchWindowToChild();
    }
}
