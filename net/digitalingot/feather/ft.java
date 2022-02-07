package net.digitalingot.feather;

import net.minecraft.init.*;
import net.minecraft.block.*;

@dP(eL = dW.CLEAR_WATER, eM = @dV(fh = "Clear Water", fi = "https://assets.feathercdn.net/game/mods/clearwater.svg", fj = "Removes fog underwater so you can see clearer", fk = {}))
public class ft extends dQ<a>
{
    private float mL;
    private float mM;
    
    @Override
    public void initialize() {
        T.bk.a((blockStaticLiquid, p1) -> {
            if (this.eS()) {
                if (((a)this.jC).mR && blockStaticLiquid == Blocks.water) {
                    return Float.valueOf(this.mL);
                }
                else if (((a)this.jC).mO && blockStaticLiquid == Blocks.lava) {
                    return Float.valueOf(this.mM);
                }
            }
            return null;
        });
    }
    
    @Override
    public void eP() {
        this.mL = N(((a)this.jC).mS);
        this.mM = N(((a)this.jC).mP);
    }
    
    private static float N(final int n) {
        return n * 0.2f / 100.0f;
    }
    
    public static class a extends ea
    {
        @em(fS = 0)
        public eW mN;
        @er(fu = "lava", fh = "Lava", fm = @em(fS = 1))
        public boolean mO;
        @er(fu = "fogDensityLava", fh = "Fog Density", fZ = @en(fu = "lava"), fm = @em(fS = 2))
        @el
        public int mP;
        @em(fS = 10)
        public eW mQ;
        @er(fu = "water", fh = "Water", fW = "true", fm = @em(fS = 11))
        public boolean mR;
        @er(fu = "fogDensityWater", fh = "Fog Density", fZ = @en(fu = "water"), fm = @em(fS = 12))
        @el
        public int mS;
        
        public a() {
            this.mN = new eW("Lava");
            this.mQ = new eW("Water");
        }
    }
}
