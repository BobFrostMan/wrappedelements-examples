package wrappedelements.component;

import io.github.bobfrostman.annotation.WebComponent;
import io.github.bobfrostman.wrapper.block.WrappedComponent;

public interface Header extends WrappedComponent {

    @WebComponent("shopping_cart_container")
    BasketButton basket();
}
