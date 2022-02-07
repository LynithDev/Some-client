package net.digitalingot.feather.mixin.client;

import net.minecraft.entity.projectile.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ RenderFish.class })
public abstract class bd extends Render<EntityFishHook>
{
    @Unique
    private static final dT<fq> HA;
    
    protected bd(final RenderManager renderManager) {
        super(renderManager);
    }
    
    @Redirect(method = { "doRender(Lnet/minecraft/entity/projectile/EntityFishHook;DDDFF)V" }, at = @At(value = "NEW", target = "(DDD)Lnet/minecraft/util/Vec3;", ordinal = 0), require = 1, allow = 1)
    private Vec3 g(double n, double n2, double n3) {
        final fq fq = bd.HA.eZ();
        if (fq.eS() && fq.dI().lZ) {
            n = -0.5;
            n2 = 0.03;
            n3 = 0.8;
        }
        return new Vec3(n, n2, n3);
    }
    
    static {
        HA = dU.a(fq.class);
    }
}
