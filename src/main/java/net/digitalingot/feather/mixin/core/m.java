package net.digitalingot.feather.mixin.core;

import org.spongepowered.asm.mixin.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.gen.*;

@Mixin({ ChatComponentTranslation.class })
public interface m
{
    @Accessor("lastTranslationUpdateTimeInMilliseconds")
    void setLastUpdate(final long p0);
}
