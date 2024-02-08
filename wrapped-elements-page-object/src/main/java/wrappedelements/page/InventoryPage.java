package wrappedelements.page;

import ua.foggger.annotation.Parameter;
import ua.foggger.annotation.WebComponent;
import ua.foggger.annotation.WebElement;
import ua.foggger.wrapper.element.impl.ClickableElement;
import wrappedelements.component.InventoryItem;
import wrappedelements.custom.Button;
import wrappedelements.custom.annotation.ButtonElement;

import java.util.List;


public interface InventoryPage extends BaseSauceLabsLoggedInPage {

    @WebComponent("//*[contains(text(), '${itemName}')]/ancestor::*[@class='inventory_item']")
    InventoryItem inventoryItem(@Parameter("itemName") String inventoryItemName);

    @WebComponent("//*[@class='inventory_item']")
    List<InventoryItem> inventoryItems();

    @ButtonElement("//*[@class='inventory_item']//button")
    Button addToCartButton();

    @WebElement("//*[@class='inventory_item']//button")
    List<ClickableElement> addToCartButtons();



}
