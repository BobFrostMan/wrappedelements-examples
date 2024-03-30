package wrappedelements.custom;

import org.openqa.selenium.By;
import io.github.bobfrostman.wrapper.element.impl.ClickableElement;
import io.github.bobfrostman.wrapper.interactor.IElementInteractor;

public class Button extends ClickableElement {

    void setName(String name) {
        this.name = name;
    }

    void setLocator(By by) {
        this.locator = by;
    }

    void setTimeoutInSeconds(int timeoutInSeconds) {
        this.timeoutInSeconds = timeoutInSeconds;
    }

    void setInteractor(IElementInteractor interactor){
        this.interactor = interactor;
    }

}
