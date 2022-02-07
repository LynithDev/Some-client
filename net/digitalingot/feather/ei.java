package net.digitalingot.feather;

import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ei {
    String fu();
    
    String fh();
}
