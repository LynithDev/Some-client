package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;
import java.util.*;

public class df implements Comparable<df>
{
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("slug")
    @NotNull
    private final dW jv;
    @SerializedName("icon")
    @NotNull
    private final String icon;
    @SerializedName("description")
    @NotNull
    private final String jA;
    @SerializedName("renderMod")
    private final Boolean jy;
    @SerializedName("categories")
    @NotNull
    private final a[] js;
    @SerializedName("form")
    @NotNull
    private final List<dp> iN;
    
    public df(@NotNull final String name, @NotNull final dW jv, @NotNull final String icon, @NotNull final String ja, final Boolean jy, @NotNull final a[] js, @NotNull final List<dp> in) {
        this.name = name;
        this.jv = jv;
        this.icon = icon;
        this.jA = ja;
        this.jy = jy;
        this.js = js;
        this.iN = in;
    }
    
    @NotNull
    public String getName() {
        return this.name;
    }
    
    @NotNull
    public dW dz() {
        return this.jv;
    }
    
    @NotNull
    public String getIcon() {
        return this.icon;
    }
    
    @NotNull
    public String dE() {
        return this.jA;
    }
    
    public boolean dF() {
        return this.jy;
    }
    
    @NotNull
    public a[] dw() {
        return this.js;
    }
    
    @NotNull
    public List<dp> cR() {
        return this.iN;
    }
    
    public int a(@NotNull final df df) {
        return this.name.compareTo(df.getName());
    }
    
    public enum a
    {
        @SerializedName("HUD")
        HUD, 
        @SerializedName("Hypixel")
        HYPIXEL, 
        @SerializedName("PvP")
        PVP;
        
        private static /* synthetic */ a[] $values() {
            return new a[] { a.HUD, a.HYPIXEL, a.PVP };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
