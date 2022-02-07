package net.digitalingot.feather;

import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ec {
    String fu();
}
