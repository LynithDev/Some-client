package net.digitalingot.feather.mixin.client;

import net.minecraftforge.fluids.*;
import java.util.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ FluidRegistry.class })
public abstract class FluidRegistryMixin
{
    @Unique
    private static Set<Fluid> Ii;
    @Shadow(remap = false)
    static Set<Fluid> bucketFluids;
    
    @Overwrite(remap = false)
    public static Set<Fluid> getBucketFluids() {
        if (FluidRegistryMixin.Ii == null) {
            FluidRegistryMixin.Ii = Collections.unmodifiableSet((Set<? extends Fluid>) FluidRegistryMixin.bucketFluids);
        }
        return FluidRegistryMixin.Ii;
    }
}
