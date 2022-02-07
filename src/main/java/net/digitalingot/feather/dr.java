package net.digitalingot.feather;

import com.google.gson.annotations.*;
import java.util.*;
import org.jetbrains.annotations.*;

public class dr implements du
{
    @SerializedName("columns")
    private final int jP;
    @SerializedName("choices")
    @NotNull
    private final List<do> jQ;
    
    public dr(final int jp, @NotNull final List<do> jq) {
        this.jP = jp;
        this.jQ = jq;
    }
    
    public int dV() {
        return this.jP;
    }
    
    @NotNull
    public List<do> dW() {
        return this.jQ;
    }
}
