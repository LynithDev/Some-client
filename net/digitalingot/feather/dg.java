package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class dg
{
    @SerializedName("enabled")
    private final boolean enabled;
    @SerializedName("favorite")
    private final boolean jB;
    @SerializedName("settings")
    @NotNull
    private final ea jC;
    
    public dg(@NotNull final ea jc) {
        this.enabled = jc.dG();
        this.jB = jc.dH();
        this.jC = jc;
    }
    
    public boolean dG() {
        return this.enabled;
    }
    
    public boolean dH() {
        return this.jB;
    }
    
    @NotNull
    public ea dI() {
        return this.jC;
    }
}
