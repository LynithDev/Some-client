package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.world.chunk.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ Chunk.class })
public class chunkBlockLightFix
{
    @ModifyArg(method = { "setBlockState" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/chunk/Chunk;relightBlock(III)V", ordinal = 0), index = 1)
    private int fixBlockLight(int n) {
        return n - 1;
    }
}
