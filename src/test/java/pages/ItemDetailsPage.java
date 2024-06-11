package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemDetailsPage {

    WebDriver driver;
    Wait<WebDriver> wait;

    @FindBy(how = How.XPATH, using = "//span[text()='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Go to cart']")
    private WebElement goToCartButton;

    public ItemDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
        wait.until(d -> goToCartButton.isEnabled());
    }

}
