package net.digitalingot.feather.mixin.core;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.gen.*;

@Mixin({ Gui.class })
public interface a
{
    @Accessor("zLevel")
    float getBlitOffset();
}
