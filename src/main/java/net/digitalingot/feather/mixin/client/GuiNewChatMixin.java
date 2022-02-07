package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ GuiNewChat.class })
public abstract class GuiNewChatMixin extends Gui
{
    @Unique
    private static final dT<fs> HJ;
    
    @Inject(method = { "drawChat" }, at = { @At("HEAD") }, cancellable = true, require = 1, allow = 1)
    private void drawChatFix(final CallbackInfo callbackInfo) {
        final fs fs = GuiNewChatMixin.HJ.eZ();
        if (fs != null && fs.dI().mB) {
            callbackInfo.cancel();
        }
    }
    
    @Redirect(method = { "drawChat" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;drawStringWithShadow(Ljava/lang/String;FFI)I"), require = 1, allow = 1)
    private int redrawChat(final FontRenderer fontRenderer, final String s, final float x, float y, final int color) {
        final fs fs = GuiNewChatMixin.HJ.eZ();
        y -= 13.0f;
        if (fs != null && fs.dI().lh) {
            return fontRenderer.drawStringWithShadow(s, x, y, color);
        }
        return fontRenderer.drawString(s, (int)x, (int)y, color);
    }
    
    @ModifyConstant(method = { "setChatLine" }, constant = { @Constant(intValue = 100) }, require = 2, allow = 2)
    private int setChatLine(final int n) {
        final fs fs = GuiNewChatMixin.HJ.eZ();
        return (fs != null && fs.dI().mC) ? 100000 : n;
    }
    
    @Redirect(method = { "drawChat" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiNewChat;drawRect(IIIII)V"), require = 3, allow = 3)
    private void redrawChatRect(final int left, int top, final int right, int bottom, int rgb) {
        final fs fs = GuiNewChatMixin.HJ.eZ();
        final int n5 = rgb >> 24 & 0xFF;
        rgb = fs.dI().la.getRGB();
        final int n6 = rgb >> 24 & 0xFF;
        if (n5 < 127 && n5 < n6) {
            rgb = ((rgb & 0xFFFFFF) | n5 << 24);
        }
        top -= 13;
        bottom -= 13;
        drawRect(left, top, right, bottom, rgb);
    }
    
    @ModifyConstant(method = { "getChatComponent" }, constant = { @Constant(intValue = 27) }, require = 1, allow = 1)
    private int fixChatComponent(final int offset) {
        return offset + 13;
    }
    
    static {
        HJ = dU.a(fs.class);
    }
}
