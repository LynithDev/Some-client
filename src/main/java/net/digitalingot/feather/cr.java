package net.digitalingot.feather;

import java.util.*;
import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class cr implements bT
{
    @SerializedName("macros")
    @NotNull
    private final Set<fJ> iG;
    
    public cr(@NotNull final Set<fJ> ig) {
        this.iG = ig;
    }
    
    @NotNull
    public Set<fJ> cK() {
        return this.iG;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.LOAD_MACROS;
    }
}
