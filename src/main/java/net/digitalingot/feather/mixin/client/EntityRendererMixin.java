package net.digitalingot.feather.mixin.client;

import net.digitalingot.feather.fr;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.texture.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ EntityRenderer.class })
public class EntityRendererMixin
{
    @Unique
    private static final dT<fR> Hl;
    @Unique
    private static final dT<fr> Hk;

    private final Minecraft mc = Minecraft.getMinecraft();

    @Shadow
    @Final
    private int[] lightmapColors;
    @Shadow
    @Final
    private DynamicTexture lightmapTexture;
    @Shadow
    private boolean lightmapUpdateNeeded;
    
    @Inject(method = { "updateLightmap" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/profiler/Profiler;startSection(Ljava/lang/String;)V", shift = At.Shift.BEFORE, ordinal = 0) }, cancellable = true, require = 1, allow = 1)
    private void fixLighting(final CallbackInfo callbackInfo) {
        if (this.mc.theWorld == null) {
            return;
        }
        final fR fr = EntityRendererMixin.Hl.eZ();
        if (fr == null || !fr.eS() || !fr.dI().pI) {
            return;
        }
        callbackInfo.cancel();
        for (int i = 0; i < 256; ++i) {
            this.lightmapColors[i] = -1;
        }
        this.lightmapTexture.updateDynamicTexture();
        this.lightmapUpdateNeeded = false;
    }

    @Inject(method = { "isDrawBlockOutline" }, at = { @At("HEAD") }, cancellable = true)
    private void drawBlockOutline(final CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        final fr fr = y.Hk.eZ();
        if (!fr.eS() || !fr.dI().ms) {
            return;
        }
        if (!(this.mc.getRenderViewEntity() instanceof EntityPlayer) || this.mc.gameSettings.hideGUI) {
            callbackInfoReturnable.setReturnValue(false);
            return;
        }
        final MovingObjectPosition objectMouseOver = this.mc.objectMouseOver;
        final MovingObjectPosition.MovingObjectType block = MovingObjectPosition.MovingObjectType.BLOCK;
        if (objectMouseOver == null || objectMouseOver.typeOfHit != block) {
            callbackInfoReturnable.setReturnValue(false);
            return;
        }
        callbackInfoReturnable.setReturnValue(true);
    }

    
    static {
        Hl = dU.a(fR.class);
    }
    static {
        Hk = dU.a(fr.class);
    }
}
