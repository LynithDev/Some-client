package net.digitalingot.feather;

import com.google.gson.annotations.*;
import com.google.gson.*;
import org.jetbrains.annotations.*;

public class p
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
    @SerializedName("type")
    @NotNull
    private final a Y;
    @SerializedName("defaultSettings")
    @Nullable
    private final JsonElement Z;
    
    public p(@NotNull final String name, @NotNull final String slug, @NotNull final String icon, @NotNull final a y, @Nullable final JsonElement z) {
        this.name = name;
        this.slug = slug;
        this.icon = icon;
        this.Y = y;
        this.Z = z;
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
    public a W() {
        return this.Y;
    }
    
    @Nullable
    public JsonElement X() {
        return this.Z;
    }
    
    public enum a
    {
        @SerializedName("Capes")
        CAPE, 
        @SerializedName("Wings")
        WINGS, 
        @SerializedName("Boots")
        BOOTS, 
        @SerializedName("Hats")
        HATS;
        
        private static /* synthetic */ a[] $values() {
            return new a[] { a.CAPE, a.WINGS, a.BOOTS, a.HATS };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
