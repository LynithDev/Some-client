package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.*;

public class iv
{
    @NotNull
    private final UUID an;
    @NotNull
    private final List<String> Ca;
    
    public iv(@NotNull final UUID an, @NotNull final List<String> ca) {
        this.an = an;
        this.Ca = ca;
    }
    
    @NotNull
    public UUID ai() {
        return this.an;
    }
    
    @NotNull
    public List<String> mE() {
        return this.Ca;
    }
}
