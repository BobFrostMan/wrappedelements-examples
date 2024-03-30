package wrappedelements.component;

import io.github.bobfrostman.annotation.WebElement;
import io.github.bobfrostman.wrapper.block.WrappedComponent;
import io.github.bobfrostman.wrapper.element.impl.ClickableElement;

public interface BasketButton extends WrappedComponent {

    @WebElement(value = ".//span[@class=\"shopping_cart_badge\"]", waitUntil = IMMEDIATELY)
    ClickableElement notificationsCountLabel();

    @WebElement(value = ".//a[@class=\"shopping_cart_link\"]", waitUntil = VERTICAL_SCROLL_UNTIL_VISIBLE)
    ClickableElement basketButton();

}
