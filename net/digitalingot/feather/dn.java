package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class dn implements bT
{
    @SerializedName("profile")
    @NotNull
    private final String jD;
    
    public dn(@NotNull final String jd) {
        this.jD = jd;
    }
    
    @NotNull
    public String dJ() {
        return this.jD;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.SELECT_MOD_PROFILE;
    }
}
