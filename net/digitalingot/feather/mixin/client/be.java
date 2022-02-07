package net.digitalingot.feather.mixin.client;

import net.minecraft.entity.*;
import java.nio.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.entity.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ RendererLivingEntity.class })
public abstract class be<T extends EntityLivingBase> extends Render<T>
{
    @Unique
    private static final dT<fq> HA;
    @Shadow
    protected FloatBuffer field_177095_g;
    
    protected be(final RenderManager renderManager) {
        super(renderManager);
    }
    
    @Inject(method = { "setBrightness(Lnet/minecraft/entity/EntityLivingBase;FZ)Z" }, at = { @At(value = "INVOKE", target = "Ljava/nio/FloatBuffer;put(F)Ljava/nio/FloatBuffer;", remap = false, ordinal = 3, shift = At.Shift.AFTER) }, require = 1, allow = 1)
    private void a(final T t, final float n, final boolean b, final CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        final fq fq = be.HA.eZ();
        if (fq.eS() && fq.dI().mk != net.digitalingot.feather.fq.a.a.DEFAULT) {
            this.field_177095_g.position(0);
            fq.a(this.field_177095_g);
        }
    }
    
    static {
        HA = dU.a(fq.class);
    }
}
