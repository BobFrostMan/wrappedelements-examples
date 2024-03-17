package wrappedelements.component;


import ua.foggger.annotation.WebElement;
import ua.foggger.wrapper.block.WrappedComponent;
import ua.foggger.wrapper.element.impl.ClickableElement;
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
