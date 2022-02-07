package net.digitalingot.feather;

import java.util.*;
import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class m
{
    @SerializedName("id")
    @Nullable
    private final Collection<UUID> N;
    @SerializedName("mcID")
    @Nullable
    private final Collection<UUID> O;
    @SerializedName("mcUsername")
    @Nullable
    private final Collection<String> P;
    private final int Q;
    
    public m(@Nullable final Collection<UUID> n, @Nullable final Collection<UUID> o, @Nullable final Collection<String> p3) {
        this.N = n;
        this.O = o;
        this.P = p3;
        this.Q = ((n != null) ? n.size() : 0) + ((o != null) ? o.size() : 0) + ((p3 != null) ? p3.size() : 0);
    }
    
    @Nullable
    public Collection<UUID> L() {
        return this.N;
    }
    
    @Nullable
    public Collection<UUID> M() {
        return this.O;
    }
    
    @Nullable
    public Collection<String> N() {
        return this.P;
    }
    
    public int O() {
        return this.Q;
    }
}
