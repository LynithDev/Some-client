package net.digitalingot.feather;

import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface el {
    int fP() default 100;
    
    int fQ() default 0;
    
    int fR() default 1;
}
