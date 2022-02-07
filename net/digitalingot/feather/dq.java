package net.digitalingot.feather;

import com.google.gson.annotations.*;
import java.util.*;
import org.jetbrains.annotations.*;

public class dq
{
    @SerializedName("field")
    @NotNull
    private final String jN;
    @SerializedName("values")
    @Nullable
    private final List<String> jO;
    
    public dq(@NotNull final String jn, @Nullable final List<String> jo) {
        this.jN = jn;
        this.jO = jo;
    }
    
    @NotNull
    public String dT() {
        return this.jN;
    }
    
    @Nullable
    public List<String> dU() {
        return this.jO;
    }
}
