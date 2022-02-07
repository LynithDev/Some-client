package net.digitalingot.feather;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ed {
    int fv() default 40;
    
    int fw() default 70;
    
    int fx() default 60;
    
    int fy() default 10;
    
    int fz() default 25;
    
    int fA() default 20;
}
