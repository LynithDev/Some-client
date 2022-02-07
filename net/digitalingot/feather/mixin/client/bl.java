package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.digitalingot.feather.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ GuiIngameMenu.class })
public class bl
{
    @Inject(method = { "actionPerformed" }, at = { @At("HEAD") }, cancellable = true)
    public void a(final GuiButton guiButton, final CallbackInfo callbackInfo) {
        if (guiButton.id == 99) {
            callbackInfo.cancel();
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiMultiplayer((GuiScreen)this));
        }
        else if (guiButton.id == 100) {
            callbackInfo.cancel();
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new bz());
        }
    }
}
