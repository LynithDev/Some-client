package net.digitalingot.feather.mixin.core;

import org.spongepowered.asm.mixin.*;
import java.util.*;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.gen.*;

@Mixin({ GuiNewChat.class })
public interface b
{
    @Accessor("chatLines")
    List<ChatLine> getAllMessages();
    
    @Accessor("drawnChatLines")
    List<ChatLine> getTrimmedMessages();
}
