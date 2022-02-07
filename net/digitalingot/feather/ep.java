package net.digitalingot.feather;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ep {
    String fV();
    
    String fW() default "";
    
    String fX() default "";
    
    int fQ() default -9999;
    
    int fP() default -9999;
    
    boolean fY() default false;
}
