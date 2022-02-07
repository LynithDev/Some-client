package net.digitalingot.feather;

import net.minecraft.potion.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.client.entity.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;

@dP(eL = dW.FOV_CHANGER, eM = @dV(fh = "FOV Changer", fi = "https://assets.feathercdn.net/game/mods/fovchanger.svg", fj = "Customize field of view", fk = {}))
public class fv extends dQ<a>
{
    public static final Potion nb;
    public static final Potion nc;
    
    @Override
    public void initialize() {
        EntityPlayerSP thePlayer;
        float n3 = 0.0f;
        final ItemStack itemStack;
        U.bk.a((n, n2) -> {
            if (!this.eS()) {
                return n2;
            }
            else {
                thePlayer = Minecraft.getMinecraft().thePlayer;
                if (((EntityPlayer)thePlayer).func_70051_ag()) {
                    n3 += (float)((a)this.jC).ng;
                }
                if (((EntityPlayer)thePlayer).capabilities.isFlying) {
                    n3 += (float)((a)this.jC).ne;
                }
                if (((EntityPlayer)thePlayer).func_70644_a(fv.nb)) {
                    n3 += (float)((a)this.jC).nh;
                }
                if (((EntityPlayer)thePlayer).func_70644_a(fv.nc)) {
                    n3 -= (float)((a)this.jC).nf;
                }
                ((EntityPlayer)thePlayer).getHeldItem();
                if (((a)this.jC).nd > 0.0 && itemStack != null && itemStack.getItem() instanceof ItemBow) {
                    n3 -= (float)(MathHelper.clamp_float((float)Math.pow((itemStack.getMaxItemUseDuration() - ((EntityPlayer)thePlayer).getItemInUseCount()) / 20.0f, 2.0), 0.0f, 1.0f) * ((a)this.jC).nd);
                }
                return n * n3 / 100.0f;
            }
        });
    }
    
    static {
        nb = Potion.getPotionFromResourceLocation("speed");
        nc = Potion.getPotionFromResourceLocation("slowness");
    }
    
    public static class a extends ea
    {
        @er(fu = "bowZoomModifier", fh = "Bow Zoom", fm = @em(fS = 0))
        @eg(fF = -50.0, fE = 50.0)
        public double nd;
        @er(fu = "flyingModifier", fh = "Flying Modifier", fm = @em(fS = 1))
        @eg(fF = -50.0, fE = 50.0)
        public double ne;
        @er(fu = "slownessModifier", fh = "Slowness Modifier", fm = @em(fS = 2))
        @eg(fF = -50.0, fE = 50.0)
        public double nf;
        @er(fu = "sprintModifier", fh = "Sprint Modifier", fm = @em(fS = 3))
        @eg(fF = -50.0, fE = 50.0)
        public double ng;
        @er(fu = "swiftnessModifier", fh = "Swiftness Modifier", fm = @em(fS = 4))
        @eg(fF = -50.0, fE = 50.0)
        public double nh;
    }
}
