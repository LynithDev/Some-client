package net.digitalingot.feather;

import java.util.*;
import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class co implements bT
{
    @SerializedName("accounts")
    @NotNull
    private final List<fO.a> iD;
    
    public co(@NotNull final List<fO.a> id) {
        this.iD = id;
    }
    
    @NotNull
    public List<fO.a> cH() {
        return this.iD;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.CALLBACK;
    }
}
