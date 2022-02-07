package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class t
{
    @SerializedName("slug")
    @NotNull
    private final String slug;
    
    public t(@NotNull final String slug) {
        this.slug = slug;
    }
    
    @NotNull
    public String getSlug() {
        return this.slug;
    }
}
