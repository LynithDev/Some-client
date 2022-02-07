package net.digitalingot.feather;

import net.minecraft.client.*;
import net.digitalingot.feather.mixin.core.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;

@dP(eL = dW.MOTION_BLUR, eM = @dV(fh = "Motion Blur", fi = "https://assets.feathercdn.net/game/mods/motionblur.svg", fj = "", fk = { df.a.PVP }))
public class hd extends dQ<a>
{
    @Override
    public void initialize() {
        EntityRenderer entityRenderer;
        final k k;
        an.bE.a(c -> {
            if (!(!this.eS())) {
                if (Minecraft.getMinecraft().theWorld != null) {
                    if (c == an.c.START) {
                        entityRenderer = Minecraft.getMinecraft().entityRenderer;
                        if (entityRenderer.getShaderGroup() != null && Minecraft.getMinecraft().currentScreen == null) {
                            Minecraft.getMinecraft().getResourceManager();
                            if (k instanceof SimpleReloadableResourceManager) {
                                k.getDomainResourceManagers().put("motionblur", new hf(this));
                                ((d)entityRenderer).feather$loadShader(new ResourceLocation("motionblur", "motionblur"));
                            }
                        }
                    }
                }
            }
        });
    }
    
    @Override
    public void eO() {
        Minecraft.getMinecraft().entityRenderer.stopUseShader();
    }
    
    @Override
    public void eP() {
        Minecraft.getMinecraft().entityRenderer.stopUseShader();
    }
    
    public static class a extends ea
    {
        @er(fu = "blurAmount", fh = "Blur Amount", fW = "50", fm = @em(fS = 0))
        @eg(fF = 0.0, fE = 100.0)
        public double yc;
    }
}
