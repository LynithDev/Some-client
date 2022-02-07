package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ GuiMultiplayer.class })
public class GuiMultiplayerMixin
{
    @Inject(method = { "connectToServer" }, at = { @At("HEAD") })
    public void t(final CallbackInfo callbackInfo) {
        final Minecraft minecraft = Minecraft.getMinecraft();
        if (minecraft.getNetHandler() != null) {
            minecraft.getNetHandler().getNetworkManager().closeChannel(new ChatComponentText(""));
        }
    }
}
