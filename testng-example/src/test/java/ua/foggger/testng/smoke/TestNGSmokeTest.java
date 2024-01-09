package ua.foggger.testng.smoke;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.foggger.config.WrappedElements;
import wrappedelements.custom.Button;
import wrappedelements.custom.ButtonDecorator;
import wrappedelements.page.InventoryPage;
import wrappedelements.page.LoginPage;

import java.time.Duration;

public class TestNGSmokeTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeClass
    public void setUp() {
        WrappedElements.config()
                .driverCreator(() -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setImplicitWaitTimeout(Duration.ofSeconds(10));
                    return new ChromeDriver();
                })
                .registerDecorator(Button.class, new ButtonDecorator());

        loginPage = WrappedElements.initPage(LoginPage.class);
        inventoryPage = WrappedElements.initPage(InventoryPage.class);
        //TODO: need to add convenient mechanism to open page
    }

    @BeforeMethod
    public void beforeMethod() {
        WrappedElements.getDriver().get("https://www.saucedemo.com/");
    }

    @Test
    public void simpleUIInteractionTest() {
        loginPage.loginInput().sendKeys("standard_user");
        loginPage.passwordInput().sendKeys("secret_sauce");
        loginPage.loginButton().click();

        Assert.assertEquals(WrappedElements.getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void simpleUIInteraction2Test() {
        loginPage.loginInput().sendKeys("standard_user");
        loginPage.passwordInput().sendKeys("secret_sauce");
        loginPage.loginButton().click();
        inventoryPage.addToCartButton().click();
        Assert.assertEquals(WrappedElements.getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }


    @AfterMethod
    public void tearDown() {
        if (WrappedElements.getDriver() != null) {
            WrappedElements.getDriver().quit();
        }
    }

}