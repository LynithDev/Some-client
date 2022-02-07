package net.digitalingot.feather.mixin.client;

import net.minecraft.client.multiplayer.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ PlayerControllerMP.class })
public abstract class bc
{
    @Unique
    private static final dT<fq> HA;
    
    @Inject(method = { "getIsHittingBlock()Z" }, at = { @At("HEAD") }, cancellable = true, require = 1, allow = 1)
    private void d(final CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        final fq fq = bc.HA.eZ();
        if (fq.eS() && fq.dI().lX) {
            callbackInfoReturnable.setReturnValue((Object)false);
        }
    }
    
    static {
        HA = dU.a(fq.class);
    }
}
