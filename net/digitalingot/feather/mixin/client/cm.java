package net.digitalingot.feather.mixin.client;

import net.minecraftforge.client.model.pipeline.*;
import net.digitalingot.feather.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ VertexLighterFlat.class })
public class cm implements kB
{
    @Shadow
    @Final
    protected BlockInfo blockInfo;
    
    @Overwrite(remap = false)
    protected void updateLightmap(final float[] array, final float[] array2, final float n, final float n2, final float n3) {
        final kA ka = (kA)this.blockInfo;
        final boolean full = ka.isFull();
        EnumFacing enumFacing = null;
        if ((full || n2 < -0.99f) && array[1] < -0.95f) {
            enumFacing = EnumFacing.DOWN;
        }
        else if ((full || n2 > 0.99f) && array[1] > 0.95f) {
            enumFacing = EnumFacing.UP;
        }
        else if ((full || n3 < -0.99f) && array[2] < -0.95f) {
            enumFacing = EnumFacing.NORTH;
        }
        else if ((full || n3 > 0.99f) && array[2] > 0.95f) {
            enumFacing = EnumFacing.SOUTH;
        }
        else if ((full || n < -0.99f) && array[0] < -0.95f) {
            enumFacing = EnumFacing.WEST;
        }
        else if ((full || n > 0.99f) && array[0] > 0.95f) {
            enumFacing = EnumFacing.EAST;
        }
        final int n4 = ka.getPackedLight()[(enumFacing == null) ? 0 : (enumFacing.ordinal() + 1)];
        array2[0] = (n4 >> 4 & 0xF) * 32.0f / 65535.0f;
        array2[1] = (n4 >> 20 & 0xF) * 32.0f / 65535.0f;
    }
    
    @Override
    public void resetBlockInfo() {
        ((kA)this.blockInfo).reset();
    }
}
