package wrappedelements.component;

import io.github.bobfrostman.annotation.WebComponent;
import io.github.bobfrostman.wrapper.block.WrappedComponent;

import java.util.List;

public interface InventoryItemList extends WrappedComponent {

    @WebComponent(".inventory_item")
    List<InventoryItem> inventoryItems();
}
