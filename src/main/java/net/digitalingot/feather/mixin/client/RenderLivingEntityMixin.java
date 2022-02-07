package net.digitalingot.feather.mixin.client;

import net.minecraft.entity.*;
import java.nio.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.entity.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ RendererLivingEntity.class })
public abstract class RenderLivingEntityMixin<T extends EntityLivingBase> extends Render<T>
{
    @Unique
    private static final dT<fR> Hl;
    @Unique
    private static final dT<fq> HA;
    @Shadow
    protected FloatBuffer brightnessBuffer;
    
    protected RenderLivingEntityMixin(final RenderManager renderManager) {
        super(renderManager);
    }
    
    @Inject(method = { "setBrightness(Lnet/minecraft/entity/EntityLivingBase;FZ)Z" }, at = { @At(value = "INVOKE", target = "Ljava/nio/FloatBuffer;put(F)Ljava/nio/FloatBuffer;", remap = false, ordinal = 3, shift = At.Shift.AFTER) }, require = 1, allow = 1)
    private void setBrightness(final T t, final float n, final boolean b, final CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        final fq fq = RenderLivingEntityMixin.HA.eZ();
        if (fq.eS() && fq.dI().mk != net.digitalingot.feather.fq.a.a.DEFAULT) {
            this.brightnessBuffer.position(0);
            fq.a(this.brightnessBuffer);
        }
    }

    @Redirect(method = { "renderName(Lnet/minecraft/entity/EntityLivingBase;DDD)V" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/RendererLivingEntity;canRenderName(Lnet/minecraft/entity/EntityLivingBase;)Z"), require = 1, allow = 1)
    public boolean renderName(final RendererLivingEntity<T> rendererLivingEntity, final T t) {
        return (bn.Hl.eZ().dI().pJ && t == this.renderManager.livingPlayer && !t.isInvisible()) || this.canRenderName(t);
    }

    static {
        Hl = dU.a(fR.class);
    }
    
    static {
        HA = dU.a(fq.class);
    }
}
