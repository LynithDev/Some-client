package net.digitalingot.feather.mixin.client;

import net.minecraft.entity.item.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.entity.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.entity.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ RenderEntityItem.class })
public abstract class bs extends Render<EntityItem>
{
    @Unique
    private static final dT<fy> HO;
    
    protected bs(final RenderManager renderManager) {
        super(renderManager);
    }
    
    @Inject(method = { "doRender(Lnet/minecraft/entity/item/EntityItem;DDDFF)V" }, at = { @At("HEAD") }, cancellable = true, require = 1, allow = 1)
    private void a(final EntityItem entityItem, final double n, final double n2, final double n3, final float n4, final float n5, final CallbackInfo callbackInfo) {
        final fy fy = bs.HO.eZ();
        if (fy != null && fy.eS()) {
            fy.a((Entity)entityItem, n5, n, n2, n3);
            callbackInfo.cancel();
        }
    }
    
    static {
        HO = dU.a(fy.class);
    }
}
