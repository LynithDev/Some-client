package net.digitalingot.feather.mixin.client;

import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ GuiChat.class })
public abstract class GuiChatMixin
{
    @Unique
    private static final dT<fz> HP;
    @Shadow
    protected GuiTextField inputField;
    
    @ModifyVariable(method = { "onAutocompleteResponse" }, at = @At("HEAD"))
    public String[] f(final String[] array) {
        final fz fz = GuiChatMixin.HP.eZ();
        return (fz != null && fz.eS()) ? fz.a(array, this.inputField.getText()) : array;
    }
    
    static {
        HP = dU.a(fz.class);
    }
}
