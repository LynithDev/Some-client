package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class dh implements bT
{
    @SerializedName("profile")
    @NotNull
    private final String jD;
    @SerializedName("newName")
    @NotNull
    private final String jE;
    
    public dh(@NotNull final String jd, @NotNull final String je) {
        this.jD = jd;
        this.jE = je;
    }
    
    @NotNull
    public String dJ() {
        return this.jD;
    }
    
    @NotNull
    public String dK() {
        return this.jE;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.CLONE_MOD_PROFILE;
    }
}
