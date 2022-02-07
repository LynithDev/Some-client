package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.lang.reflect.*;
import java.util.*;

public class ev<T>
{
    @NotNull
    private final et lx;
    
    public ev(@NotNull final et lx) {
        this.lx = lx;
    }
    
    public boolean e(@NotNull final T t) {
        if (this.lx.gn() != null) {
            final Iterator<Object> iterator = this.a(this.lx.gn()).iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals(t)) {
                    return true;
                }
            }
            return false;
        }
        if (this.lx.gj() != null) {
            final double doubleValue = (double)t;
            return doubleValue <= this.lx.gj().fE() && doubleValue >= this.lx.gj().fF();
        }
        if (this.lx.gk() != null) {
            final int intValue = (int)t;
            return intValue <= this.lx.gk().fP() && intValue >= this.lx.gk().fQ();
        }
        if (this.lx.gi() != null) {
            final String s = (String)t;
            return s.length() <= this.lx.gi().fP() && s.length() >= this.lx.gi().fQ();
        }
        return true;
    }
    
    @NotNull
    private Collection<T> a(@NotNull final es es) {
        final Method gc = es.gc();
        if (!Collection.class.isAssignableFrom(gc.getReturnType())) {
            throw new IllegalStateException(gc.getName() + " does not return a Collection or a subtype of one");
        }
        Object invoke;
        try {
            invoke = gc.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException | InvocationTargetException ex) {
            final Object o;
            throw new IllegalStateException((Throwable)o);
        }
        if (kZ.a((ParameterizedType)gc.getGenericReturnType(), 0) == String.class) {
            return this.a((Collection<String>)invoke, (Class<T>)es.gb());
        }
        return (Collection<T>)invoke;
    }
    
    @NotNull
    private Collection<T> a(final Collection<String> collection, final Class<T> clazz) {
        final ArrayList<T> list = new ArrayList<T>();
        final Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            list.add(new eA<T>((Class<Object>)clazz, iterator.next()).gB());
        }
        return list;
    }
}
