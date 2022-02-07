package net.digitalingot.feather.mixin.client;

import com.google.common.util.concurrent.ListenableFutureTask;
import net.minecraft.client.settings.KeyBinding;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.*;
import org.lwjgl.input.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Queue;
import java.util.concurrent.FutureTask;
import java.util.function.Function;

import static net.minecraft.client.Minecraft.isRunningOnMac;

@Mixin({ Minecraft.class })
public class MinecraftMixin
{
    @Unique
    private static final dT<fR> Hl;
    @Shadow
    @Final
    private Queue<FutureTask<?>> scheduledTasks;
    @Shadow
    private int leftClickCounter;

    private static final Minecraft mc = Minecraft.getMinecraft();

    @ModifyVariable(method = "dispatchKeypresses" , at = @At(value = "STORE", ordinal = 0), ordinal = 0)
    private int fixKeyPress(int keyCode) {
        return (Keyboard.getEventKey() == 0) ? (Keyboard.getEventCharacter() + '\u0100') : Keyboard.getEventKey();
    }



    @Inject(method = { "setIngameFocus" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/util/MouseHelper;grabMouseCursor()V") }, require = 1, allow = 1)
    private void fixMacFocus(final CallbackInfo callbackInfo) {
        if (!isRunningOnMac) {
            for (final KeyBinding keyBinding : KeyBindMixin.getKeybindArray()) {
                try {
                    final int keyCode = keyBinding.getKeyCode();
                    KeyBinding.setKeyBindState(keyCode, keyCode < 256 && Keyboard.isKeyDown(keyCode));
                }
                catch (IndexOutOfBoundsException ignored) {}
            }
        }
    }


    @Inject(method = { "clickMouse" }, at = { @At("HEAD") })
    private void onClick(final CallbackInfo callbackInfo) {
        if (jJ.tC().map((Function<? super jJ, ? extends Boolean>)jJ::tF).orElse(false)) {
            this.leftClickCounter = 0;
        }
    }




    @Inject(method = { "toggleFullscreen()V" }, at = { @At("HEAD") }, cancellable = true, require = 1, allow = 1)
    private void toggleFullscreenFix(final CallbackInfo callbackInfo) {
        if (bm.Hl.eZ() == null) {
            callbackInfo.cancel();
            this.scheduledTasks.add((FutureTask<?>) ListenableFutureTask.create(mc::toggleFullscreen, (Object)null));
        }
    }

    @Inject(method = { "toggleFullscreen()V" }, at = { @At(value = "FIELD", target = "Lnet/minecraft/client/settings/GameSettings;fullScreen:Z", ordinal = 0, opcode = 181, shift = At.Shift.AFTER) }, cancellable = true, require = 1, allow = 1)
    private void toggleFullscreenFix2(final CallbackInfo callbackInfo) {
        if (bm.Hl.eZ().dI().pH) {
            fP.n(mc.isFullScreen());
            callbackInfo.cancel();
        }
    }

    @Redirect(method = { "runTick" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiScreen;isCtrlKeyDown()Z"))
    public boolean onTick() {
        final fR fr = bm.Hl.eZ();
        return fr != null && fr.dI().qj.ck();
    }

    static {
        Hl = dU.a(fR.class);
    }
}
