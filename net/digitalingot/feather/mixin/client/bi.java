package net.digitalingot.feather.mixin.client;

import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.texture.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ EntityRenderer.class })
public class bi
{
    @Unique
    private static final dT<fR> Hl;
    @Shadow
    private Minecraft field_78531_r;
    @Shadow
    @Final
    private int[] field_78504_Q;
    @Shadow
    @Final
    private DynamicTexture field_78513_d;
    @Shadow
    private boolean field_78536_aa;
    
    @Inject(method = { "updateLightmap" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/profiler/Profiler;startSection(Ljava/lang/String;)V", shift = At.Shift.BEFORE, ordinal = 0) }, cancellable = true, require = 1, allow = 1)
    private void o(final CallbackInfo callbackInfo) {
        if (this.field_78531_r.theWorld == null) {
            return;
        }
        final fR fr = bi.Hl.eZ();
        if (fr == null || !fr.eS() || !fr.dI().pI) {
            return;
        }
        callbackInfo.cancel();
        for (int i = 0; i < 256; ++i) {
            this.field_78504_Q[i] = -1;
        }
        this.field_78513_d.updateDynamicTexture();
        this.field_78536_aa = false;
    }
    
    static {
        Hl = dU.a(fR.class);
    }
}
