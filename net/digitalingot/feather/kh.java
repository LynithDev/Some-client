package net.digitalingot.feather;

import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.world.chunk.*;

public interface kh
{
    boolean isAreaLoaded(final int p0, final int p1, final int p2, final int p3, final boolean p4);
    
    boolean isBlockLoaded(final int p0, final int p1, final int p2);
    
    boolean isBlockLoaded(final int p0, final int p1, final int p2, final boolean p3);
    
    boolean isValid(final int p0, final int p1, final int p2);
    
    boolean canSeeSky(final int p0, final int p1, final int p2);
    
    int getCombinedLight(final int p0, final int p1, final int p2, final int p3);
    
    int getRawLight(final int p0, final int p1, final int p2, final EnumSkyBlock p3);
    
    int getLight(final int p0, final int p1, final int p2, final boolean p3);
    
    int getLightFor(final EnumSkyBlock p0, final int p1, final int p2, final int p3);
    
    int getLightFromNeighbors(final int p0, final int p1, final int p2);
    
    int getLightFromNeighborsFor(final EnumSkyBlock p0, final int p1, final int p2, final int p3);
    
    void setLightFor(final EnumSkyBlock p0, final int p1, final int p2, final int p3, final int p4);
    
    boolean checkLight(final int p0, final int p1, final int p2);
    
    boolean checkLightFor(final EnumSkyBlock p0, final int p1, final int p2, final int p3);
    
    float getLightBrightness(final int p0, final int p1, final int p2);
    
    boolean setBlockState(final int p0, final int p1, final int p2, final IBlockState p3, final int p4);
    
    void markBlockForUpdate(final int p0, final int p1, final int p2);
    
    void markAndNotifyBlock(final int p0, final int p1, final int p2, final Chunk p3, final IBlockState p4, final IBlockState p5, final int p6);
    
    void notifyLightSet(final int p0, final int p1, final int p2);
    
    Chunk getChunkFromBlockCoords(final int p0, final int p1, final int p2);
}
