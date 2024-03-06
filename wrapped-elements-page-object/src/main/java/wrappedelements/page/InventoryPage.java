package wrappedelements.page;

import ua.foggger.annotation.Parameter;
import ua.foggger.annotation.WebComponent;
import wrappedelements.component.InventoryItem;
import wrappedelements.component.InventoryItemList;

import java.util.List;


public interface InventoryPage extends BaseSauceLabsLoggedInPage {

    @WebComponent("//*[contains(text(), '${itemName}')]/ancestor::*[@class='inventory_item']")
    InventoryItem inventoryItem(@Parameter("itemName") String inventoryItemName);

    @WebComponent("//*[@class='inventory_item']")
    List<InventoryItem> inventoryItems();

    @WebComponent(".inventory_list")
    InventoryItemList inventoryItemList();

}
