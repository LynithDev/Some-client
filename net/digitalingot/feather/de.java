package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.google.gson.*;

public class de implements bT
{
    @SerializedName("mod")
    @NotNull
    private final dW jv;
    @SerializedName("enabled")
    @Nullable
    private final Boolean jw;
    @SerializedName("favorite")
    @Nullable
    private final Boolean jx;
    @SerializedName("renderMod")
    @Nullable
    private final Boolean jy;
    @SerializedName("settings")
    @Nullable
    private final Map<String, JsonElement> jz;
    
    public de(@NotNull final dW jv, @Nullable final Boolean jw, @Nullable final Boolean jx, @Nullable final Boolean jy, @Nullable final Map<String, JsonElement> jz) {
        this.jv = jv;
        this.jw = jw;
        this.jx = jx;
        this.jy = jy;
        this.jz = jz;
    }
    
    @NotNull
    public dW dz() {
        return this.jv;
    }
    
    @Nullable
    public Boolean dA() {
        return this.jw;
    }
    
    @Nullable
    public Boolean dB() {
        return this.jx;
    }
    
    @Nullable
    public Boolean dC() {
        return this.jy;
    }
    
    @Nullable
    public Map<String, JsonElement> dD() {
        return this.jz;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.UPDATE_MOD_SETTINGS;
    }
}
