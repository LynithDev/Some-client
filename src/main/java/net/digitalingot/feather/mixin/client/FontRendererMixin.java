package net.digitalingot.feather.mixin.client;

import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ FontRenderer.class })
public class FontRendererMixin
{
    @Unique
    private static final dT<fz> HP;
    
    @ModifyArg(method = { "renderString" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;renderStringAtPos(Ljava/lang/String;Z)V"))
    public String renderStringFix(final String s) {
        final fz fz = FontRendererMixin.HP.eZ();
        return (fz != null && fz.eS()) ? fz.L(s) : s;
    }
    
    @ModifyVariable(method = { "getStringWidth" }, at = @At("HEAD"))
    public String getStringWidthFix(final String s) {
        final fz fz = FontRendererMixin.HP.eZ();
        return (fz != null && fz.eS()) ? fz.L(s) : s;
    }
    
    static {
        HP = dU.a(fz.class);
    }
}
