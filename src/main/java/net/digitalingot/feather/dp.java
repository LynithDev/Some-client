package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class dp
{
    @SerializedName("type")
    @NotNull
    private final a jI;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("slug")
    @Nullable
    private final String slug;
    @SerializedName("parent")
    @Nullable
    private final dq jJ;
    @SerializedName("value")
    @Nullable
    private final du jK;
    @SerializedName("chroma")
    @Nullable
    private final Boolean jL;
    @SerializedName("opacity")
    @Nullable
    private final Boolean jM;
    
    public dp(@NotNull final a ji, @NotNull final String name, @Nullable final String slug, @Nullable final dq jj, @Nullable final du jk, @Nullable final Boolean jl, @Nullable final Boolean jm) {
        this.jI = ji;
        this.name = name;
        this.slug = slug;
        this.jJ = jj;
        this.jK = jk;
        this.jL = jl;
        this.jM = jm;
    }
    
    @NotNull
    public a dO() {
        return this.jI;
    }
    
    @NotNull
    public String getName() {
        return this.name;
    }
    
    @Nullable
    public String getSlug() {
        return this.slug;
    }
    
    @Nullable
    public dq dP() {
        return this.jJ;
    }
    
    @Nullable
    public du dQ() {
        return this.jK;
    }
    
    @Nullable
    public Boolean dR() {
        return this.jL;
    }
    
    @Nullable
    public Boolean dS() {
        return this.jM;
    }
    
    public enum a
    {
        @SerializedName("title")
        TITLE, 
        @SerializedName("radio")
        RADIO, 
        @SerializedName("dropdown")
        DROPDOWN, 
        @SerializedName("bool")
        BOOLEAN, 
        @SerializedName("colorpicker")
        COLOR_PICKER, 
        @SerializedName("slider")
        SLIDER, 
        @SerializedName("text")
        TEXT, 
        @SerializedName("keyPicker")
        KEY_PICKER, 
        @SerializedName("checkbox")
        CHECKBOX;
        
        private static /* synthetic */ a[] $values() {
            return new a[] { a.TITLE, a.RADIO, a.DROPDOWN, a.BOOLEAN, a.COLOR_PICKER, a.SLIDER, a.TEXT, a.KEY_PICKER, a.CHECKBOX };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
