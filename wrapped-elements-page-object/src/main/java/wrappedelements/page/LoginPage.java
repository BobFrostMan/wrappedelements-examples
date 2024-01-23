package wrappedelements.page;

import ua.foggger.annotation.WebElement;
import ua.foggger.wrapper.element.clickable.ClickableElement;
import ua.foggger.wrapper.page.IPage;

public interface LoginPage extends IPage {

    @WebElement(value = "//form//input", name = "Login input on login page")
    ClickableElement loginInput();

    @WebElement(value = "(//form//input)[2]", name = "Password input on login page")
    ClickableElement passwordInput();

    @WebElement(value = "//input[@type='submit']", name = "Login button")
    ClickableElement loginButton();

}
