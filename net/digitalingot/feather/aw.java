package net.digitalingot.feather;

import net.minecraftforge.fml.relauncher.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraft.client.*;
import net.minecraftforge.fml.common.eventhandler.*;

@SideOnly(Side.CLIENT)
public class aw implements at
{
    @SubscribeEvent
    public void a(final AttackEntityEvent attackEntityEvent) {
        if (!Minecraft.getMinecraft().isCallingFromMinecraftThread()) {
            return;
        }
        N.bk.aH().attack(attackEntityEvent.entityPlayer, attackEntityEvent.target);
    }
}
