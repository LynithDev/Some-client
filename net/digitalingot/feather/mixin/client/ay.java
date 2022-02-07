package net.digitalingot.feather.mixin.client;

import net.minecraft.client.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.settings.*;
import org.lwjgl.input.*;
import java.util.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ Minecraft.class })
public class ay
{
    @Shadow
    @Final
    public static boolean field_142025_a;
    
    @Inject(method = { "setIngameFocus" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/util/MouseHelper;grabMouseCursor()V") }, require = 1, allow = 1)
    private void d(final CallbackInfo callbackInfo) {
        if (!ay.field_142025_a) {
            for (final KeyBinding keyBinding : ax.getKeybindArray()) {
                try {
                    final int keyCode = keyBinding.getKeyCode();
                    KeyBinding.setKeyBindState(keyCode, keyCode < 256 && Keyboard.isKeyDown(keyCode));
                }
                catch (IndexOutOfBoundsException ex) {}
            }
        }
    }
}
