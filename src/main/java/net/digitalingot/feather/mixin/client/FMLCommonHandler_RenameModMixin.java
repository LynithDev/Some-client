package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraftforge.fml.common.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(value = { FMLCommonHandler.class }, priority = 1000000)
public class FMLCommonHandler_RenameModMixin
{
    @Inject(method = { "getModName" }, at = { @At("HEAD") }, remap = false, cancellable = true)
    private void rename(final CallbackInfoReturnable<String> callbackInfoReturnable) {
        callbackInfoReturnable.setReturnValue("Feather Forge");
    }
}
