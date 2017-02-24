package company.shildt.chapter12.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by dmitry on 25.02.17.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MySingle {
    int value();
}
