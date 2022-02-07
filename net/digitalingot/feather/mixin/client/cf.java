package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.*;
import net.digitalingot.feather.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

@Mixin({ RenderGlobal.class })
public abstract class cf implements kf
{
    @Inject(method = { "renderSky(Lnet/minecraft/client/renderer/WorldRenderer;FZ)V" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/WorldRenderer;pos(DDD)Lnet/minecraft/client/renderer/WorldRenderer;", ordinal = 0) }, slice = { @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/WorldRenderer;begin(ILnet/minecraft/client/renderer/vertex/VertexFormat;)V")) }, locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void a(final WorldRenderer worldRenderer, final float n, final boolean b, final CallbackInfo callbackInfo, final int n2, final int n3, final int n4, final int n5, final float n6, final float n7) {
        callbackInfo.cancel();
        final jj feather$getPositionSink = this.feather$getPositionSink();
        feather$getPositionSink.e(n6, n, (float)n5);
        feather$getPositionSink.e(n7, n, (float)n5);
        feather$getPositionSink.e(n7, n, (float)(n5 + 64));
        feather$getPositionSink.e(n6, n, (float)(n5 + 64));
    }
}
