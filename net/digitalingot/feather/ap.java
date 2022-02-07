package net.digitalingot.feather;

import java.util.function.*;

public final class ap
{
    private static boolean bJ;
    
    private ap() {
    }
    
    public static boolean aI() {
        return ap.bJ;
    }
    
    public static void aJ() {
        as.aJ();
    }
    
    public static <T> ao<T> a(final Class<? super T> clazz, final Function<T[], T> function) {
        return as.a(clazz, function);
    }
    
    public static <T> ao<T> a(final Class<T> clazz, final T t, final Function<T[], T> function) {
        return a((Class<? super T>)clazz, array -> {
            if (array.length == 0) {
                return t;
            }
            else if (array.length == 1) {
                return array[0];
            }
            else {
                return function.apply(array);
            }
        });
    }
    
    public static String b(final Object o) {
        return o.getClass().getName();
    }
    
    static {
        ap.bJ = true;
    }
}
