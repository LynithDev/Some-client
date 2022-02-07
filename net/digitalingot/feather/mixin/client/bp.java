package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ ItemRenderer.class })
public class bp
{
    private static final dT<fR> HK;
    
    @Inject(method = { "renderFireInFirstPerson" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;translate(FFF)V") })
    private void s(final CallbackInfo callbackInfo) {
        GlStateManager.translate(0.0, -0.4000000059604645 * (1.0 - bp.HK.eZ().dI().pM), 0.0);
    }
    
    static {
        HK = dU.a(fR.class);
    }
}
