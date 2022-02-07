package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.client.entity.*;

public class gk implements ix
{
    @Override
    public void U(@NotNull final String s) {
        final ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation(s, new Object[0]);
        final EntityPlayerSP thePlayer = Minecraft.getMinecraft().thePlayer;
        if (thePlayer != null) {
            bn.a(thePlayer, (IChatComponent)chatComponentTranslation);
        }
    }
}
