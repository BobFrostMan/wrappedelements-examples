package wrappedelements.custom;

import org.openqa.selenium.support.pagefactory.ByChained;
import io.github.bobfrostman.common.IHaveReflectionAccess;
import io.github.bobfrostman.wrapper.IAnnotationProcessor;
import io.github.bobfrostman.wrapper.block.WrappedBlockMeta;
import io.github.bobfrostman.wrapper.interactor.Interactors;
import io.github.bobfrostman.wrapper.page.ElementNameResolver;
import io.github.bobfrostman.wrapper.page.LocatorResolver;
import wrappedelements.custom.annotation.ButtonElement;

import java.lang.reflect.Method;

public class ButtonAnnotationProcessor implements IAnnotationProcessor, IHaveReflectionAccess {

    private ElementNameResolver elementNameResolver;
    private LocatorResolver locatorResolver;

    public ButtonAnnotationProcessor() {
        elementNameResolver = new ElementNameResolver();
        locatorResolver = new LocatorResolver();
    }

    @Override
    public <T> Object setValuesFromAnnotation(WrappedBlockMeta wrappedBlockMeta, T element, Method method, Object[] args) {
        ButtonElement annotation = method.getAnnotation(ButtonElement.class);
        String name = "".equals(annotation.value()) ? elementNameResolver.resolve(method) : annotation.value();
        Button button = (Button) element;
        button.setName(name);
        if (wrappedBlockMeta != null) {
            button.setLocator(new ByChained(wrappedBlockMeta.getLocator(), locatorResolver.resolveLocator(annotation.value(), method, args)));
        } else {
            button.setLocator(locatorResolver.resolveLocator(annotation.value(), method, args));
        }
        button.setInteractor(Interactors.getRegisteredInteractor("until_clickable"));
        button.setTimeoutInSeconds(30);
        return element;
    }
}
