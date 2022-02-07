package net.digitalingot.feather.mixin.client;

import net.minecraftforge.fml.client.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(value = { SplashProgress.class }, remap = false)
public abstract class aq
{
    @Shadow(aliases = { "SplashProgress" }, remap = false)
    private static boolean enabled;
    
    @Inject(method = { "start" }, at = { @At(value = "FIELD", target = "Lnet/minecraftforge/fml/client/SplashProgress;enabled:Z", opcode = 178, remap = false, ordinal = 0) }, remap = false, require = 1, allow = 1)
    private static void a(final CallbackInfo callbackInfo) {
        aq.enabled = true;
    }
    
    @Inject(method = { "finish" }, at = { @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/Drawable;makeCurrent()V", shift = At.Shift.AFTER, remap = false, ordinal = 0) }, remap = false, cancellable = true, require = 1, allow = 1)
    private static void b(final CallbackInfo callbackInfo) {
        callbackInfo.cancel();
    }
}
