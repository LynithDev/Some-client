package net.digitalingot.feather.mixin.client;

import net.minecraft.world.chunk.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.world.gen.*;
import net.minecraft.crash.*;
import net.minecraft.util.*;

@Mixin({ Chunk.class })
public abstract class ChunkMixin implements jW      // TODO
{
    @Shadow
    @Final
    private World field_76637_e;
    @Shadow
    @Final
    private ExtendedBlockStorage[] field_76652_q;
    @Shadow
    @Final
    private int[] field_76634_f;
    @Shadow
    private boolean field_76643_l;
    
    @Shadow
    public abstract void func_76603_b();
    
    @Override
    public int getLightFor(final EnumSkyBlock enumSkyBlock, final int n, final int n2, final int n3) {
        final int n4 = n & 0xF;
        final int n5 = n3 & 0xF;
        final ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[n2 >> 4];
        return (extendedBlockStorage == null) ? (this.canSeeSky(n, n2, n3) ? enumSkyBlock.defaultLightValue : 0) : ((enumSkyBlock == EnumSkyBlock.SKY) ? (this.field_76637_e.provider.getHasNoSky() ? 0 : extendedBlockStorage.getExtSkylightValue(n4, n2 & 0xF, n5)) : ((enumSkyBlock == EnumSkyBlock.BLOCK) ? extendedBlockStorage.getExtBlocklightValue(n4, n2 & 0xF, n5) : enumSkyBlock.defaultLightValue));
    }
    
    @Override
    public int getLightSubtracted(final int n, final int n2, final int n3, final int n4) {
        final int n5 = n & 0xF;
        final int n6 = n3 & 0xF;
        final ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[n2 >> 4];
        if (extendedBlockStorage == null) {
            return (!this.field_76637_e.provider.getHasNoSky() && n4 < EnumSkyBlock.SKY.defaultLightValue) ? (EnumSkyBlock.SKY.defaultLightValue - n4) : 0;
        }
        int n7 = (this.field_76637_e.provider.getHasNoSky() ? 0 : extendedBlockStorage.getExtSkylightValue(n5, n2 & 0xF, n6)) - n4;
        final int extBlocklightValue = extendedBlockStorage.getExtBlocklightValue(n5, n2 & 0xF, n6);
        if (extBlocklightValue > n7) {
            n7 = extBlocklightValue;
        }
        return n7;
    }
    
    @Override
    public boolean canSeeSky(final int n, final int n2, final int n3) {
        return n2 >= this.field_76634_f[(n3 & 0xF) << 4 | (n & 0xF)];
    }
    
    @Override
    public void setLightFor(final EnumSkyBlock enumSkyBlock, final int n, final int n2, final int n3, final int n4) {
        final int n5 = n & 0xF;
        final int n6 = n3 & 0xF;
        ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[n2 >> 4];
        if (extendedBlockStorage == null) {
            final ExtendedBlockStorage[] field_76652_q = this.field_76652_q;
            final int n7 = n2 >> 4;
            final ExtendedBlockStorage extendedBlockStorage2 = new ExtendedBlockStorage(n2 >> 4 << 4, !this.field_76637_e.provider.getHasNoSky());
            field_76652_q[n7] = extendedBlockStorage2;
            extendedBlockStorage = extendedBlockStorage2;
            this.func_76603_b();
        }
        this.field_76643_l = true;
        if (enumSkyBlock == EnumSkyBlock.SKY) {
            if (!this.field_76637_e.provider.getHasNoSky()) {
                extendedBlockStorage.setExtSkylightValue(n5, n2 & 0xF, n6, n4);
            }
        }
        else if (enumSkyBlock == EnumSkyBlock.BLOCK) {
            extendedBlockStorage.setExtBlocklightValue(n5, n2 & 0xF, n6, n4);
        }
    }
    
    @Override
    public IBlockState getBlockState(final int n, final int n2, final int n3) {
        if (this.field_76637_e.getWorldType() == WorldType.DEBUG_WORLD) {
            IBlockState blockState = null;
            if (n2 == 60) {
                blockState = Blocks.barrier.getDefaultState();
            }
            if (n2 == 70) {
                blockState = ChunkProviderDebug.func_177461_b(n, n3);
            }
            return (blockState == null) ? Blocks.air.getDefaultState() : blockState;
        }
        try {
            if (n2 >= 0 && n2 >> 4 < this.field_76652_q.length) {
                final ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[n2 >> 4];
                if (extendedBlockStorage != null) {
                    return extendedBlockStorage.get(n & 0xF, n2 & 0xF, n3 & 0xF);
                }
            }
            return Blocks.air.getDefaultState();
        }
        catch (Throwable t) {
            final CrashReport crashReport = CrashReport.makeCrashReport(t, "Getting block state");
            crashReport.makeCategory("Block being got").addCrashSectionCallable("Location", () -> CrashReportCategory.getCoordinateInfo(new BlockPos(n, n2, n3)));
            throw new ReportedException(crashReport);
        }
    }
}
