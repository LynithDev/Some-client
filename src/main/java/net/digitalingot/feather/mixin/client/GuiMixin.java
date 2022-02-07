package net.digitalingot.feather.mixin.client;

import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.renderer.vertex.*;
import org.spongepowered.asm.mixin.injection.*;
import java.util.*;
import net.digitalingot.feather.*;

@Mixin({ Gui.class })
public class GuiMixin
{
    @Unique
    private static final dT<fC> PERFORMANCE;
    private final float Id = 0.00390625f;
    
    @Inject(method = { "drawRect" }, at = { @At("HEAD") }, cancellable = true)
    private static void a(int n, int n2, int n3, int n4, final int n5, final CallbackInfo callbackInfo) {
        if (GuiMixin.PERFORMANCE.eZ().dI().ou) {
            callbackInfo.cancel();
            if (n < n3) {
                final int n6 = n;
                n = n3;
                n3 = n6;
            }
            if (n2 < n4) {
                final int n7 = n2;
                n2 = n4;
                n4 = n7;
            }
            ii.lG();
            ii.lK();
            ii.c(770, 771, 1, 0);
            ii.a((n5 >> 16 & 0xFF) / 255.0f, (n5 >> 8 & 0xFF) / 255.0f, (n5 & 0xFF) / 255.0f, (n5 >> 24 & 0xFF) / 255.0f);
            iO.a(7, DefaultVertexFormats.POSITION);
            final jj jj = iO.sS().createSink(ja.EE);
            jj.aI(4);
            jj.d((float)n, (float)n4);
            jj.d((float)n3, (float)n4);
            jj.d((float)n3, (float)n2);
            jj.d((float)n, (float)n2);
            jj.tc();
            iO.lS();
            ii.lL();
            ii.lH();
        }
    }
    
    @Inject(method = { "drawTexturedModalRect(IIIIII)V" }, at = { @At("HEAD") }, cancellable = true)
    public void a(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final CallbackInfo callbackInfo) {
        if (GuiMixin.PERFORMANCE.eZ().dI().ou) {
            callbackInfo.cancel();
            final float n7 = (float)n;
            final float n8 = (float)n2;
            final float n9 = (float)n3;
            final float n10 = (float)n4;
            Objects.requireNonNull(this);
            final float n11 = 0.00390625f;
            Objects.requireNonNull(this);
            a(n7, n8, n9, n10, n5, n6, n5, n6, n11, 0.00390625f);
        }
    }
    
    @Inject(method = { "drawTexturedModalRect(FFIIII)V" }, at = { @At("HEAD") }, cancellable = true)
    public void a(final float n, final float n2, final int n3, final int n4, final int n5, final int n6, final CallbackInfo callbackInfo) {
        if (GuiMixin.PERFORMANCE.eZ().dI().ou) {
            callbackInfo.cancel();
            final float n7 = (float)n3;
            final float n8 = (float)n4;
            Objects.requireNonNull(this);
            final float n9 = 0.00390625f;
            Objects.requireNonNull(this);
            a(n, n2, n7, n8, n5, n6, n5, n6, n9, 0.00390625f);
        }
    }
    
    @Inject(method = { "drawModalRectWithCustomSizedTexture" }, at = { @At("HEAD") }, cancellable = true)
    private static void a(final int n, final int n2, final float n3, final float n4, final int n5, final int n6, final float n7, final float n8, final CallbackInfo callbackInfo) {
        if (GuiMixin.PERFORMANCE.eZ().dI().ou) {
            callbackInfo.cancel();
            a((float)n, (float)n2, n3, n4, n5, n6, n5, n6, 1.0f / n7, 1.0f / n8);
        }
    }
    
    @Inject(method = { "drawScaledCustomSizeModalRect" }, at = { @At("HEAD") }, cancellable = true)
    private static void a(final int n, final int n2, final float n3, final float n4, final int n5, final int n6, final int n7, final int n8, final float n9, final float n10, final CallbackInfo callbackInfo) {
        if (GuiMixin.PERFORMANCE.eZ().dI().ou) {
            callbackInfo.cancel();
            a((float)n, (float)n2, n3, n4, n5, n6, n7, n8, 1.0f / n9, 1.0f / n10);
        }
    }
    
    private static void a(final float n, final float n2, final float n3, final float n4, final int n5, final int n6, final int n7, final int n8, final float n9, final float n10) {
        iO.a(7, DefaultVertexFormats.POSITION_TEX);
        final jl jl = iO.sS().createSink(ja.EG);
        jl.aI(4);
        jl.e(n, n2 + n8, n3 * n9, (n4 + n6) * n10);
        jl.e(n + n7, n2 + n8, (n3 + n5) * n9, (n4 + n6) * n10);
        jl.e(n + n7, n2, (n3 + n5) * n9, n4 * n10);
        jl.e(n, n2, n3 * n9, n4 * n10);
        jl.tc();
        iO.lS();
    }
    
    static {
        PERFORMANCE = dU.a(fC.class);
    }
}
