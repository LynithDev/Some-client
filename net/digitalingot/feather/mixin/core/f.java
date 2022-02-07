package net.digitalingot.feather.mixin.core;

import org.spongepowered.asm.mixin.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.gen.*;

@Mixin({ FoodStats.class })
public interface f
{
    @Accessor
    float getFoodExhaustionLevel();
}
