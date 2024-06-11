package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CartPage;
import pages.HomePage;

import java.util.List;
import java.util.Map;
//import pages.CartPage;

public class CartPageSteps {

    TestContext testContext;

    HomePage homePage;
    CartPage cartPage;

    public CartPageSteps(TestContext context) {
        testContext = context;
        cartPage = testContext.getPageObjectManager().getCartPage();
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Then("the user reviews the cart with below list")
    public void theUserReviewsTheCartWithBelowList(DataTable dataTable) {

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        homePage.clickCartIcon();

        for (Map<String, String> row : rows) {
            boolean isItemInCart = cartPage.isItemAvailableInCart(row.get("Item"));
            Assert.assertTrue("Item "+ row.get("Item")+" is not available in cart", isItemInCart);
        }

        Assert.assertTrue("Count of items do not match.",cartPage.getItemCount(rows.size()));
    }
}
