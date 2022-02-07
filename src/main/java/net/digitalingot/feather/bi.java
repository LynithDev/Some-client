package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class bi
{
    @SerializedName("updateClientPreferences")
    @NotNull
    private cO cf;
    @SerializedName("colorPickerPreferences")
    @NotNull
    private cK cg;
    
    public bi(@NotNull final cO cf, @NotNull final cK cg) {
        this.cf = cf;
        this.cg = cg;
    }
    
    @NotNull
    public cO be() {
        return this.cf;
    }
    
    public void a(@NotNull final cO cf) {
        this.cf = cf;
    }
    
    @NotNull
    public cK bf() {
        return this.cg;
    }
    
    public void a(@NotNull final cK cg) {
        this.cg = cg;
    }
}
