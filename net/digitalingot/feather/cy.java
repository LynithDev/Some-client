package net.digitalingot.feather;

import com.google.gson.annotations.*;
import java.util.*;
import org.jetbrains.annotations.*;

public class cy
{
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("slug")
    @NotNull
    private final String slug;
    @SerializedName("icon")
    @NotNull
    private final String icon;
    @SerializedName("category")
    @NotNull
    private final p.a Y;
    @SerializedName("form")
    @Nullable
    private final List<dp> iN;
    
    public cy(@NotNull final String name, @NotNull final String slug, @NotNull final String icon, @NotNull final p.a y, @Nullable final List<dp> in) {
        this.name = name;
        this.slug = slug;
        this.icon = icon;
        this.Y = y;
        this.iN = in;
    }
    
    @NotNull
    public String getName() {
        return this.name;
    }
    
    @NotNull
    public String getSlug() {
        return this.slug;
    }
    
    @NotNull
    public String getIcon() {
        return this.icon;
    }
    
    @NotNull
    public p.a W() {
        return this.Y;
    }
    
    @Nullable
    public List<dp> cR() {
        return this.iN;
    }
}
