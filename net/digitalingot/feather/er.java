package net.digitalingot.feather;

import java.lang.annotation.*;
import org.jetbrains.annotations.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface er {
    @NotNull
    String fu();
    
    @NotNull
    String fh();
    
    @NotNull
    String fW() default "";
    
    @NotNull
    en fZ() default @en(fu = "");
    
    @NotNull
    em fm();
}
