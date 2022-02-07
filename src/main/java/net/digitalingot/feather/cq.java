package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class cq implements bT
{
    @SerializedName("macro")
    @NotNull
    private final String iE;
    
    public cq(@NotNull final String ie) {
        this.iE = ie;
    }
    
    @NotNull
    public String cI() {
        return this.iE;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.DELETE_MACRO;
    }
}
