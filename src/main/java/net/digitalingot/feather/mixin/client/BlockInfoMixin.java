package net.digitalingot.feather.mixin.client;

import net.minecraftforge.client.model.pipeline.*;
import net.minecraft.world.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ BlockInfo.class })
public class BlockInfoMixin implements kA
{
    @Shadow(remap = false)
    private IBlockAccess world;
    @Shadow
    private Block block;
    @Shadow
    private BlockPos blockPos;
    @Shadow(remap = false)
    private int cachedTint;
    @Shadow(remap = false)
    private int cachedMultiplier;
    private final int[] If;
    private boolean Ig;
    
    public BlockInfoMixin() {
        this.If = new int[7];
    }
    
    @Override
    public void updateFlatLighting() {
        this.Ig = this.block.isFullCube();
        this.If[0] = this.block.getMixedBrightnessForBlock(this.world, this.blockPos);
        for (final EnumFacing enumFacing : jT.FR) {
            this.If[enumFacing.ordinal() + 1] = this.block.getMixedBrightnessForBlock(this.world, this.blockPos.offset(enumFacing));
        }
    }
    
    @Override
    public void reset() {
        this.world = null;
        this.block = null;
        this.blockPos = null;
        this.cachedTint = -1;
        this.cachedMultiplier = -1;
    }
    
    @Override
    public int[] getPackedLight() {
        return this.If;
    }
    
    @Override
    public boolean isFull() {
        return this.Ig;
    }
    
    @Redirect(method = { "updateLightMatrix" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/util/EnumFacing;values()[Lnet/minecraft/util/EnumFacing;"))
    private EnumFacing[] uw() {
        return jT.FR;
    }
}
