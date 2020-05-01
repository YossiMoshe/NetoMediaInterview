package helpers.page_objects.automation_practice;

import helpers.page_objects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HomeFeatured extends BasePage {
    public static final By PRODUCT_CONTAINER = By.className("product-container");

    @FindBy(id = "homefeatured")
    public WebElement homeFeatured;


    public List<WebElement> getAllItems() {
        return homeFeatured.findElements(PRODUCT_CONTAINER);
    }

    public Item getItem(String itemName) {
        WebElement itemElement = getAllItems().stream()
                        .filter( i -> i.getText().toLowerCase().contains(itemName.toLowerCase()))
                        .findFirst()
                        .orElse(null);

        if(itemElement != null) {
            return new Item(itemElement);
        } else {
            throw new RuntimeException("Failed to find itemElement: " + itemName);
        }
    }
}
