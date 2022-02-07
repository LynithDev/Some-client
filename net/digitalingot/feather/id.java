package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.*;

public class id
{
    @NotNull
    private final UUID Be;
    @NotNull
    private final List<UUID> Bf;
    @NotNull
    private final iF.b Bg;
    
    public id(@NotNull final UUID be, @NotNull final List<UUID> bf, final iF.b bg) {
        this.Be = be;
        this.Bf = bf;
        this.Bg = bg;
    }
    
    @NotNull
    public UUID lq() {
        return this.Be;
    }
    
    @NotNull
    public List<UUID> lr() {
        return this.Bf;
    }
    
    @NotNull
    public iF.b ls() {
        return this.Bg;
    }
}
