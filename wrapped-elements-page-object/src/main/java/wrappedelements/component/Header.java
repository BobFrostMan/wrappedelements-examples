package wrappedelements.component;

import ua.foggger.annotation.WebComponent;
import ua.foggger.wrapper.block.WrappedComponent;

public interface Header extends WrappedComponent {

    @WebComponent("shopping_cart_container")
    BasketButton basket();
}
