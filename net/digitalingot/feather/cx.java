package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;
import java.util.*;

public class cx implements bT
{
    @SerializedName("settings")
    @Nullable
    private final a iK;
    @SerializedName("equipped")
    @Nullable
    private final b iL;
    
    public cx(@Nullable final a ik, @Nullable final b il) {
        this.iK = ik;
        this.iL = il;
    }
    
    @Nullable
    public a cO() {
        return this.iK;
    }
    
    @Nullable
    public b cP() {
        return this.iL;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.UPDATE_COSMETICS;
    }
    
    public static class a
    {
        @SerializedName("cosmetic")
        @NotNull
        private final String slug;
        @SerializedName("settings")
        @NotNull
        private final L iM;
        
        public a(@NotNull final String slug, @NotNull final L im) {
            this.slug = slug;
            this.iM = im;
        }
        
        @NotNull
        public String getSlug() {
            return this.slug;
        }
        
        @NotNull
        public L cQ() {
            return this.iM;
        }
    }
    
    public static class b extends HashMap<p.a, String>
    {
    }
}
