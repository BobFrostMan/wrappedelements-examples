package wrappedelements.component;


import io.github.bobfrostman.annotation.WebElement;
import io.github.bobfrostman.wrapper.block.WrappedComponent;
import io.github.bobfrostman.wrapper.element.impl.ClickableElement;
import wrappedelements.custom.Button;
import wrappedelements.custom.annotation.ButtonElement;

public interface InventoryItem extends WrappedComponent {

    @WebElement(".//div[contains(@class, 'inventory_item_name')]")
    ClickableElement itemNameLabel();

    @WebElement(".//div[@class='inventory_item_price']")
    ClickableElement priceLabel();

    @ButtonElement(".//div[@class='pricebar']//button")
    Button addToCartButton();

}
