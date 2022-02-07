package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.digitalingot.feather.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ BlockRendererDispatcher.class })
public class cx
{
    @Redirect(method = { "renderBlockDamage" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/util/EnumWorldBlockLayer;values()[Lnet/minecraft/util/EnumWorldBlockLayer;"))
    private EnumWorldBlockLayer[] uA() {
        return jT.FS;
    }
}
