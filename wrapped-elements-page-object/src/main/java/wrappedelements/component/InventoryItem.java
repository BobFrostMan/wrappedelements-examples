package wrappedelements.component;


import ua.foggger.annotation.WebComponent;
import ua.foggger.wrapper.block.WrappedComponent;
import ua.foggger.wrapper.element.impl.ClickableElement;
import wrappedelements.custom.Button;
import wrappedelements.custom.annotation.ButtonElement;

public interface InventoryItem extends WrappedComponent {

    @WebComponent(".//div[@class='inventory_item_name']")
    ClickableElement itemNameLabel();

    @WebComponent(".//div[@class='inventory_item_price']")
    ClickableElement priceLabel();

    @ButtonElement(".//div[@class='pricebar']//button")
    Button addToCartButton();


}
