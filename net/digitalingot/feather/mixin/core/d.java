package net.digitalingot.feather.mixin.core;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.gen.*;

@Mixin({ EntityRenderer.class })
public interface d
{
    @Invoker("loadShader")
    void feather$loadShader(final ResourceLocation p0);
}
