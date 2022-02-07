package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraftforge.fml.client.*;
import org.spongepowered.asm.mixin.gen.*;
import java.util.concurrent.*;

@Mixin(value = { SplashProgress.class }, remap = false)
public interface SplashProgressAccessorMixin
{
    @Accessor(value = "done", remap = false)
    default boolean isDone() {
        throw new IllegalStateException();
    }
    
    @Accessor(value = "pause", remap = false)
    default boolean isPaused() {
        throw new IllegalStateException();
    }
    
    @Accessor(value = "mutex", remap = false)
    default Semaphore getMutex() {
        throw new IllegalStateException();
    }
}
