package net.digitalingot.feather;

import java.util.*;
import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class cu implements bT
{
    @SerializedName("settings")
    @NotNull
    private final Map<String, L> iI;
    @SerializedName("equipped")
    @NotNull
    private final Map<p.a, String> iJ;
    
    public cu(@NotNull final Map<String, L> ii, @NotNull final Map<p.a, String> ij) {
        this.iI = ii;
        this.iJ = ij;
    }
    
    @NotNull
    public Map<String, L> cM() {
        return this.iI;
    }
    
    @NotNull
    public Map<p.a, String> cN() {
        return this.iJ;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.LOAD_COSMETICS_SETTINGS;
    }
}
