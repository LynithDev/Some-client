package net.digitalingot.feather;

import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class az implements at
{
    @SubscribeEvent
    public void a(final GuiScreenEvent.DrawScreenEvent.Post post) {
        al.bv.aH().render(post.gui);
    }
}
