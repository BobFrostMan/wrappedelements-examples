package wrappedelements.page;

import io.github.bobfrostman.annotation.WebComponent;
import io.github.bobfrostman.wrapper.page.IPage;
import wrappedelements.component.Header;

public interface BaseSauceLabsLoggedInPage extends IPage {

    @WebComponent("//*[@class='primary_header']")
    Header header();

}
