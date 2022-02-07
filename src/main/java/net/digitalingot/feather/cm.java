package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;
import java.util.*;

public class cm implements bT
{
    @SerializedName("selected")
    @NotNull
    private final UUID iB;
    @SerializedName("list")
    @NotNull
    private final List<a> iC;
    
    public cm(@NotNull final UUID ib, @NotNull final List<a> ic) {
        this.iB = ib;
        this.iC = ic;
    }
    
    @NotNull
    public UUID cE() {
        return this.iB;
    }
    
    @NotNull
    public List<a> cF() {
        return this.iC;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.LOAD_ACCOUNT_LIST;
    }
    
    public static class a
    {
        @SerializedName("mcID")
        @NotNull
        private final UUID an;
        @SerializedName("mcUsername")
        @NotNull
        private final String V;
        
        public static a a(final fO.a a) {
            return new a(a.ai(), a.getName());
        }
        
        public a(@NotNull final UUID an, @NotNull final String v) {
            this.an = an;
            this.V = v;
        }
        
        @NotNull
        public UUID cG() {
            return this.an;
        }
        
        @NotNull
        public String T() {
            return this.V;
        }
    }
}
