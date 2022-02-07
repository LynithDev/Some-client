package net.digitalingot.feather.mixin.client;

import net.digitalingot.feather.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.world.*;

@Mixin({ WorldManager.class })
public abstract class cv implements kb
{
    @Override
    public void notifyLightSet(final int n, final int n2, final int n3) {
    }
}
