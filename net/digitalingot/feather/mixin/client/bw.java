package net.digitalingot.feather.mixin.client;

import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ GuiChat.class })
public abstract class bw
{
    @Unique
    private static final dT<fz> HP;
    @Shadow
    protected GuiTextField field_146415_a;
    
    @ModifyVariable(method = { "onAutocompleteResponse" }, at = @At("HEAD"))
    public String[] f(final String[] array) {
        final fz fz = bw.HP.eZ();
        return (fz != null && fz.eS()) ? fz.a(array, this.field_146415_a.getText()) : array;
    }
    
    static {
        HP = dU.a(fz.class);
    }
}
