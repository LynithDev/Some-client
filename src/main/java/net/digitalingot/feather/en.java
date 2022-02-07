package net.digitalingot.feather;

import java.lang.annotation.*;
import org.jetbrains.annotations.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface en {
    @NotNull
    String fu();
    
    @NotNull
    String[] fT() default {};
}
