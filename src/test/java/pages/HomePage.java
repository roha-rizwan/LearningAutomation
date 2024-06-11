package pages;


import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;

    @FindBy(how = How.ID, using = "gh-ac")
    private WebElement searchBox;
    @FindBy(how = How.ID, using = "gh-btn")
    private WebElement searchButton;
    @FindBy(how = How.CLASS_NAME, using = "product-name")
    private WebElement productName;
    @FindBy(how = How.ID, using = "gh-la")
    private WebElement logo;
    @FindBy(how = How.CLASS_NAME, using = "gh-cart-icon")
    private WebElement cartIcon;
    @FindBy(how = How.XPATH, using = "//h2[contains(normalize-space(),'Your Recently Viewed Items')]/ancestor::div[@class='vl-card-header']")
    private WebElement yourRecentlyViewedItemsHeading;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void perform_Search(String search) {
        driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl() + "/?s=" + search + "&post_type=product");
    }

    public void navigateTo_HomePage() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public void enterSearchKey(String key)
    {
        searchBox.clear();
        searchBox.sendKeys(key);
    }

    public void clickCartIcon() { cartIcon.click(); }

    public String getProductName()
    {
        return productName.getText().split("-")[0].trim();
    }

    public void clickSearchButton()
    {
        searchButton.click();
    }
    public void clickLogo() {logo.click();
    }

    public boolean verifyItemIsListedOnRecentlyViewedItems(String item)
    {
        List<WebElement> recentlyViewedItems = driver.findElements
                (By.xpath("//h2[contains(normalize-space(),'Your Recently Viewed Items')]/ancestor::div[@class='vl-card-header']/following-sibling::div//h3"));

        for (WebElement recentlyViewedItem : recentlyViewedItems)
        {
            if (recentlyViewedItem.getText().toLowerCase().contains(item)) {
                return true;
            }
        }
        return false;
    }

}

