package wrappedelements.page;

import ua.foggger.page.IPage;
import wrappedelements.custom.Button;
import wrappedelements.custom.annotation.ButtonElement;


public interface InventoryPage extends IPage {

    @ButtonElement("//*[@class='inventory_item']//button")
    Button addToCartButton();

}
