package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class dv implements du
{
    @SerializedName("dataType")
    @NotNull
    private final String jR;
    @SerializedName("range")
    private final int[] jU;
    @SerializedName("step")
    @Nullable
    private final Integer jV;
    
    public dv(final int n, final int n2, @Nullable final Integer jv) {
        this.jR = "int";
        this.jU = new int[] { n, n2 };
        this.jV = jv;
    }
    
    @NotNull
    public String dX() {
        return this.jR;
    }
    
    public int[] ea() {
        return this.jU;
    }
    
    @Nullable
    public Integer eb() {
        return this.jV;
    }
}
