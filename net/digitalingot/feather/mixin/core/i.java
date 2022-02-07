package net.digitalingot.feather.mixin.core;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.gen.*;
import java.util.*;

@Mixin({ RenderGlobal.class })
public interface i
{
    @Accessor
    ViewFrustum getViewFrustum();
    
    @Accessor
    List<Object> getRenderInfos();
}
