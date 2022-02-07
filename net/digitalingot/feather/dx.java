package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class dx implements bT
{
    @SerializedName("id")
    private final int id;
    
    public dx(final int id) {
        this.id = id;
    }
    
    public int ee() {
        return this.id;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.CLOSE_P2P;
    }
}
