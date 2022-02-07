package net.digitalingot.feather;

import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface eo {
    ep[] fU() default {};
}
