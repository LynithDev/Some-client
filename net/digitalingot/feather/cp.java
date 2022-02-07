package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class cp implements bT
{
    @SerializedName("macro")
    @Nullable
    private final String iE;
    @SerializedName("payload")
    @NotNull
    private final fJ iF;
    
    public cp(@Nullable final String ie, @NotNull final fJ if1) {
        this.iE = ie;
        this.iF = if1;
    }
    
    @Nullable
    public String cI() {
        return this.iE;
    }
    
    @NotNull
    public fJ cJ() {
        return this.iF;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.CREATE_UPDATE_MACRO;
    }
}
