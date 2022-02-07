package net.digitalingot.feather;

import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface eg {
    double fE() default 5.0;
    
    double fF() default 0.0;
    
    double fG() default 0.05;
}
