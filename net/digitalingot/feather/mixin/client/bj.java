package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraftforge.fml.common.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(value = { FMLCommonHandler.class }, priority = 1000000)
public class bj
{
    @Inject(method = { "getModName" }, at = { @At("HEAD") }, remap = false, cancellable = true)
    private void e(final CallbackInfoReturnable<String> callbackInfoReturnable) {
        callbackInfoReturnable.setReturnValue((Object)"Feather Forge");
    }
}
