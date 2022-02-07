package net.digitalingot.feather;

import java.util.function.*;
import java.lang.reflect.*;
import java.lang.invoke.*;
import java.util.*;

public final class as
{
    private static final List<ar<?>> bN;
    
    private as() {
    }
    
    public static void aJ() {
        as.bN.forEach(ar::aK);
    }
    
    public static <T> ao<T> a(final Class<? super T> clazz, final Function<T[], T> function) {
        final ar<Object> ar = new ar<Object>((Class<? super Object>)clazz, (Function<Object[], Object>)function);
        as.bN.add(ar);
        return (ao<T>)ar;
    }
    
    private static <T> T b(final Class<T> clazz, final Function<T[], T> function) {
        Method method = null;
        for (final Method method2 : clazz.getMethods()) {
            if ((method2.getModifiers() & 0x802) == 0x0) {
                if (method != null) {
                    throw new IllegalStateException("Multiple virtual methods in " + clazz + "; cannot build empty invoker!");
                }
                method = method2;
            }
        }
        if (method == null) {
            throw new IllegalStateException("No virtual methods in " + clazz + "; cannot build empty invoker!");
        }
        try {
            final MethodHandle unreflect = MethodHandles.lookup().unreflect(method);
            final MethodType dropParameterTypes = unreflect.type().dropParameterTypes(0, 1);
            if (dropParameterTypes.returnType() != Void.TYPE) {
                final MethodHandle explicitCastArguments = MethodHandles.explicitCastArguments(unreflect, MethodType.genericMethodType(dropParameterTypes.parameterCount()).changeReturnType(dropParameterTypes.returnType()).insertParameterTypes(0, unreflect.type().parameterType(0)));
                final Object[] array = new Object[unreflect.type().parameterCount()];
                array[0] = function.apply((T[])Array.newInstance(clazz, 0));
                explicitCastArguments.invokeWithArguments(array);
            }
        }
        catch (Throwable t) {
            throw new RuntimeException(t);
        }
        final Object o;
        return (T)Proxy.newProxyInstance(as.class.getClassLoader(), new Class[] { clazz }, (p1, p2, p3) -> o);
    }
    
    static {
        bN = new ArrayList<ar<?>>();
    }
}
