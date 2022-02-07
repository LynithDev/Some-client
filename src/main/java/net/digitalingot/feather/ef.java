package net.digitalingot.feather;

import java.lang.annotation.*;
import org.jetbrains.annotations.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ef {
    boolean fC() default false;
    
    @NotNull
    ek fD() default @ek(fN = "", fh = "", fi = "", fO = 0);
}
