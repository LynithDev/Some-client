package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.scoreboard.*;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ GuiIngame.class })
public class bz
{
    @Unique
    private static final dT<gI> HR;
    
    @Inject(method = { "renderScoreboard" }, at = { @At("HEAD") }, cancellable = true)
    protected void a(final ScoreObjective scoreObjective, final ScaledResolution scaledResolution, final CallbackInfo callbackInfo) {
        callbackInfo.cancel();
        bz.HR.eZ().i(new im());
    }
    
    static {
        HR = dU.a(gI.class);
    }
}
