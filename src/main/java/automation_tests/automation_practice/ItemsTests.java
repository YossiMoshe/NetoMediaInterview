package automation_tests.automation_practice;

import helpers.page_objects.automation_practice.Item;
import infrastructure.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.text.DecimalFormat;
import static helpers.page_objects.PageObjectManager.mainPage;

public class ItemsTests extends BaseTest {
    private final String URL = "http://automationpractice.com//";

    @Test(description = "Test 2 - Add an item to the cart and verify the discount")
    public void discountValidationTest() {
        String itemName = "Printed Summer Dress";
        browserManager.navigateToUrl(URL);
        Item item = mainPage.homeFeatured.getItem(itemName);
        float price = item.getPrice();
        float oldPrice = item.getOldPrice();
        float reduction = item.getReduction()/100;
        item.addItemToCart();
        float expectedPrice = Float.valueOf(new DecimalFormat("#.00").format(oldPrice*(1-reduction)));

        Assert.assertEquals(expectedPrice,price,"Discount is not calculated correctly");
    }


}
