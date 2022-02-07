package net.digitalingot.feather.mixin.client;

import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.entity.boss.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ GuiIngame.class })
public abstract class bf extends Gui
{
    @Unique
    private static final dT<gw> HI;
    @Final
    @Shadow
    protected Minecraft field_73839_d;
    
    @Inject(method = { "renderBossHealth()V" }, at = { @At(value = "FIELD", target = "Lnet/minecraft/entity/boss/BossStatus;statusBarTime:I", opcode = 179, ordinal = 0, shift = At.Shift.AFTER) }, cancellable = true, require = 1, allow = 1)
    private void m(final CallbackInfo callbackInfo) {
        callbackInfo.cancel();
        final gw gw = bf.HI.eZ();
        if (!gw.eS() || this.field_73839_d.currentScreen instanceof bz) {
            return;
        }
        final iJ ek = gw.eK();
        ek.sQ();
        final gw.a a = gw.dI();
        final int eb = gw.eB();
        final int n = (int)(BossStatus.healthScale * (eb + 1));
        final double fr = gw.dI().fr();
        GlStateManager.pushMatrix();
        GlStateManager.translate(gw.ez(), gw.eA(), 0.0);
        GlStateManager.scale(fr, fr, 0.0);
        this.drawTexturedModalRect(0, 12, 0, 74, 182, 5);
        this.drawTexturedModalRect(0, 12, 0, 74, 182, 5);
        if (n > 0) {
            this.drawTexturedModalRect(0, 12, 0, 79, n, 5);
        }
        final String bossName = BossStatus.bossName;
        ek.a(bossName, (float)((eb - ek.V(bossName)) / 2), 2.0f, a.lg, a.lh);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73839_d.getTextureManager().bindTexture(bf.icons);
        GlStateManager.popMatrix();
        ek.sP();
        gw.L(19);
    }
    
    static {
        HI = dU.a(gw.class);
    }
}
