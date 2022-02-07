package net.digitalingot.feather;

import java.util.*;
import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class db implements bT
{
    @SerializedName("mods")
    @NotNull
    private final Collection<dW> ju;
    
    public db(@NotNull final Collection<dW> ju) {
        this.ju = ju;
    }
    
    @NotNull
    public Collection<dW> dy() {
        return this.ju;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.DISABLED_MODS;
    }
}
