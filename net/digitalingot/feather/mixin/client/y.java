package net.digitalingot.feather.mixin.client;

import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ EntityRenderer.class })
public abstract class y implements IResourceManagerReloadListener
{
    @Unique
    private static final dT<fr> Hk;
    @Shadow
    @Final
    private Minecraft field_78531_r;
    
    @Inject(method = { "isDrawBlockOutline" }, at = { @At("HEAD") }, cancellable = true)
    private void a(final CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        final fr fr = y.Hk.eZ();
        if (!fr.eS() || !fr.dI().ms) {
            return;
        }
        if (!(this.field_78531_r.getRenderViewEntity() instanceof EntityPlayer) || this.field_78531_r.gameSettings.hideGUI) {
            callbackInfoReturnable.setReturnValue((Object)false);
            return;
        }
        final MovingObjectPosition objectMouseOver = this.field_78531_r.objectMouseOver;
        final MovingObjectPosition.MovingObjectType block = MovingObjectPosition.MovingObjectType.BLOCK;
        if (objectMouseOver == null || objectMouseOver.typeOfHit != block) {
            callbackInfoReturnable.setReturnValue((Object)false);
            return;
        }
        callbackInfoReturnable.setReturnValue((Object)true);
    }
    
    static {
        Hk = dU.a(fr.class);
    }
}
