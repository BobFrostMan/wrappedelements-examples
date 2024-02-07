package wrappedelements.component;

import ua.foggger.annotation.WebElement;
import ua.foggger.wrapper.block.WrappedComponent;
import ua.foggger.wrapper.element.impl.ClickableElement;

public interface BasketButton extends WrappedComponent {

    @WebElement(value = ".//span[@class=\"shopping_cart_badge\"]", waitUntil = IMMEDIATELY)
    ClickableElement notificationsCountLabel();

    @WebElement(value = ".//a[@class=\"shopping_cart_link\"]", waitUntil = VERTICAL_SCROLL_UNTIL_VISIBLE)
    ClickableElement basketButton();

}
