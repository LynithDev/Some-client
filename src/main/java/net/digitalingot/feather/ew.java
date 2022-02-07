package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.*;
import java.lang.reflect.*;

public class ew<T extends ea>
{
    @NotNull
    protected final Class<T> lw;
    @Nullable
    protected final Map<String, String> ly;
    @Nullable
    protected List<et> lz;
    @Nullable
    private Map<et, Object> lA;
    
    public ew(@NotNull final Class<T> lw, @Nullable final Map<String, String> ly) {
        this.lw = lw;
        this.ly = ly;
    }
    
    @NotNull
    public T gp() {
        this.gq();
        this.gr();
        this.gs();
        return this.gt();
    }
    
    protected void gq() {
        this.lz = new eu((Class<Object>)this.lw).go();
    }
    
    private void gr() {
        if (this.lz == null) {
            throw new IllegalStateException("parseObjects() called before parseAnnotations()");
        }
        this.lA = new HashMap<et, Object>();
        for (final et et : this.lz) {
            final String fu = et.gf().fu();
            final String s = (this.ly == null) ? null : this.ly.get(fu);
            if (s == null && fu.equals("enabled")) {
                final ef gu = this.gu();
                if (gu != null) {
                    this.lA.put(et, gu.fC());
                    continue;
                }
            }
            this.lA.put(et, new eA<Object>(et, s).gB());
        }
    }
    
    private void gs() {
        if (this.lA == null) {
            throw new IllegalStateException("validateObjects() called before parseObjects()");
        }
        for (final Map.Entry<et, Object> entry : this.lA.entrySet()) {
            final et et = entry.getKey();
            final Object value = entry.getValue();
            if (et.gn() == null) {
                continue;
            }
            if (new ev<Object>(et).e(value)) {
                continue;
            }
            entry.setValue(new eA<Object>(entry.getKey(), null).gB());
        }
    }
    
    private T gt() {
        try {
            final ea ea = this.lw.getConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
            for (final Map.Entry<et, Object> entry : this.lA.entrySet()) {
                entry.getKey().ge().set(ea, entry.getValue());
            }
            return (T)ea;
        }
        catch (NoSuchMethodException ex) {
            throw new IllegalStateException("The config class has no default constructor.", ex);
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException ex2) {
            final Object o;
            throw new IllegalStateException((Throwable)o);
        }
    }
    
    @Nullable
    public ef gu() {
        return this.lw.getDeclaredAnnotation(ef.class);
    }
    
    @NotNull
    public Class<T> gv() {
        return this.lw;
    }
    
    @Nullable
    public List<et> gw() {
        return this.lz;
    }
}
