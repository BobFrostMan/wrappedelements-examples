package wrappedelements.component;

import ua.foggger.annotation.WebComponent;
import ua.foggger.wrapper.block.WrappedComponent;

import java.util.List;

public interface InventoryItemList extends WrappedComponent {

    @WebComponent(".inventory_item")
    List<InventoryItem> inventoryItems();
}
