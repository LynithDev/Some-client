package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.world.storage.*;
import net.minecraftforge.common.util.*;
import net.minecraft.profiler.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.digitalingot.feather.*;
import java.util.*;

@Mixin({ World.class })
public abstract class cu implements jX, kh
{
    @Shadow
    @Final
    public WorldProvider field_73011_w;
    @Shadow
    private int field_73008_k;
    @Shadow
    @Final
    public boolean field_72995_K;
    @Shadow
    protected WorldInfo field_72986_A;
    @Shadow
    public boolean captureBlockSnapshots;
    @Shadow
    public ArrayList<BlockSnapshot> capturedBlockSnapshots;
    @Shadow
    @Final
    public Profiler field_72984_F;
    @Shadow
    protected List<IWorldAccess> field_73021_x;
    @Shadow
    private int[] field_72994_J;
    
    @Shadow
    protected abstract boolean func_175680_a(final int p0, final int p1, final boolean p2);
    
    @Shadow
    public abstract Chunk func_72964_e(final int p0, final int p1);
    
    @Shadow
    protected abstract boolean func_175663_a(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5, final boolean p6);
    
    @Override
    public boolean isAreaLoaded(final int n, final int n2, final int n3, final int n4, final boolean b) {
        return this.func_175663_a(n - n4, n2 - n4, n3 - n4, n + n4, n2 + n4, n3 + n4, b);
    }
    
    @Override
    public boolean isBlockLoaded(final int n, final int n2, final int n3) {
        return this.isBlockLoaded(n, n2, n3, true);
    }
    
    @Override
    public boolean isBlockLoaded(final int n, final int n2, final int n3, final boolean b) {
        return this.isValid(n, n2, n3) && this.func_175680_a(n >> 4, n3 >> 4, b);
    }
    
    @Override
    public boolean isValid(final int n, final int n2, final int n3) {
        return n >= -30000000 && n3 >= -30000000 && n < 30000000 && n3 < 30000000 && n2 >= 0 && n2 < 256;
    }
    
    @Override
    public boolean canSeeSky(final int n, final int n2, final int n3) {
        return ((jW)this.getChunkFromBlockCoords(n, n2, n3)).canSeeSky(n, n2, n3);
    }
    
    @Override
    public int getCombinedLight(final int n, final int n2, final int n3, final int n4) {
        final int lightFromNeighbors = this.getLightFromNeighborsFor(EnumSkyBlock.SKY, n, n2, n3);
        int lightFromNeighbors2 = this.getLightFromNeighborsFor(EnumSkyBlock.BLOCK, n, n2, n3);
        if (lightFromNeighbors2 < n4) {
            lightFromNeighbors2 = n4;
        }
        return lightFromNeighbors << 20 | lightFromNeighbors2 << 4;
    }
    
    @Override
    public int getRawLight(final int n, final int n2, final int n3, final EnumSkyBlock enumSkyBlock) {
        if (enumSkyBlock == EnumSkyBlock.SKY && this.canSeeSky(n, n2, n3)) {
            return 15;
        }
        final jV jv = (jV)this.getBlockState(n, n2, n3).getBlock();
        final int lightValue = jv.getLightValue((IBlockAccess)this, n, n2, n3);
        int n4 = (enumSkyBlock == EnumSkyBlock.SKY) ? 0 : lightValue;
        int lightOpacity = jv.getLightOpacity((IBlockAccess)this, n, n2, n3);
        if (lightOpacity >= 15 && lightValue > 0) {
            lightOpacity = 1;
        }
        if (lightOpacity < 1) {
            lightOpacity = 1;
        }
        if (lightOpacity >= 15) {
            return 0;
        }
        if (n4 >= 14) {
            return n4;
        }
        for (final EnumFacing enumFacing : jT.FR) {
            final int n5 = this.getLightFor(enumSkyBlock, n + enumFacing.getFrontOffsetX(), n2 + enumFacing.getFrontOffsetY(), n3 + enumFacing.getFrontOffsetZ()) - lightOpacity;
            if (n5 > n4) {
                n4 = n5;
            }
            if (n4 >= 14) {
                return n4;
            }
        }
        return n4;
    }
    
    @Override
    public float getLightBrightness(final int n, final int n2, final int n3) {
        return this.field_73011_w.getLightBrightnessTable()[this.getLightFromNeighbors(n, n2, n3)];
    }
    
    @Override
    public int getLight(final int n, int n2, final int n3, final boolean b) {
        if (n < -30000000 || n3 < -30000000 || n >= 30000000 || n3 >= 30000000) {
            return 15;
        }
        if (b && this.getBlockState(n, n2, n3).getBlock().getUseNeighborBrightness()) {
            int light = this.getLight(n, n2 + 1, n3, false);
            final int light2 = this.getLight(n + 1, n2, n3, false);
            final int light3 = this.getLight(n - 1, n2, n3, false);
            final int light4 = this.getLight(n, n2, n3 + 1, false);
            final int light5 = this.getLight(n, n2, n3 - 1, false);
            if (light2 > light) {
                light = light2;
            }
            if (light3 > light) {
                light = light3;
            }
            if (light4 > light) {
                light = light4;
            }
            if (light5 > light) {
                light = light5;
            }
            return light;
        }
        if (n2 < 0) {
            return 0;
        }
        if (n2 >= 256) {
            n2 = 255;
        }
        return ((jW)this.getChunkFromBlockCoords(n, n2, n3)).getLightSubtracted(n, n2, n3, this.field_73008_k);
    }
    
    @Override
    public int getLightFor(final EnumSkyBlock enumSkyBlock, final int n, int n2, final int n3) {
        if (n2 < 0) {
            n2 = 0;
        }
        if (!this.isValid(n, n2, n3)) {
            return enumSkyBlock.defaultLightValue;
        }
        if (!this.isBlockLoaded(n, n2, n3)) {
            return enumSkyBlock.defaultLightValue;
        }
        return ((jW)this.getChunkFromBlockCoords(n, n2, n3)).getLightFor(enumSkyBlock, n, n2, n3);
    }
    
    @Override
    public int getLightFromNeighbors(final int n, final int n2, final int n3) {
        return this.getLight(n, n2, n3, true);
    }
    
    @Override
    public int getLightFromNeighborsFor(final EnumSkyBlock enumSkyBlock, final int n, int n2, final int n3) {
        if (this.field_73011_w.getHasNoSky() && enumSkyBlock == EnumSkyBlock.SKY) {
            return 0;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (!this.isValid(n, n2, n3)) {
            return enumSkyBlock.defaultLightValue;
        }
        if (!this.isBlockLoaded(n, n2, n3)) {
            return enumSkyBlock.defaultLightValue;
        }
        if (this.getBlockState(n, n2, n3).getBlock().getUseNeighborBrightness()) {
            int light = this.getLightFor(enumSkyBlock, n, n2 + 1, n3);
            final int light2 = this.getLightFor(enumSkyBlock, n + 1, n2, n3);
            final int light3 = this.getLightFor(enumSkyBlock, n - 1, n2, n3);
            final int light4 = this.getLightFor(enumSkyBlock, n, n2, n3 + 1);
            final int light5 = this.getLightFor(enumSkyBlock, n, n2, n3 - 1);
            if (light2 > light) {
                light = light2;
            }
            if (light3 > light) {
                light = light3;
            }
            if (light4 > light) {
                light = light4;
            }
            if (light5 > light) {
                light = light5;
            }
            return light;
        }
        return ((jW)this.getChunkFromBlockCoords(n, n2, n3)).getLightFor(enumSkyBlock, n, n2, n3);
    }
    
    @Override
    public void setLightFor(final EnumSkyBlock enumSkyBlock, final int n, final int n2, final int n3, final int n4) {
        if (this.isValid(n, n2, n3) && this.isBlockLoaded(n, n2, n3)) {
            ((jW)this.getChunkFromBlockCoords(n, n2, n3)).setLightFor(enumSkyBlock, n, n2, n3, n4);
            this.notifyLightSet(n, n2, n3);
        }
    }
    
    @Override
    public boolean checkLight(final int n, final int n2, final int n3) {
        boolean checkLight = false;
        if (!this.field_73011_w.getHasNoSky()) {
            checkLight = this.checkLightFor(EnumSkyBlock.SKY, n, n2, n3);
        }
        return checkLight | this.checkLightFor(EnumSkyBlock.BLOCK, n, n2, n3);
    }
    
    @Override
    public boolean checkLightFor(final EnumSkyBlock enumSkyBlock, final int n, final int n2, final int n3) {
        if (!this.isAreaLoaded(n, n2, n3, 17, false)) {
            return false;
        }
        int i = 0;
        int n4 = 0;
        this.field_72984_F.startSection("getBrightness");
        final int light = this.getLightFor(enumSkyBlock, n, n2, n3);
        final int rawLight = this.getRawLight(n, n2, n3, enumSkyBlock);
        if (rawLight > light) {
            this.field_72994_J[n4++] = 133152;
        }
        else if (rawLight < light) {
            this.field_72994_J[n4++] = (0x20820 | light << 18);
            while (i < n4) {
                final int n5 = this.field_72994_J[i++];
                final int n6 = (n5 & 0x3F) - 32 + n;
                final int n7 = (n5 >> 6 & 0x3F) - 32 + n2;
                final int n8 = (n5 >> 12 & 0x3F) - 32 + n3;
                final int n9 = n5 >> 18 & 0xF;
                if (this.getLightFor(enumSkyBlock, n6, n7, n8) == n9) {
                    this.setLightFor(enumSkyBlock, n6, n7, n8, 0);
                    if (n9 <= 0 || MathHelper.abs_int(n6 - n) + MathHelper.abs_int(n7 - n2) + MathHelper.abs_int(n8 - n3) >= 17) {
                        continue;
                    }
                    for (final EnumFacing enumFacing : jT.FR) {
                        final int n10 = n6 + enumFacing.getFrontOffsetX();
                        final int n11 = n7 + enumFacing.getFrontOffsetY();
                        final int n12 = n8 + enumFacing.getFrontOffsetZ();
                        final int max = Math.max(1, this.getBlockState(n10, n11, n12).getBlock().getLightOpacity());
                        if (this.getLightFor(enumSkyBlock, n10, n11, n12) == n9 - max && n4 < this.field_72994_J.length) {
                            this.field_72994_J[n4++] = (n10 - n + 32 | n11 - n2 + 32 << 6 | n12 - n3 + 32 << 12 | n9 - max << 18);
                        }
                    }
                }
            }
            i = 0;
        }
        this.field_72984_F.endSection();
        this.field_72984_F.startSection("checkedPosition < toCheckCount");
        while (i < n4) {
            final int n13 = this.field_72994_J[i++];
            final int n14 = (n13 & 0x3F) - 32 + n;
            final int n15 = (n13 >> 6 & 0x3F) - 32 + n2;
            final int n16 = (n13 >> 12 & 0x3F) - 32 + n3;
            final int light2 = this.getLightFor(enumSkyBlock, n14, n15, n16);
            final int rawLight2 = this.getRawLight(n14, n15, n16, enumSkyBlock);
            if (rawLight2 != light2) {
                this.setLightFor(enumSkyBlock, n14, n15, n16, rawLight2);
                if (rawLight2 <= light2) {
                    continue;
                }
                final int abs = Math.abs(n14 - n);
                final int abs2 = Math.abs(n15 - n2);
                final int abs3 = Math.abs(n16 - n3);
                final boolean b = n4 < this.field_72994_J.length - 6;
                if (abs + abs2 + abs3 >= 17 || !b) {
                    continue;
                }
                if (this.getLightFor(enumSkyBlock, n14 - 1, n15, n16) < rawLight2) {
                    this.field_72994_J[n4++] = n14 - 1 - n + 32 + (n15 - n2 + 32 << 6) + (n16 - n3 + 32 << 12);
                }
                if (this.getLightFor(enumSkyBlock, n14 + 1, n15, n16) < rawLight2) {
                    this.field_72994_J[n4++] = n14 + 1 - n + 32 + (n15 - n2 + 32 << 6) + (n16 - n3 + 32 << 12);
                }
                if (this.getLightFor(enumSkyBlock, n14, n15 - 1, n16) < rawLight2) {
                    this.field_72994_J[n4++] = n14 - n + 32 + (n15 - 1 - n2 + 32 << 6) + (n16 - n3 + 32 << 12);
                }
                if (this.getLightFor(enumSkyBlock, n14, n15 + 1, n16) < rawLight2) {
                    this.field_72994_J[n4++] = n14 - n + 32 + (n15 + 1 - n2 + 32 << 6) + (n16 - n3 + 32 << 12);
                }
                if (this.getLightFor(enumSkyBlock, n14, n15, n16 - 1) < rawLight2) {
                    this.field_72994_J[n4++] = n14 - n + 32 + (n15 - n2 + 32 << 6) + (n16 - 1 - n3 + 32 << 12);
                }
                if (this.getLightFor(enumSkyBlock, n14, n15, n16 + 1) >= rawLight2) {
                    continue;
                }
                this.field_72994_J[n4++] = n14 - n + 32 + (n15 - n2 + 32 << 6) + (n16 + 1 - n3 + 32 << 12);
            }
        }
        this.field_72984_F.endSection();
        return true;
    }
    
    @Override
    public IBlockState getBlockState(final int n, final int n2, final int n3) {
        if (!this.isValid(n, n2, n3)) {
            return Blocks.air.getDefaultState();
        }
        return ((jW)this.getChunkFromBlockCoords(n, n2, n3)).getBlockState(n, n2, n3);
    }
    
    @Override
    public boolean setBlockState(final int n, final int n2, final int n3, final IBlockState blockState, final int n4) {
        if (!this.isValid(n, n2, n3)) {
            return false;
        }
        if (!this.field_72995_K && this.field_72986_A.getTerrainType() == WorldType.DEBUG_WORLD) {
            return false;
        }
        final Chunk chunkFromBlockCoords = this.getChunkFromBlockCoords(n, n2, n3);
        final jV jv = (jV)blockState.getBlock();
        BlockSnapshot blockSnapshot = null;
        if (this.captureBlockSnapshots && !this.field_72995_K) {
            blockSnapshot = BlockSnapshot.getBlockSnapshot((World)this, new BlockPos(n, n2, n3), n4);
            this.capturedBlockSnapshots.add(blockSnapshot);
        }
        final jV jv2 = (jV)this.getBlockState(n, n2, n3).getBlock();
        final int lightValue = jv2.getLightValue((IBlockAccess)this, n, n2, n3);
        final int lightOpacity = jv2.getLightOpacity((IBlockAccess)this, n, n2, n3);
        final IBlockState blockState2 = null;
        if (blockState2 == null) {
            if (blockSnapshot != null) {
                this.capturedBlockSnapshots.remove(blockSnapshot);
            }
            return false;
        }
        if (jv.getLightOpacity((IBlockAccess)this, n, n2, n3) != lightOpacity || jv.getLightValue((IBlockAccess)this, n, n2, n3) != lightValue) {
            this.field_72984_F.startSection("checkLight");
            this.checkLight(n, n2, n3);
            this.field_72984_F.endSection();
        }
        if (blockSnapshot == null) {
            this.markAndNotifyBlock(n, n2, n3, chunkFromBlockCoords, blockState2, blockState, n4);
        }
        return true;
    }
    
    @Override
    public void markBlockForUpdate(final int n, final int n2, final int n3) {
        final Iterator<IWorldAccess> iterator = this.field_73021_x.iterator();
        while (iterator.hasNext()) {
            ((kb)iterator.next()).markBlockForUpdate(n, n2, n3);
        }
    }
    
    @Override
    public void markAndNotifyBlock(final int n, final int n2, final int n3, final Chunk chunk, final IBlockState blockState, final IBlockState blockState2, final int n4) {
        if ((n4 & 0x2) != 0x0 && (!this.field_72995_K || (n4 & 0x4) == 0x0) && (chunk == null || chunk.isPopulated())) {
            this.markBlockForUpdate(n, n2, n3);
        }
        if (this.field_72995_K || (n4 & 0x1) == 0x0 || blockState2.getBlock().hasComparatorInputOverride()) {}
    }
    
    @Override
    public void notifyLightSet(final int n, final int n2, final int n3) {
        final Iterator<IWorldAccess> iterator = this.field_73021_x.iterator();
        while (iterator.hasNext()) {
            ((kb)iterator.next()).notifyLightSet(n, n2, n3);
        }
    }
    
    @Override
    public Chunk getChunkFromBlockCoords(final int n, final int n2, final int n3) {
        return this.func_72964_e(n >> 4, n3 >> 4);
    }
}
