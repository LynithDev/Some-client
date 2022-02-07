package net.digitalingot.feather.mixin.client;

import net.minecraft.block.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.world.*;
import net.digitalingot.feather.*;

@Mixin({ Block.class })
public abstract class cr implements jV
{
    @Shadow
    public abstract int func_149750_m();
    
    @Shadow
    public abstract int func_149717_k();
    
    @Override
    public int getLightValue(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        final Block block = ((jX)blockAccess).getBlockState(n, n2, n3).getBlock();
        if (block != this) {
            return ((cr)block).getLightValue(blockAccess, n, n2, n3);
        }
        return this.func_149750_m();
    }
    
    @Override
    public int getLightOpacity(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        return this.func_149717_k();
    }
}
