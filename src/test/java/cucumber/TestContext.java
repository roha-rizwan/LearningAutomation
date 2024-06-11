package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManager;
import utilities.GenericUtils;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
    private GenericUtils genericUtils;
    public String searchedItem;

    public TestContext(){
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
        genericUtils = new GenericUtils(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
    public GenericUtils getGenericUtils() { return genericUtils; }
}
