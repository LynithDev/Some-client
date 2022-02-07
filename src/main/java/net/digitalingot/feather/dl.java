package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;
import java.util.*;

public class dl implements bT
{
    @SerializedName("selected")
    @NotNull
    private final String jG;
    @SerializedName("list")
    @NotNull
    private final List<String> jH;
    
    public dl(@NotNull final String jg, @NotNull final List<String> jh) {
        this.jG = jg;
        this.jH = jh;
    }
    
    @NotNull
    public String dM() {
        return this.jG;
    }
    
    @NotNull
    public List<String> dN() {
        return this.jH;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.LOAD_MOD_PROFILE_LIST;
    }
}
