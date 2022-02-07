package net.digitalingot.feather;

import java.util.*;
import org.jetbrains.annotations.*;
import java.lang.reflect.*;

public class ex<T extends dX> extends ew<T>
{
    static final /* synthetic */ boolean ac;
    
    public ex(@NotNull final Class<T> clazz, @Nullable final Map<String, String> map) {
        super(clazz, map);
    }
    
    @NotNull
    public <C extends ea> C g(final dQ<C> dq) {
        return this.f((dN<C>)dq);
    }
    
    @NotNull
    public T f(final dN<T> dn) {
        final dX dx = super.gp();
        dn.a((T)dx);
        this.a(dn, (T)dx);
        return (T)dx;
    }
    
    @NotNull
    public T gx() {
        throw new RuntimeException(new UnsupportedOperationException("Please use parse(FeatherHUDModule<T>) instead"));
    }
    
    @Override
    protected void gq() {
        super.gq();
        if (!ex.ac && this.lz == null) {
            throw new AssertionError();
        }
        final Field field;
        final Field field2;
        final Class<dX> clazz;
        boolean b;
        final Class<dX> clazz2;
        boolean b2;
        this.lz.sort((et, et2) -> {
            et.ge();
            et2.ge();
            if (field == null && field2 == null) {
                return 0;
            }
            else if (field == null) {
                return -1;
            }
            else if (field2 == null) {
                return 1;
            }
            else {
                field.getDeclaringClass();
                field2.getDeclaringClass();
                b = (clazz == dX.class);
                b2 = (clazz2 == dX.class);
                if (b && b2) {
                    return 0;
                }
                else if (b) {
                    return -1;
                }
                else if (b2) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        });
    }
    
    private void a(@NotNull final dN<T> dn, @NotNull final T t) {
        final ej gy = this.gy();
        if (this.ly == null || !this.ly.containsKey("hudRelativeX")) {
            t.a(dn, gy.fJ(), gy.fL() ? t.fp() : gy.fH(), gy.fM() ? t.fq() : gy.fI(), gy.fK());
        }
    }
    
    @NotNull
    private ej gy() {
        final ej ej = this.lw.getDeclaredAnnotation(ej.class);
        if (ej == null) {
            throw new IllegalStateException("HUDModuleConfig not annotated with with @HUDConfig");
        }
        return ej;
    }
    
    static {
        ac = !ex.class.desiredAssertionStatus();
    }
}
