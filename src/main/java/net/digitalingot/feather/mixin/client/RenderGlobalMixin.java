package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.digitalingot.feather.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ RenderGlobal.class })
public class RenderGlobalMixin implements kf
{
    @Unique
    private jj Ie;
    
    @Inject(method = { "renderSky(Lnet/minecraft/client/renderer/WorldRenderer;FZ)V" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/WorldRenderer;begin(ILnet/minecraft/client/renderer/vertex/VertexFormat;)V", shift = At.Shift.AFTER) })
    private void renderSky(final WorldRenderer worldRenderer, final float n, final boolean b, final CallbackInfo callbackInfo) {
        this.Ie = iO.sS().createSink(ja.EE);
    }
    
    @Inject(method = { "renderSky(Lnet/minecraft/client/renderer/WorldRenderer;FZ)V" }, at = { @At("TAIL") })
    private void renderSkyEnd(final WorldRenderer worldRenderer, final float n, final boolean b, final CallbackInfo callbackInfo) {
        this.Ie.tc();
    }

    @Inject(method = { "renderSky(Lnet/minecraft/client/renderer/WorldRenderer;FZ)V" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/WorldRenderer;pos(DDD)Lnet/minecraft/client/renderer/WorldRenderer;", ordinal = 0) }, slice = { @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/WorldRenderer;begin(ILnet/minecraft/client/renderer/vertex/VertexFormat;)V")) }, locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void renderSkySomething(final WorldRenderer worldRenderer, final float n, final boolean b, final CallbackInfo callbackInfo, final int n2, final int n3, final int n4, final int n5, final int n6, final float n7, final float n8) {
        callbackInfo.cancel();
        final jj feather$getPositionSink = this.feather$getPositionSink();
        feather$getPositionSink.e(n7, n, (float)n6);
        feather$getPositionSink.e(n8, n, (float)n6);
        feather$getPositionSink.e(n8, n, (float)(n6 + 64));
        feather$getPositionSink.e(n7, n, (float)(n6 + 64));
    }

    @Inject(method = { "renderSky(Lnet/minecraft/client/renderer/WorldRenderer;FZ)V" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/WorldRenderer;pos(DDD)Lnet/minecraft/client/renderer/WorldRenderer;", ordinal = 0) }, slice = { @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/WorldRenderer;begin(ILnet/minecraft/client/renderer/vertex/VertexFormat;)V")) }, locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void renderSkySomethingAgain(final WorldRenderer worldRenderer, final float n, final boolean b, final CallbackInfo callbackInfo, final int n2, final int n3, final int n4, final int n5, final float n6, final float n7) {
        callbackInfo.cancel();
        final jj feather$getPositionSink = this.feather$getPositionSink();
        feather$getPositionSink.e(n6, n, (float)n5);
        feather$getPositionSink.e(n7, n, (float)n5);
        feather$getPositionSink.e(n7, n, (float)(n5 + 64));
        feather$getPositionSink.e(n6, n, (float)(n5 + 64));
    }
    
    @Override
    public jj feather$getPositionSink() {
        return this.Ie;
    }
}
