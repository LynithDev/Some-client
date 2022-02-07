package net.digitalingot.feather;

import java.util.*;
import org.jetbrains.annotations.*;

public class ig
{
    private final int Bk;
    @NotNull
    private final UUID Bl;
    
    public ig(final int bk, @NotNull final UUID bl) {
        this.Bk = bk;
        this.Bl = bl;
    }
    
    public int lw() {
        return this.Bk;
    }
    
    @NotNull
    public UUID lx() {
        return this.Bl;
    }
}
