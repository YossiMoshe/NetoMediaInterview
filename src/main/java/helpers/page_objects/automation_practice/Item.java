package helpers.page_objects.automation_practice;

import helpers.page_objects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Item extends BasePage {

    private static final By PRICE = By.xpath(".//span[contains(@class,'price')]");
    private static final By OLD_PRICE = By.xpath(".//span[contains(@class,'old-price')]");
    private static final By REDUCTION = By.xpath(".//span[@class='price-percent-reduction']");
    private static final By ADD_TO_CART = By.xpath(".//a[contains(@class,'ajax_add_to_cart_button')]");
    private static final By RIGHT_BLOCK = By.className("right-block");
    public WebElement itemElement;

    public Item(WebElement itemElement) {
        this.itemElement = itemElement;
    }

    public void addItemToCart() {
        hoverItem();
        click(itemElement.findElement(ADD_TO_CART));
    }

    public float getReduction() {
        return convertToNumber(itemElement.findElement(RIGHT_BLOCK).findElement(REDUCTION).getText());
    }

    public float getPrice() {
        return convertToNumber(itemElement.findElement(RIGHT_BLOCK).findElement(PRICE).getText());
    }

    public float getOldPrice() {
        return convertToNumber(itemElement.findElement(RIGHT_BLOCK).findElement(OLD_PRICE).getText());
    }

    private float convertToNumber(String price) {
        return Float.parseFloat(price.replaceAll("[^0-9,.]",""));
    }

    private void hoverItem() {
        moveToElement(itemElement);
    }
}
