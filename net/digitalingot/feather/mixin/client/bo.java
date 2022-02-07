package net.digitalingot.feather.mixin.client;

import net.minecraft.client.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.digitalingot.feather.*;
import java.util.function.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ Minecraft.class })
public class bo
{
    @Shadow
    private int field_71429_W;
    
    @Inject(method = { "clickMouse" }, at = { @At("HEAD") })
    private void r(final CallbackInfo callbackInfo) {
        if (jJ.tC().map((Function<? super jJ, ? extends Boolean>)jJ::tF).orElse(false)) {
            this.field_71429_W = 0;
        }
    }
}
