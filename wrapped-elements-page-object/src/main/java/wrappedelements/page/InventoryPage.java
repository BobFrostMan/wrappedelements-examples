package wrappedelements.page;

import ua.foggger.annotation.WebElement;
import ua.foggger.wrapper.element.clickable.ClickableElement;
import ua.foggger.wrapper.page.IPage;
import wrappedelements.custom.Button;
import wrappedelements.custom.annotation.ButtonElement;

import java.util.List;


public interface InventoryPage extends IPage {

    @ButtonElement("//*[@class='inventory_item']//button")
    Button addToCartButton();

    @WebElement("//*[@class='inventory_item']//button")
    List<ClickableElement> addToCartButtons();

}
