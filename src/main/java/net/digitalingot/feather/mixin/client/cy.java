package net.digitalingot.feather.mixin.client;

import net.minecraft.util.*;
import net.digitalingot.feather.*;
import org.spongepowered.asm.mixin.*;
import java.util.*;

@Mixin({ EnumFacing.class })
public class cy
{
    @Shadow
    @Final
    private int field_176759_h;
    
    @Overwrite
    public EnumFacing func_176734_d() {
        return jT.FR[this.field_176759_h];
    }
    
    @Overwrite
    public static EnumFacing func_82600_a(final int n) {
        return jT.FR[n % EnumFacing.VALUES.length];
    }
    
    @Overwrite
    public static EnumFacing func_176741_a(final Random random) {
        return jT.FR[random.nextInt(jT.FR.length)];
    }
    
    @Overwrite
    public static EnumFacing func_176737_a(final float n, final float n2, final float n3) {
        EnumFacing north = EnumFacing.NORTH;
        float n4 = Float.MIN_VALUE;
        for (final EnumFacing enumFacing : jT.FR) {
            final float n5 = n * enumFacing.getDirectionVec().getX() + n2 * enumFacing.getDirectionVec().getY() + n3 * enumFacing.getDirectionVec().getZ();
            if (n5 > n4) {
                n4 = n5;
                north = enumFacing;
            }
        }
        return north;
    }
    
    @Overwrite
    public static EnumFacing func_181076_a(final EnumFacing.AxisDirection axisDirection, final EnumFacing.Axis axis) {
        for (final EnumFacing enumFacing : jT.FR) {
            if (enumFacing.getAxisDirection() == axisDirection && enumFacing.getAxis() == axis) {
                return enumFacing;
            }
        }
        throw new IllegalArgumentException("No such direction: " + axisDirection + " " + axis);
    }
}
