package net.digitalingot.feather;

import java.util.*;
import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class dk implements bT
{
    @SerializedName("mods")
    @NotNull
    private final Map<dW, dg> jF;
    
    public dk(@NotNull final Map<dW, dg> jf) {
        this.jF = jf;
    }
    
    @NotNull
    public Map<dW, dg> dL() {
        return this.jF;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.LOAD_MOD_PROFILE;
    }
}
