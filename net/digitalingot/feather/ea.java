package net.digitalingot.feather;

import com.google.gson.annotations.*;

public abstract class ea
{
    @er(fu = "hudSelection", fh = "Hud Selection", fW = "true", fm = @em(fS = -2))
    public boolean kX;
    @er(fu = "enabled", fh = "Enabled", fm = @em(fS = -10))
    public transient boolean enabled;
    @SerializedName("favorite")
    public transient boolean jB;
    
    public boolean dG() {
        return this.enabled;
    }
    
    public Boolean fn() {
        return false;
    }
    
    public boolean dH() {
        return this.jB;
    }
}
