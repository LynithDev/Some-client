package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.*;
import org.lwjgl.input.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ Minecraft.class })
public class aw
{
    @ModifyVariable(method = { "dispatchKeypresses" }, at = @At("STORE"))
    private int aR(final int n) {
        return (Keyboard.getEventKey() == 0) ? (Keyboard.getEventCharacter() + '\u0100') : Keyboard.getEventKey();
    }
}
