package net.digitalingot.feather.mixin.core;

import net.minecraft.client.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.gen.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ Minecraft.class })
public interface h
{
    @Accessor
    @Mutable
    void setSession(final Session p0);
    
    @Accessor("debugFPS")
    default int getFPS() {
        throw new AssertionError();
    }
}
