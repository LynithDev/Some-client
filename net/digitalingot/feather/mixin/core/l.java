package net.digitalingot.feather.mixin.core;

import org.spongepowered.asm.mixin.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.gen.*;

@Mixin({ ChatComponentText.class })
public interface l
{
    @Accessor("text")
    void setText(final String p0);
}
