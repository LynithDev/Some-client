package net.digitalingot.feather.mixin.client;

import net.minecraft.client.renderer.entity.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.entity.*;
import net.digitalingot.feather.*;

@Mixin({ RendererLivingEntity.class })
public abstract class bn<T extends EntityLivingBase> extends Render<T>
{
    @Unique
    private static final dT<fR> Hl;
    
    protected bn(final RenderManager renderManager) {
        super(renderManager);
    }
    
    @Shadow
    protected abstract boolean func_177070_b(final T p0);
    
    @Redirect(method = { "renderName(Lnet/minecraft/entity/EntityLivingBase;DDD)V" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/RendererLivingEntity;canRenderName(Lnet/minecraft/entity/EntityLivingBase;)Z"), require = 1, allow = 1)
    public boolean a(final RendererLivingEntity<T> rendererLivingEntity, final T t) {
        return (bn.Hl.eZ().dI().pJ && t == this.renderManager.livingPlayer && !t.func_82150_aj()) || this.func_177070_b(t);
    }
    
    static {
        Hl = dU.a(fR.class);
    }
}
