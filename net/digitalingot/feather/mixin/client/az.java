package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.world.chunk.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ Chunk.class })
public class az
{
    @ModifyArg(method = { "setBlockState" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/chunk/Chunk;relightBlock(III)V", ordinal = 0), index = 1)
    private int aS(final int n) {
        return n - 1;
    }
}
