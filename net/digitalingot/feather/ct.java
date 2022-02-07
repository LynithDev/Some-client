package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;
import java.util.*;

public class ct implements bT
{
    @SerializedName("categories")
    @NotNull
    private final p.a[] iH;
    @SerializedName("cosmetics")
    @NotNull
    private final List<cy> al;
    
    public ct(@NotNull final List<cy> al) {
        this.iH = p.a.values();
        this.al = al;
    }
    
    @NotNull
    public p.a[] cL() {
        return this.iH;
    }
    
    @NotNull
    public List<cy> af() {
        return this.al;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.BUILD_COSMETICS_MENU;
    }
}
