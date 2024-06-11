package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {

    WebDriver driver;
    public GenericUtils(WebDriver webDriver) {
        driver = webDriver;
    }
    public void switchWindowToChild()
    {
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);
    }

    public void switchWindowToParent()
    {
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        driver.switchTo().window(parentWindow);
    }

    public void closeCurrentTab()
    {
        driver.close();
    }
}
