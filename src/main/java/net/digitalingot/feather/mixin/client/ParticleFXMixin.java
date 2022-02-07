package net.digitalingot.feather.mixin.client;

import net.minecraft.client.particle.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.digitalingot.feather.*;

@Mixin({ Barrier.class, EntityBreakingFX.class, EntityFirework.OverlayFX.class })
public abstract class ParticleFXMixin extends EntityFX
{
    @Unique
    private static final dT<fC> PERFORMANCE;
    
    protected ParticleFXMixin(final World world, final double n, final double n2, final double n3) {
        super(world, n, n2, n3);
    }
    
    @Inject(method = { "renderParticle" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/WorldRenderer;pos(DDD)Lnet/minecraft/client/renderer/WorldRenderer;", ordinal = 0) }, locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void renderParticle(final WorldRenderer worldRenderer, final Entity entity, final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final CallbackInfo callbackInfo, final float n7, final float n8, final float n9, final float n10, final float n11, final float n12, final float n13, final float n14, final int n15, final int n16, final int n17) {
        if (ParticleFXMixin.PERFORMANCE.eZ().dI().ou) {
            ((ka)this).addVertices(n12, n13, n14, n2, n3, n4, n5, n6, n7, n8, n9, n10, n15, iL.d(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha), n11);
            callbackInfo.cancel();
        }
    }
    
    static {
        PERFORMANCE = dU.a(fC.class);
    }
}
