package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ ChunkCache.class })
public class ChunkCacheMixin
{
    @Redirect(method = { "getLightForExt" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/util/EnumFacing;values()[Lnet/minecraft/util/EnumFacing;"))
    private EnumFacing[] chunkLightCacheMixin() {
        return jT.FR;
    }
}
