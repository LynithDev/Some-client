package net.digitalingot.feather.mixin.core;

import org.spongepowered.asm.mixin.*;
import java.util.*;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.gen.*;

@Mixin({ GuiScreen.class })
public interface j
{
    @Accessor("buttonList")
    List<GuiButton> getRenderables();
}
