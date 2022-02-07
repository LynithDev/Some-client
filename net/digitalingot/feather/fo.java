package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.lang.reflect.*;
import java.util.*;

public class fo
{
    @NotNull
    private final dU t;
    @NotNull
    private final bg u;
    static final /* synthetic */ boolean ac;
    
    public fo(@NotNull final dU t, @NotNull final bg u) {
        this.t = t;
        this.u = u;
    }
    
    public void gT() {
        for (final Class<? extends dQ<?>> clazz : this.t.fe()) {
            final dP dp = clazz.getDeclaredAnnotation(dP.class);
            if (dp == null) {
                throw new IllegalStateException("FeatherModule not annotated with @FeatherHandler");
            }
            try {
                final dQ<T> dq = (dQ<T>)clazz.getConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
                dq.a(dp);
                this.h((dQ<ea>)dq);
                this.t.dL().put(dp.eL(), dq);
                this.t.fd().put((Class<? extends dQ<?>>)dq.getClass(), dq);
            }
            catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
                final Object o;
                throw new IllegalStateException((Throwable)o);
            }
            catch (NoSuchMethodException ex2) {
                throw new IllegalStateException("FeatherModule has no default constructor");
            }
        }
    }
    
    public <T extends ea> void h(@NotNull final dQ<T> dq) {
        final Class<?> a = kZ.a(dq.getClass(), 0);
        if (!fo.ac && a == null) {
            throw new AssertionError();
        }
        final Map<dW, Map<String, String>> gf = this.t.ff().gF();
        if (!fo.ac && gf == null) {
            throw new AssertionError();
        }
        final dW el = dq.eR().eL();
        final Map<String, String> map = gf.get(el);
        ea ea;
        if (dX.class.isAssignableFrom(a)) {
            ea = new ex<Object>((Class<dX>)a, map).g(dq);
        }
        else {
            ea = new ew<T>((Class<T>)a, map).gp();
        }
        final cO be = this.u.bd().be();
        final List<dW> dl = be.dl();
        be.dm();
        ea.jB = dl.contains(el);
        dq.a((T)ea);
    }
    
    static {
        ac = !fo.class.desiredAssertionStatus();
    }
}
