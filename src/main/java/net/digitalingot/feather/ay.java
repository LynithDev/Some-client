package net.digitalingot.feather;

import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class ay implements at
{
    @SubscribeEvent
    public void a(final DrawBlockHighlightEvent drawBlockHighlightEvent) {
        if (R.bl.aH().drawHighlightBlock() == aq.FAIL) {
            drawBlockHighlightEvent.setCanceled(true);
        }
    }
}
