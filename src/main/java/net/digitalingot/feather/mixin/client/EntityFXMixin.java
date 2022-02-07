package net.digitalingot.feather.mixin.client;

import net.minecraft.client.particle.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.digitalingot.feather.*;

@Mixin({ EntityFX.class })
public class EntityFXMixin implements ka
{
    @Unique
    private static final dT<fC> PERFORMANCE;
    @Shadow
    protected float field_70552_h;
    @Shadow
    protected float field_70553_i;
    @Shadow
    protected float field_70551_j;
    @Shadow
    protected float field_82339_as;
    
    @Inject(method = { "renderParticle" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/WorldRenderer;pos(DDD)Lnet/minecraft/client/renderer/WorldRenderer;", ordinal = 0) }, locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void performanceParticles(final WorldRenderer worldRenderer, final Entity entity, final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final CallbackInfo callbackInfo, final float n7, final float n8, final float n9, final float n10, final float n11, final float n12, final float n13, final float n14, final int n15, final int n16, final int n17) {
        if (EntityFXMixin.PERFORMANCE.eZ().dI().ou) {
            this.addVertices(n12, n13, n14, n2, n3, n4, n5, n6, n7, n8, n9, n10, n15, iL.d(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as), n11);
            callbackInfo.cancel();
        }
    }
    
    @Override
    public void addVertices(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8, final float n9, final float n10, final float n11, final float n12, final int n13, final int n14, final float n15) {
        final jh jh = iO.sS().createSink(ja.EI);
        performanceParticles(jh, -1.0f, -1.0f, n4, n5, n6, n7, n8, n, n2, n3, n10, n12, n14, n13, n15);
        performanceParticles(jh, -1.0f, 1.0f, n4, n5, n6, n7, n8, n, n2, n3, n10, n11, n14, n13, n15);
        performanceParticles(jh, 1.0f, 1.0f, n4, n5, n6, n7, n8, n, n2, n3, n9, n11, n14, n13, n15);
        performanceParticles(jh, 1.0f, -1.0f, n4, n5, n6, n7, n8, n, n2, n3, n9, n12, n14, n13, n15);
        jh.tc();
    }
    
    private static void performanceParticles(final jh jh, final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8, final float n9, final float n10, final float n11, final float n12, final int n13, final int n14, final float n15) {
        jh.a(n8 + n3 * n15 * n + n6 * n15 * n2, n9 + n4 * n15 * n2, n10 + n5 * n15 * n + n7 * n15 * n2, n11, n12, n13, n14);
    }
    
    static {
        PERFORMANCE = dU.a(fC.class);
    }
}
