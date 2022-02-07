package net.digitalingot.feather;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ej {
    double fH() default 0.0;
    
    double fI() default 0.0;
    
    bG fJ() default bG.TOP_LEFT;
    
    double fK() default 1.0;
    
    boolean fL() default false;
    
    boolean fM() default false;
}
