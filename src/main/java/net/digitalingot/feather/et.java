package net.digitalingot.feather;

import java.lang.reflect.*;
import org.jetbrains.annotations.*;
import org.apache.commons.lang3.*;

public class et
{
    @Nullable
    private final Field ll;
    @NotNull
    private final Class<?> lm;
    @Nullable
    private final er ln;
    @Nullable
    private final ee lo;
    @Nullable
    private final eh lp;
    @Nullable
    private final eq lq;
    @Nullable
    private final eg lr;
    @Nullable
    private final el ls;
    @Nullable
    private final ep lt;
    private final boolean lu;
    @Nullable
    private final es lv;
    
    public et(@NotNull final Class<?> clazz) {
        this.lm = (Class<?>)ClassUtils.primitiveToWrapper((Class)clazz);
        this.ll = null;
        this.ln = null;
        this.lo = null;
        this.lp = null;
        this.lq = null;
        this.lr = null;
        this.ls = null;
        this.lt = null;
        this.lu = false;
        this.lv = null;
    }
    
    public et(@NotNull final Field ll, @NotNull final er ln, @Nullable final ee lo, @Nullable final eh lp, @Nullable final eq lq, @Nullable final eg lr, @Nullable final el ls, @Nullable final ep lt, @Nullable final eo eo, @Nullable final es lv) {
        this.ll = ll;
        this.lm = (Class<?>)ClassUtils.primitiveToWrapper((Class)ll.getType());
        this.ln = ln;
        this.lo = lo;
        this.lp = lp;
        this.lq = lq;
        this.lr = lr;
        this.ls = ls;
        this.lt = lt;
        this.lu = (eo != null);
        this.lv = lv;
    }
    
    @NotNull
    public Class<?> gd() {
        return this.lm;
    }
    
    @Nullable
    public Field ge() {
        return this.ll;
    }
    
    @Nullable
    public er gf() {
        return this.ln;
    }
    
    @Nullable
    public ee gg() {
        return this.lo;
    }
    
    @Nullable
    public eh gh() {
        return this.lp;
    }
    
    @Nullable
    public eq gi() {
        return this.lq;
    }
    
    @Nullable
    public eg gj() {
        return this.lr;
    }
    
    @Nullable
    public el gk() {
        return this.ls;
    }
    
    @Nullable
    public ep gl() {
        return this.lt;
    }
    
    public boolean gm() {
        return this.lu;
    }
    
    @Nullable
    public es gn() {
        return this.lv;
    }
    
    @Override
    public String toString() {
        return (this.ll == null) ? "" : (this.ll.getDeclaringClass().getName() + "." + this.ll.getName());
    }
}
