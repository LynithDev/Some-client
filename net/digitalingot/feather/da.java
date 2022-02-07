package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;
import java.util.*;

public class da implements bT
{
    @SerializedName("categories")
    @NotNull
    private final df.a[] js;
    @SerializedName("mods")
    @NotNull
    private final List<df> jt;
    
    public da(@NotNull final List<df> jt) {
        this.js = df.a.values();
        this.jt = jt;
    }
    
    @NotNull
    public df.a[] dw() {
        return this.js;
    }
    
    @NotNull
    public List<df> dx() {
        return this.jt;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.BUILD_MOD_SETTINGS;
    }
}
