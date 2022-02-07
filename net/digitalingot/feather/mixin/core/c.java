package net.digitalingot.feather.mixin.core;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.chunk.*;
import org.spongepowered.asm.mixin.gen.*;

@Mixin(targets = { "net.minecraft.client.renderer.RenderGlobal$ContainerLocalRenderInformation" })
public interface c
{
    @Accessor("renderChunk")
    RenderChunk getRenderChunk();
}
