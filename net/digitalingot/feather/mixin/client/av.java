package net.digitalingot.feather.mixin.client;

import net.minecraft.client.gui.*;
import net.minecraft.client.gui.inventory.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ GuiContainer.class })
public abstract class av extends GuiScreen
{
    @Shadow
    protected abstract boolean func_146983_a(final int p0);
    
    @Inject(method = { "mouseClicked" }, at = { @At("HEAD") })
    private void a(final int n, final int n2, final int n3, final CallbackInfo callbackInfo) {
        this.func_146983_a(n3 - 100);
    }
    
    @Inject(method = { "mouseClicked" }, at = { @At("HEAD") }, cancellable = true)
    private void b(final int n, final int n2, final int n3, final CallbackInfo callbackInfo) {
        if (n3 - 100 == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
            this.mc.thePlayer.closeScreen();
            callbackInfo.cancel();
        }
    }
}
