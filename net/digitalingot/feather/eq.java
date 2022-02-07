package net.digitalingot.feather;

import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface eq {
    int fQ();
    
    int fP();
}
