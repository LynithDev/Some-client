package net.digitalingot.feather.mixin.client;

import net.minecraft.entity.projectile.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ RenderFish.class })
public abstract class renderFixHookMixin extends Render<EntityFishHook>
{
    @Unique
    private static final dT<fq> HA;
    
    protected renderFixHookMixin(final RenderManager renderManager) {
        super(renderManager);
    }
    
    @Redirect(method = { "doRender(Lnet/minecraft/entity/projectile/EntityFishHook;DDDFF)V" }, at = @At(value = "NEW", target = "Lnet/minecraft/util/Vec3;<init>(DDD)V", ordinal = 0), require = 1, allow = 1)
    private Vec3 fixPosition(double x, double y, double z) {
        final fq fq = renderFixHookMixin.HA.eZ();
        if (fq.eS() && fq.dI().lZ) {
            x = -0.5;
            y = 0.03;
            z = 0.8;
        }
        return new Vec3(x, y, z);
    }
    
    static {
        HA = dU.a(fq.class);
    }
}
