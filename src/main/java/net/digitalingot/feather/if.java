package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.*;

public class if
{
    @NotNull
    private final ih Bh;
    @NotNull
    private final List<ig> Bi;
    @Nullable
    private id Bj;
    
    public if(@NotNull final ih bh) {
        this.Bi = new ArrayList<ig>();
        this.Bh = bh;
    }
    
    @NotNull
    public ie lt() {
        return new ie(this.Bh, this);
    }
    
    @NotNull
    public List<ig> lu() {
        return this.Bi;
    }
    
    @Nullable
    public id lv() {
        return this.Bj;
    }
    
    public void b(@Nullable final id bj) {
        this.Bj = bj;
    }
}
