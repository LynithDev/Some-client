package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.settings.*;
import java.util.*;
import org.spongepowered.asm.mixin.gen.*;

@Mixin({ KeyBinding.class })
public interface KeyBindMixin
{
    @Accessor
    default List<KeyBinding> getKeybindArray() {
        throw new AssertionError();
    }
}
