package net.digitalingot.feather.mixin.client;

import net.digitalingot.feather.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ RenderGlobal.class })
public abstract class ct implements kb
{
    @Shadow
    protected abstract void func_72725_b(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5);
    
    @Override
    public void notifyLightSet(final int n, final int n2, final int n3) {
        this.func_72725_b(n - 1, n2 - 1, n3 - 1, n + 1, n2 + 1, n3 + 1);
    }
}
