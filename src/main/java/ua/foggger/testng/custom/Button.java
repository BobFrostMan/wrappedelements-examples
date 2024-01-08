package ua.foggger.testng.custom;

import org.openqa.selenium.By;
import ua.foggger.element.clickable.ClickableElement;
import ua.foggger.element.interactor.IElementInteractor;

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
        this.detection = interactor;
    }

}
