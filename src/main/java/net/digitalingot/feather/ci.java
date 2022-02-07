package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class ci implements bT
{
    @SerializedName("msg")
    @NotNull
    private final String iz;
    
    public ci(@NotNull final String iz) {
        this.iz = iz;
    }
    
    @NotNull
    public String cC() {
        return this.iz;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.CALLBACK;
    }
}
