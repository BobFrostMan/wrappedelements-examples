package wrappedelements.page;

import ua.foggger.annotation.WebComponent;
import ua.foggger.wrapper.page.IPage;
import wrappedelements.component.Header;

public interface BaseSauceLabsLoggedInPage extends IPage {

    @WebComponent("//*[@class='primary_header']")
    Header header();

}
