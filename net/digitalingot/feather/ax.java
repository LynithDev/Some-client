package net.digitalingot.feather;

import net.minecraftforge.fml.relauncher.*;
import net.minecraftforge.client.event.*;
import net.minecraft.util.*;
import net.minecraftforge.fml.common.eventhandler.*;

@SideOnly(Side.CLIENT)
public class ax implements at
{
    @SubscribeEvent
    public void a(final ClientChatReceivedEvent clientChatReceivedEvent) {
        if (clientChatReceivedEvent.type == 2) {
            return;
        }
        final IChatComponent receiveMessage = Q.bk.aH().receiveMessage(clientChatReceivedEvent.message);
        if (receiveMessage == null) {
            clientChatReceivedEvent.setCanceled(true);
            return;
        }
        clientChatReceivedEvent.message = receiveMessage;
    }
}
