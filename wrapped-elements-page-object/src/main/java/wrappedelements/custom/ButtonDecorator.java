package wrappedelements.custom;

import ua.foggger.helper.IHaveReflectionAccess;
import ua.foggger.wrapper.element.IElementAnnotationProcessor;
import ua.foggger.wrapper.element.interactor.Interactors;
import ua.foggger.wrapper.page.ElementNameResolver;
import ua.foggger.wrapper.page.LocatorResolver;
import wrappedelements.custom.annotation.ButtonElement;

import java.lang.reflect.Method;

public class ButtonDecorator implements IElementAnnotationProcessor, IHaveReflectionAccess {

    private ElementNameResolver elementNameResolver;
    private LocatorResolver locatorResolver;

    public ButtonDecorator() {
        elementNameResolver = new ElementNameResolver();
        locatorResolver = new LocatorResolver();
    }

    @Override
    public <T> Object setValuesFromAnnotation(T element, Method method, Object[] args) {
        ButtonElement annotation = method.getAnnotation(ButtonElement.class);
        String name = "".equals(annotation.value()) ? elementNameResolver.resolve(method) : annotation.value();
        Button button = (Button) element;
        button.setName(name);
        button.setLocator(locatorResolver.resolveLocator(annotation.value(), method, args));
        button.setInteractor(Interactors.getRegisteredInteractor(Interactors.UNTIL_CLICKABLE));
        button.setTimeoutInSeconds(30);
        return element;
    }
}
