package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ GuiNewChat.class })
public abstract class bg extends Gui
{
    @Unique
    private static final dT<fs> HJ;
    
    @Inject(method = { "drawChat" }, at = { @At("HEAD") }, cancellable = true, require = 1, allow = 1)
    private void n(final CallbackInfo callbackInfo) {
        final fs fs = bg.HJ.eZ();
        if (fs != null && fs.dI().mB) {
            callbackInfo.cancel();
        }
    }
    
    @Redirect(method = { "drawChat" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;drawStringWithShadow(Ljava/lang/String;FFI)I"), require = 1, allow = 1)
    private int a(final FontRenderer fontRenderer, final String s, final float n, float n2, final int n3) {
        final fs fs = bg.HJ.eZ();
        n2 -= 13.0f;
        if (fs != null && fs.dI().lh) {
            return fontRenderer.drawStringWithShadow(s, n, n2, n3);
        }
        return fontRenderer.drawString(s, (int)n, (int)n2, n3);
    }
    
    @ModifyConstant(method = { "setChatLine" }, constant = { @Constant(intValue = 100) }, require = 2, allow = 2)
    private int bc(final int n) {
        final fs fs = bg.HJ.eZ();
        return (fs != null && fs.dI().mC) ? 100000 : n;
    }
    
    @Redirect(method = { "drawChat" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiNewChat;drawRect(IIIII)V"), require = 3, allow = 3)
    private void b(final int n, int n2, final int n3, int n4, int rgb) {
        final fs fs = bg.HJ.eZ();
        final int n5 = rgb >> 24 & 0xFF;
        rgb = fs.dI().la.getRGB();
        final int n6 = rgb >> 24 & 0xFF;
        if (n5 < 127 && n5 < n6) {
            rgb = ((rgb & 0xFFFFFF) | n5 << 24);
        }
        n2 -= 13;
        n4 -= 13;
        drawRect(n, n2, n3, n4, rgb);
    }
    
    @ModifyConstant(method = { "getChatComponent" }, constant = { @Constant(intValue = 27) }, require = 1, allow = 1)
    private int bd(final int n) {
        return n + 13;
    }
    
    static {
        HJ = dU.a(fs.class);
    }
}
