package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Items')]")
    private WebElement itemCount;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isItemAvailableInCart(String item)
    {
        List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='grid-item-title']"));

        for (WebElement cartItem : cartItems)
        {
            if(cartItem.getText().contains(item))
                return true;
        }
        return false;
    }

    public boolean getItemCount(int count)
    {
        String fullTextContainingItemCount = itemCount.getText();
        int countOnly = Integer.parseInt(fullTextContainingItemCount.substring
                (fullTextContainingItemCount.indexOf("(")+1,fullTextContainingItemCount.length()-1));

        return countOnly == count;
    }
}
