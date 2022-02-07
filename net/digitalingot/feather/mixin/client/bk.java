package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import net.digitalingot.feather.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ FallbackResourceManager.class })
public class bk
{
    @ModifyVariable(method = { "getResource" }, at = @At("HEAD"), require = 1)
    public ResourceLocation c(final ResourceLocation resourceLocation) {
        return fQ.a(resourceLocation);
    }
}
