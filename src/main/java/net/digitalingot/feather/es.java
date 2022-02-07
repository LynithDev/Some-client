package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.lang.reflect.*;

public class es
{
    @NotNull
    private final ec li;
    @NotNull
    private final Type lj;
    @NotNull
    private final Method lk;
    
    public es(@NotNull final ec li, @NotNull final Type lj, @NotNull final Method lk) {
        this.li = li;
        this.lj = lj;
        this.lk = lk;
    }
    
    @NotNull
    public ec ga() {
        return this.li;
    }
    
    @NotNull
    public Type gb() {
        return this.lj;
    }
    
    @NotNull
    public Method gc() {
        return this.lk;
    }
}
