package net.digitalingot.feather.mixin.client;

import net.minecraft.block.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.world.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ BlockPortal.class })
public class bh
{
    @Unique
    private static final dT<fR> Hl;
    
    @Redirect(method = { "randomDisplayTick" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(DDDLjava/lang/String;FFZ)V"))
    public void a(final World world, final double n, final double n2, final double n3, final String s, final float n4, final float n5, final boolean b) {
        if (bh.Hl.eZ().dI().qh) {
            world.playSound(n, n2, n3, s, n4, n5, b);
        }
    }
    
    static {
        Hl = dU.a(fR.class);
    }
}
