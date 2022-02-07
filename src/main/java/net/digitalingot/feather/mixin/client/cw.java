package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.util.*;

@Mixin({ BlockPos.class })
public abstract class cw extends Vec3i
{
    public cw(final int n, final int n2, final int n3) {
        super(n, n2, n3);
    }
    
    @Overwrite
    public BlockPos func_177984_a() {
        return new BlockPos(this.getX(), this.getY() + 1, this.getZ());
    }
    
    @Overwrite
    public BlockPos func_177981_b(final int n) {
        return new BlockPos(this.getX(), this.getY() + n, this.getZ());
    }
    
    @Overwrite
    public BlockPos func_177977_b() {
        return new BlockPos(this.getX(), this.getY() - 1, this.getZ());
    }
    
    @Overwrite
    public BlockPos func_177979_c(final int n) {
        return new BlockPos(this.getX(), this.getY() - n, this.getZ());
    }
    
    @Overwrite
    public BlockPos func_177978_c() {
        return new BlockPos(this.getX(), this.getY(), this.getZ() - 1);
    }
    
    @Overwrite
    public BlockPos func_177964_d(final int n) {
        return new BlockPos(this.getX(), this.getY(), this.getZ() - n);
    }
    
    @Overwrite
    public BlockPos func_177968_d() {
        return new BlockPos(this.getX(), this.getY(), this.getZ() + 1);
    }
    
    @Overwrite
    public BlockPos func_177970_e(final int n) {
        return new BlockPos(this.getX(), this.getY(), this.getZ() + n);
    }
    
    @Overwrite
    public BlockPos func_177976_e() {
        return new BlockPos(this.getX() - 1, this.getY(), this.getZ());
    }
    
    @Overwrite
    public BlockPos func_177985_f(final int n) {
        return new BlockPos(this.getX() - n, this.getY(), this.getZ());
    }
    
    @Overwrite
    public BlockPos func_177974_f() {
        return new BlockPos(this.getX() + 1, this.getY(), this.getZ());
    }
    
    @Overwrite
    public BlockPos func_177965_g(final int n) {
        return new BlockPos(this.getX() + n, this.getY(), this.getZ());
    }
    
    @Overwrite
    public BlockPos func_177972_a(final EnumFacing enumFacing) {
        return new BlockPos(this.getX() + enumFacing.getFrontOffsetX(), this.getY() + enumFacing.getFrontOffsetY(), this.getZ() + enumFacing.getFrontOffsetZ());
    }
    
    @Overwrite
    public BlockPos func_177967_a(final EnumFacing enumFacing, final int n) {
        return new BlockPos(this.getX() + enumFacing.getFrontOffsetX() * n, this.getY() + enumFacing.getFrontOffsetY() * n, this.getZ() + enumFacing.getFrontOffsetZ() * n);
    }
}
