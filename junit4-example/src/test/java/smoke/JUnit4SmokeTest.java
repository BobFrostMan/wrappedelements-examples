package smoke;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ua.foggger.config.WrappedElements;
import wrappedelements.custom.Button;
import wrappedelements.custom.ButtonDecorator;
import wrappedelements.page.InventoryPage;
import wrappedelements.page.LoginPage;


import java.time.Duration;

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
                .registerDecorator(Button.class, new ButtonDecorator());
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
    public void simpleUIInteraction2Test() {
        loginPage.loginInput().sendKeys("standard_user");
        loginPage.passwordInput().sendKeys("secret_sauce");
        loginPage.loginButton().click();
        inventoryPage.addToCartButton().click();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", WrappedElements.getDriver().getCurrentUrl());
    }


    @After
    public void tearDown() {
        if (WrappedElements.getDriver() != null) {
            WrappedElements.getDriver().quit();
        }
    }

}