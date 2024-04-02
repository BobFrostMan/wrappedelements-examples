package step;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bobfrostman.config.WrappedElements;
import org.junit.Assert;
import wrappedelements.page.InventoryPage;

public class InventorySteps {

    private InventoryPage inventoryPage;

    public InventorySteps() {
        inventoryPage = WrappedElements.initPage(InventoryPage.class);
    }

    @When("user adds to cart {string} item on Inventory page")
    public void userAddsToCartItemOnInventoryPage(String name) {
        inventoryPage.inventoryItem(name).addToCartButton().click();
    }

    @When("user clicks on basket button on Inventory page")
    public void userClicksOnBasketButton() {
       inventoryPage.header().basket().basketButton().click();
    }

    @Then("user see {int} notifications on the basket icon on Inventory page")
    public void userAddsToCartItemOnInventoryPage(int notificationsCount) {
        String text = inventoryPage.header().basket().notificationsCountLabel().getText();
        Assert.assertEquals("Basket element should have 1 notification label", Integer.parseInt(text), notificationsCount);
    }

    @Then("user redirected to Cart page")
    public void userRedirectedToInventoryPage(){
        Assert.assertEquals(WrappedElements.getDriver().getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    }

}
