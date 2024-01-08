package ua.foggger.testng.page;

import ua.foggger.page.IPage;
import ua.foggger.testng.custom.Button;
import ua.foggger.testng.custom.annotation.ButtonElement;

public interface InventoryPage extends IPage {

    @ButtonElement("//*[@class='inventory_item']//button")
    Button addToCartButton();

}
