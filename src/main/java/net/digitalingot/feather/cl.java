package net.digitalingot.feather;

import java.util.*;
import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class cl implements bT
{
    @SerializedName("account")
    @NotNull
    private final UUID iA;
    
    public cl(@NotNull final UUID ia) {
        this.iA = ia;
    }
    
    @NotNull
    public UUID cD() {
        return this.iA;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.CHANGE_ACCOUNT;
    }
}
