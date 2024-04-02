package step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bobfrostman.config.WrappedElements;
import org.junit.Assert;
import wrappedelements.page.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps() {
        loginPage = WrappedElements.initPage(LoginPage.class);
    }

    @Given("user opens sauce labs demo page")
    public void userOnSauceLabsDemoPage() {
        WrappedElements.getDriver().get("https://www.saucedemo.com/");
    }

    @When("user enters login {string} on Login page")
    public void userEntersLogin(String login) {
        loginPage.loginInput().sendKeys(login);
    }

    @When("user enters password {string} on Login page")
    public void userEntersPassword(String password) {
        loginPage.passwordInput().sendKeys(password);
    }

    @When("user clicks login button on Login page")
    public void userClicksLoginButton() {
        loginPage.loginButton().click();
    }

    @When("user redirected to Inventory page")
    public void userRedirectedToInventoryPage() {
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", WrappedElements.getDriver().getCurrentUrl());
    }

}
