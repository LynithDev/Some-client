package net.digitalingot.feather;

import java.util.*;
import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class cw implements bT
{
    @SerializedName("cosmetics")
    @NotNull
    private final List<String> al;
    
    public cw(@NotNull final List<String> al) {
        this.al = al;
    }
    
    @NotNull
    public List<String> af() {
        return this.al;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.RESET_COSMETICS_SETTINGS;
    }
}
