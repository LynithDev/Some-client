package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class do
{
    @SerializedName("slug")
    @NotNull
    private final String slug;
    @SerializedName("name")
    @NotNull
    private final String name;
    
    public do(@NotNull final String slug, @NotNull final String name) {
        this.slug = slug;
        this.name = name;
    }
    
    @NotNull
    public String getSlug() {
        return this.slug;
    }
    
    @NotNull
    public String getName() {
        return this.name;
    }
}
