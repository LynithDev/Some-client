package net.digitalingot.feather.mixin.core;

import org.spongepowered.asm.mixin.*;
import java.util.*;
import net.minecraft.client.resources.*;
import org.spongepowered.asm.mixin.gen.*;

@Mixin({ SimpleReloadableResourceManager.class })
public interface k
{
    @Accessor
    Map<String, FallbackResourceManager> getDomainResourceManagers();
}
