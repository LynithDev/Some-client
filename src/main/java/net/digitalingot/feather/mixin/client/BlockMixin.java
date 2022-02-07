package net.digitalingot.feather.mixin.client;

import net.minecraft.block.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.world.*;

@Mixin({ Block.class })
public abstract class BlockMixin implements jV
{
    @Shadow
    public abstract int lightValue();
    
    @Shadow
    public abstract int lightOpacity();
    
    @Override
    public int getLightValue(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        final Block block = ((jX)blockAccess).getBlockState(n, n2, n3).getBlock();
        if (block != this) {
            return ((BlockMixin)block).getLightValue(blockAccess, n, n2, n3);
        }
        return this.lightValue();
    }
    
    @Override
    public int getLightOpacity(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        return this.lightOpacity();
    }
}
