package net.digitalingot.feather.mixin.client;

import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import net.minecraft.scoreboard.ScoreObjective;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.entity.boss.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ GuiIngame.class })
public abstract class GuiIngameMixin extends Gui
{
    @Unique
    private static final dT<gI> HR;

    @Unique
    private static final dT<gw> HI;

    private final Minecraft mc = Minecraft.getMinecraft();
    
    @Inject(method = { "renderBossHealth()V" }, at = { @At(value = "FIELD", target = "Lnet/minecraft/entity/boss/BossStatus;statusBarTime:I", opcode = 179, ordinal = 0, shift = At.Shift.AFTER) }, cancellable = true, require = 1, allow = 1)
    private void m(final CallbackInfo callbackInfo) {
        callbackInfo.cancel();
        final gw gw = GuiIngameMixin.HI.eZ();
        if (!gw.eS() || mc.currentScreen instanceof bz) {
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
        mc.getTextureManager().bindTexture(GuiIngameMixin.icons);
        GlStateManager.popMatrix();
        ek.sP();
        gw.L(19);
    }


    @Inject(method = { "renderScoreboard" }, at = { @At("HEAD") }, cancellable = true)
    protected void a(final ScoreObjective scoreObjective, final ScaledResolution scaledResolution, final CallbackInfo callbackInfo) {
        callbackInfo.cancel();
        bz.HR.eZ().i(new im());
    }
    
    static {
        HI = dU.a(gw.class);
    }
    static {
        HR = dU.a(gI.class);
    }
}
