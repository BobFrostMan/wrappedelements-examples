package wrappedelements.custom.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TableElement {

    String tableLocator() default "//table";
    String header() default "//th";
    String headerCell() default "//td";
    String row() default "//tr";
    String cell() default "//td";
    String loadingCondition() default "rows > 1";

}
