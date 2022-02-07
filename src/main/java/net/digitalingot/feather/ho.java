package net.digitalingot.feather;

import com.google.gson.annotations.*;

public class ho
{
    @SerializedName("lat")
    private final double yN;
    @SerializedName("lon")
    private final double yO;
    
    public static ho jg() {
        return jt.aM("http://ip-api.com/json/?fields=192").h(ho.class);
    }
    
    public ho(final double yn, final double yo) {
        this.yN = yn;
        this.yO = yo;
    }
    
    public double jh() {
        return this.yN;
    }
    
    public double ji() {
        return this.yO;
    }
}
