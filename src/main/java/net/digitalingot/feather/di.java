package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class di implements bT
{
    @SerializedName("profile")
    @NotNull
    private final String jD;
    
    public di(@NotNull final String jd) {
        this.jD = jd;
    }
    
    @NotNull
    public String dJ() {
        return this.jD;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.CREATE_MOD_PROFILE;
    }
}
