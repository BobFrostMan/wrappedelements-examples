package smoke;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bobfrostman.config.WrappedElements;
import wrappedelements.component.InventoryItem;
import wrappedelements.custom.Button;
import wrappedelements.custom.ButtonAnnotationProcessor;
import wrappedelements.page.InventoryPage;
import wrappedelements.page.LoginPage;


import java.time.Duration;
import java.util.List;

public class JUnit4SmokeTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeClass
    public static void setUp() {
        WrappedElements.config()
                .driverCreator(() -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setImplicitWaitTimeout(Duration.ofSeconds(10));
                    return new ChromeDriver();
                })
                .registerAnnotationProcessor(Button.class, new ButtonAnnotationProcessor());
    }

    @Before
    public void beforeMethod() {
        WrappedElements.getDriver().get("https://www.saucedemo.com/");
        loginPage = WrappedElements.initPage(LoginPage.class);
        inventoryPage = WrappedElements.initPage(InventoryPage.class);
    }

    @Test
    public void simpleUIInteractionTest() {
        loginPage.loginInput().sendKeys("standard_user");
        loginPage.passwordInput().sendKeys("secret_sauce");
        loginPage.loginButton().click();

        Assert.assertEquals("https://www.saucedemo.com/inventory.html", WrappedElements.getDriver().getCurrentUrl());
    }

    @Test
    public void nestedComponentsInteractionsTest() {
        loginPage.loginInput().sendKeys("standard_user");
        loginPage.passwordInput().sendKeys("secret_sauce");
        loginPage.loginButton().click();

        inventoryPage.inventoryItem("Sauce Labs Fleece Jacket").addToCartButton().click();
        String text = inventoryPage.header().basket().notificationsCountLabel().getText();
        Assert.assertEquals("Basket element should have 1 notification label", Integer.parseInt(text), 1);
        inventoryPage.header().basket().basketButton().click();
        Assert.assertEquals(WrappedElements.getDriver().getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    }

    @Test
    public void listNestedComponentsInteractionsTest() {
        loginPage.loginInput().sendKeys("standard_user");
        loginPage.passwordInput().sendKeys("secret_sauce");
        loginPage.loginButton().click();

        List<InventoryItem> items = inventoryPage.inventoryItems();
        InventoryItem item = items.get(3);
        item.priceLabel().getText();
        List<InventoryItem> items2 = inventoryPage.inventoryItemList().inventoryItems();
        InventoryItem item2 = items2.get(3);
        item2.priceLabel().getText();
        item2.addToCartButton().click();
        Assert.assertEquals(item.itemNameLabel().getText(), "Sauce Labs Fleece Jacket");
    }


    @After
    public void tearDown() {
        if (WrappedElements.getDriver() != null) {
            WrappedElements.getDriver().quit();
        }
    }

}