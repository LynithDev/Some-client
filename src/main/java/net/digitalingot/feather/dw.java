package net.digitalingot.feather;

import java.util.*;
import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class dw implements bT
{
    @SerializedName("origin")
    @NotNull
    private final UUID jW;
    @SerializedName("serverPort")
    private final int jX;
    
    public dw(@NotNull final UUID jw, final int jx) {
        this.jW = jw;
        this.jX = jx;
    }
    
    @NotNull
    public UUID ec() {
        return this.jW;
    }
    
    public int ed() {
        return this.jX;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.ACCEPT_P2P_JOIN;
    }
}
