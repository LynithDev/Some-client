package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.digitalingot.feather.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ RenderGlobal.class })
public class cd implements kf
{
    @Unique
    private jj Ie;
    
    @Inject(method = { "renderSky(Lnet/minecraft/client/renderer/WorldRenderer;FZ)V" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/WorldRenderer;begin(ILnet/minecraft/client/renderer/vertex/VertexFormat;)V", shift = At.Shift.AFTER) })
    private void a(final WorldRenderer worldRenderer, final float n, final boolean b, final CallbackInfo callbackInfo) {
        this.Ie = iO.sS().createSink(ja.EE);
    }
    
    @Inject(method = { "renderSky(Lnet/minecraft/client/renderer/WorldRenderer;FZ)V" }, at = { @At("TAIL") })
    private void b(final WorldRenderer worldRenderer, final float n, final boolean b, final CallbackInfo callbackInfo) {
        this.Ie.tc();
    }
    
    @Override
    public jj feather$getPositionSink() {
        return this.Ie;
    }
}
