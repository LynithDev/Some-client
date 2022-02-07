package net.digitalingot.feather;

import net.minecraftforge.fml.relauncher.*;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.fml.common.eventhandler.*;

@SideOnly(Side.CLIENT)
public class aA implements at
{
    @SubscribeEvent
    public void a(final EntityJoinWorldEvent entityJoinWorldEvent) {
        S.bk.aH().joinLevel(entityJoinWorldEvent.entity, entityJoinWorldEvent.world);
    }
}
