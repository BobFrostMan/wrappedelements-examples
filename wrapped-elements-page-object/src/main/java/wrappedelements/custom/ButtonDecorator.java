package wrappedelements.custom;

import ua.foggger.element.decorator.IElementDecorator;
import ua.foggger.element.interactor.Interactors;
import ua.foggger.helper.IHaveReflectionAccess;
import ua.foggger.page.ElementNameResolver;
import ua.foggger.page.LocatorResolver;
import wrappedelements.custom.annotation.ButtonElement;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ButtonDecorator implements IElementDecorator, IHaveReflectionAccess {

    private ElementNameResolver elementNameResolver;
    private LocatorResolver locatorResolver;

    public ButtonDecorator() {
        elementNameResolver = new ElementNameResolver();
        locatorResolver = new LocatorResolver();
    }

    @Override
    public <T> Object setValuesFromAnnotation(T element, Method method, Object[] args) {
        ButtonElement annotation = (ButtonElement) method.getAnnotation(getAnnotationClass());
        String name = "".equals(annotation.value()) ? elementNameResolver.resolve(method) : annotation.value();
        Button button = (Button) element;
        button.setName(name);
        button.setLocator(locatorResolver.resolveLocator(annotation.value(), method, args));
        button.setInteractor(Interactors.getRegisteredDetection(Interactors.UNTIL_CLICKABLE));
        button.setTimeoutInSeconds(30);
        return element;
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return ButtonElement.class;
    }
}
