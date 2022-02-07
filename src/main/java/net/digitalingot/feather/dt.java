package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class dt implements du
{
    @SerializedName("dataTypes")
    @NotNull
    private final String jR;
    @SerializedName("range")
    private final double[] jS;
    @SerializedName("step")
    @Nullable
    private final Double jT;
    
    public dt(final double n, final double n2, @Nullable final Double jt) {
        this.jR = "decimal";
        this.jS = new double[] { n, n2 };
        this.jT = jt;
    }
    
    @NotNull
    public String dX() {
        return this.jR;
    }
    
    public double[] dY() {
        return this.jS;
    }
    
    @Nullable
    public Double dZ() {
        return this.jT;
    }
}
