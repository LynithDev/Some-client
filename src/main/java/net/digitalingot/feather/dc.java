package net.digitalingot.feather;

import java.util.*;
import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class dc implements bT
{
    @SerializedName("mods")
    @NotNull
    private final List<dW> jt;
    
    public dc(@NotNull final List<dW> jt) {
        this.jt = jt;
    }
    
    @NotNull
    public List<dW> dx() {
        return this.jt;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.RESET_MOD_POSITIONS;
    }
}
