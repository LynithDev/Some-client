package net.digitalingot.feather.mixin.client;

import net.minecraft.profiler.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.entity.*;
import java.util.*;
import java.util.concurrent.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import com.google.common.util.concurrent.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ Minecraft.class })
public abstract class bm implements IPlayerUsage, IThreadListener
{
    @Unique
    private static final dT<fR> Hl;
    @Shadow
    public GuiScreen field_71462_r;
    @Shadow
    public EntityPlayerSP field_71439_g;
    @Shadow
    private boolean field_71431_Q;
    @Shadow
    @Final
    private Queue<FutureTask<?>> field_152351_aB;
    
    @Shadow
    public abstract void func_71352_k();
    
    @Inject(method = { "toggleFullscreen()V" }, at = { @At("HEAD") }, cancellable = true, require = 1, allow = 1)
    private void p(final CallbackInfo callbackInfo) {
        if (bm.Hl.eZ() == null) {
            callbackInfo.cancel();
            this.field_152351_aB.add((FutureTask<?>)ListenableFutureTask.create(this::func_71352_k, (Object)null));
        }
    }
    
    @Inject(method = { "toggleFullscreen()V" }, at = { @At(value = "FIELD", target = "Lnet/minecraft/client/settings/GameSettings;fullScreen:Z", ordinal = 0, opcode = 181, shift = At.Shift.AFTER) }, cancellable = true, require = 1, allow = 1)
    private void q(final CallbackInfo callbackInfo) {
        if (bm.Hl.eZ().dI().pH) {
            fP.n(this.field_71431_Q);
            callbackInfo.cancel();
        }
    }
    
    @Redirect(method = { "runTick" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiScreen;isCtrlKeyDown()Z"))
    public boolean uu() {
        final fR fr = bm.Hl.eZ();
        return fr != null && fr.dI().qj.ck();
    }
    
    static {
        Hl = dU.a(fR.class);
    }
}
