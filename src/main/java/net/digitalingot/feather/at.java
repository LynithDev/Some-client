package net.digitalingot.feather;

import net.minecraftforge.common.*;

public interface at
{
    default void aL() {
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
}
