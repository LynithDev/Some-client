package net.digitalingot.feather.mixin.client;

import net.minecraft.block.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.world.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ BlockPortal.class })
public class BlockPortalMixin
{
    @Unique
    private static final dT<fR> Hl;
    
    @Redirect(method = { "randomDisplayTick" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(DDDLjava/lang/String;FFZ)V"))
    public void soundFix(final World world, final double x, final double y, final double z, final String name, final float volume, final float pitch, final boolean distanceDelay) {
        if (BlockPortalMixin.Hl.eZ().dI().qh) {
            world.playSound(x, y, z, name, volume, pitch, distanceDelay);
        }
    }
    
    static {
        Hl = dU.a(fR.class);
    }
}
