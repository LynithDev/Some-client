package net.digitalingot.feather;

import net.minecraft.potion.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.digitalingot.feather.mixin.core.*;
import net.minecraft.client.entity.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.client.gui.*;
import java.util.*;
import java.awt.*;
import net.minecraft.entity.player.*;

@dP(eL = dW.SATURATION, eM = @dV(fh = "Saturation", fi = "https://assets.feathercdn.net/game/mods/saturation.svg", fj = "", fk = {}))
public class hh extends dQ<a>
{
    private static final int yh = 3;
    private static final int yi = -3;
    private static final int yj = 3;
    private static final int oS;
    private static final int yk;
    private static final Potion yl;
    private final ResourceLocation ym;
    private float yn;
    
    public hh() {
        this.ym = new ResourceLocation("feather:textures/saturation.png");
        this.yn = 0.0f;
    }
    
    @Override
    public void initialize() {
        a.a yp;
        X.bk.a((itemStack, list) -> {
            if (!this.eS()) {
                return;
            }
            else if (itemStack == null) {
                return;
            }
            else {
                yp = ((a)this.jC).yp;
                if (yp == a.a.NEVER || (yp == a.a.SHIFT_ONLY && !g.a(hh.oS) && !g.a(hh.yk))) {
                    return;
                }
                else if (!(itemStack.getItem() instanceof ItemFood)) {
                    return;
                }
                else {
                    list.add("           ");
                    list.add("           ");
                    return;
                }
            }
        });
        a.a yp2;
        final Minecraft minecraft;
        GuiScreen currentScreen;
        final hg.a a;
        final hg.a a2;
        final int n3;
        int n2;
        boolean b;
        String string;
        final float n5;
        int n4;
        boolean b2;
        String string2;
        final int n6;
        boolean b3;
        int n7;
        int i = 0;
        int n8 = 0;
        int n9 = 0;
        final String s;
        int j = 0;
        final float n11;
        float n10;
        int n12 = 0;
        boolean b4;
        final String s2;
        ai.bB.a((p0, itemStack2, p2, n, p4, p5) -> {
            if (!this.eS()) {
                return;
            }
            else if (itemStack2 == null) {
                return;
            }
            else {
                yp2 = ((a)this.jC).yp;
                if ((yp2 == hh.a.a.NEVER || yp2 == hh.a.a.SHIFT_ONLY) && !bK.I(bN.K(16).cq()) && !bK.I(bN.K(10016).cq())) {
                    return;
                }
                else {
                    Minecraft.getMinecraft();
                    currentScreen = minecraft.currentScreen;
                    if (currentScreen == null) {
                        return;
                    }
                    else if (!(itemStack2.getItem() instanceof ItemFood)) {
                        return;
                    }
                    else {
                        hg.j(itemStack2);
                        hg.k(itemStack2);
                        if (a.equals(a2) && a.yf == 0) {
                            return;
                        }
                        else {
                            Math.max(a.yf, a2.yf);
                            Math.max(a.je(), a2.je());
                            n2 = (int)Math.ceil(Math.abs(n3) / 2.0f);
                            b = (n2 > 10);
                            if (b) {
                                string = ((n3 < 0) ? -1 : 1) * n2 + "x ";
                            }
                            else {
                                string = null;
                            }
                            if (b) {
                                n2 = 1;
                            }
                            n4 = (int)Math.max(1.0, Math.ceil(Math.abs(n5) / 2.0f));
                            b2 = (n4 > 10);
                            if (b2) {
                                string2 = ((n5 < 0.0f) ? -1 : 1) * n4 + "x ";
                            }
                            else {
                                string2 = null;
                            }
                            if (b2) {
                                n4 = 1;
                            }
                            b3 = (n6 + 20 < ip.mq() - 3);
                            n7 = (b3 ? n6 : (n - 20 - 3)) + 19;
                            ii.lB();
                            ii.lD();
                            ii.a(0, Gui.icons);
                            while (i < n2 * 2) {
                                n8 -= 9;
                                if (a2.yf < 0) {
                                    jU.a(n8, n9, 34, 27, 9, 9, (float)(int)((net.digitalingot.feather.mixin.core.a)currentScreen).getBlitOffset());
                                }
                                else if (a2.yf > a.yf && a.yf <= i) {
                                    jU.a(n8, n9, 133, 27, 9, 9, (float)(int)((net.digitalingot.feather.mixin.core.a)currentScreen).getBlitOffset());
                                }
                                else if (a2.yf > i + 1 || a.yf == a2.yf) {
                                    jU.a(n8, n9, 16, 27, 9, 9, (float)(int)((net.digitalingot.feather.mixin.core.a)currentScreen).getBlitOffset());
                                }
                                else if (a2.yf == i + 1) {
                                    jU.a(n8, n9, 124, 27, 9, 9, (float)(int)((net.digitalingot.feather.mixin.core.a)currentScreen).getBlitOffset());
                                }
                                else {
                                    jU.a(n8, n9, 34, 27, 9, 9, (float)(int)((net.digitalingot.feather.mixin.core.a)currentScreen).getBlitOffset());
                                }
                                ii.a(1.0f, 1.0f, 1.0f, 0.25f);
                                jU.a(n8, n9, (a.yf - 1 == i) ? 115 : 106, 27, 9, 9, (float)(int)((net.digitalingot.feather.mixin.core.a)currentScreen).getBlitOffset());
                                ii.a(1.0f, 1.0f, 1.0f, 1.0f);
                                if (a2.yf > i) {
                                    jU.a(n8, n9, (a2.yf - 1 == i) ? 61 : 52, 27, 9, 9, (float)(int)((net.digitalingot.feather.mixin.core.a)currentScreen).getBlitOffset());
                                }
                                i += 2;
                            }
                            if (s != null) {
                                ii.lU();
                                ii.b(0.75, 0.75, 0.75);
                                iG.sM().drawString(s, n8 * 4.0f / 3.0f - minecraft.fontRendererObj.getStringWidth(s) + 2.0f, n9 * 4.0f / 3.0f + 2.0f, -2236963, true);
                                ii.lV();
                            }
                            n9 += 10;
                            Math.abs(a2.je());
                            ii.a(1.0f, 1.0f, 1.0f, 1.0f);
                            ii.a(0, this.jf());
                            while (j < n4 * 2) {
                                n10 = (n11 - j) / 2.0f;
                                n12 -= 6;
                                b4 = (n11 <= j);
                                if (b4) {
                                    ii.a(1.0f, 1.0f, 1.0f, 0.5f);
                                }
                                jU.a(n12, n9, (n10 >= 1.0f) ? 21 : ((n10 > 0.5) ? 14 : ((n10 > 0.25) ? 7 : ((n10 > 0.0f) ? 0 : 28))), ((a)this.jC).yy ? 34 : 27, 7, 7, (float)(int)((net.digitalingot.feather.mixin.core.a)currentScreen).getBlitOffset());
                                if (b4) {
                                    ii.a(1.0f, 1.0f, 1.0f, 1.0f);
                                }
                                j += 2;
                            }
                            if (s2 != null) {
                                ii.lU();
                                ii.b(0.75, 0.75, 0.75);
                                iG.sM().drawString(s2, n12 * 4.0f / 3.0f - minecraft.fontRendererObj.getStringWidth(s2) + 2.0f, n9 * 4.0f / 3.0f + 1.0f, -2236963, true);
                                ii.lV();
                            }
                            ii.lH();
                            ii.a(1.0f, 1.0f, 1.0f, 1.0f);
                            RenderHelper.disableStandardItemLighting();
                            ii.lB();
                            ii.lD();
                            return;
                        }
                    }
                }
            }
        });
        int n13;
        float n14;
        an.bE.a(c -> {
            if (!this.eS()) {
                return;
            }
            else if (c != an.c.START) {
                return;
            }
            else {
                n13 = 15000 / ((a)this.jC).yo;
                n14 = System.currentTimeMillis() % n13 * 1.0f / n13;
                this.yn = ((n14 < 0.66f) ? (n14 * 3.0f) : (3.0f - n14 * 3.0f));
                return;
            }
        });
        af.bo.a((p0, c2) -> {
            if (!this.eS()) {
                return aq.PASS;
            }
            else if (!((a)this.jC).ys || c2 != af.c.FOOD) {
                return aq.PASS;
            }
            else {
                this.a(((f)Minecraft.getMinecraft().thePlayer.func_71024_bL()).getFoodExhaustionLevel(), ip.mp() / 2 + 91, ip.mq() - 39);
                return aq.PASS;
            }
        });
        final Minecraft minecraft2;
        EntityPlayerSP thePlayer;
        int n15;
        int n16;
        final FoodStats foodStats;
        final ItemStack itemStack3;
        final hg.a a3;
        int n17;
        af.bp.a((p0, c3) -> {
            if (!(!this.eS())) {
                if (c3 == af.c.FOOD) {
                    Minecraft.getMinecraft();
                    thePlayer = minecraft2.thePlayer;
                    if (!((EntityPlayer)thePlayer).capabilities.isCreativeMode) {
                        ((EntityPlayer)thePlayer).getHeldItem();
                        ((EntityPlayer)thePlayer).getFoodStats();
                        n15 = ip.mp() / 2 + 91;
                        n16 = ip.mq() - 39;
                        if (((a)this.jC).yB) {
                            this.a(0.0f, foodStats.getSaturationLevel(), minecraft2, n15, n16, 1.0f, ((a)this.jC).yx);
                        }
                        if (itemStack3 == null || !(itemStack3.getItem() instanceof ItemFood)) {
                            this.yn = 0.0f;
                        }
                        else {
                            hg.k(itemStack3);
                            if (((a)this.jC).yu) {
                                this.a(a3.yf, foodStats.getFoodLevel(), minecraft2, n15, n16, this.yn);
                            }
                            if (((a)this.jC).yA) {
                                n17 = foodStats.getFoodLevel() + a3.yf;
                                this.a((foodStats.getSaturationLevel() + a3.je() > n17) ? (n17 - foodStats.getSaturationLevel()) : a3.je(), foodStats.getSaturationLevel(), minecraft2, n15, n16, this.yn, ((a)this.jC).yw);
                            }
                        }
                    }
                }
            }
        });
    }
    
    public void a(final float n, final int n2, final int n3) {
        final Minecraft minecraft = Minecraft.getMinecraft();
        ii.lz();
        ii.a((float)(((a)this.jC).yr.getRed() / 255.0), (float)(((a)this.jC).yr.getGreen() / 255.0), (float)(((a)this.jC).yr.getBlue() / 255.0), (float)(((a)this.jC).yr.getAlpha() / 255.0));
        ii.a(0, this.ym);
        final int n4 = (int)(n / 4.0f * 81.0f);
        jU.a(n2 - n4, n3, 81 - n4, 18, n4, 9, (float)(int)((net.digitalingot.feather.mixin.core.a)minecraft.ingameGUI).getBlitOffset());
        ii.a(1.0f, 1.0f, 1.0f, 1.0f);
        ii.a(0, Gui.icons);
    }
    
    public void a(final int n, final int n2, final Minecraft minecraft, final int n3, final int n4, final float n5) {
        if (n == 0) {
            return;
        }
        final int n6 = n2 / 2;
        final int n7 = (int)Math.ceil(Math.min(20, n2 + n) / 2.0f) - n6;
        ii.a(0, Gui.icons);
        this.g(n5);
        for (int i = n6; i < n6 + n7; ++i) {
            final int n8 = i * 2 + 1;
            final float n9 = (float)(n3 - i * 8 - 9);
            int n10 = 16;
            int n11 = 13;
            if (minecraft.thePlayer.func_70644_a(hh.yl)) {
                n10 += 36;
                n11 = 13;
            }
            final GuiIngame ingameGUI = minecraft.ingameGUI;
            jU.a((int)n9, n4, 16 + n11 * 9, 27, 9, 9, (float)(int)((net.digitalingot.feather.mixin.core.a)ingameGUI).getBlitOffset());
            jU.a((int)n9, n4, n10 + ((n8 < n2 + n) ? 36 : 45), 27, 9, 9, (float)(int)((net.digitalingot.feather.mixin.core.a)ingameGUI).getBlitOffset());
        }
        this.h(n5);
    }
    
    public void a(final float n, final float n2, final Minecraft minecraft, final int n3, final int n4, final float n5, final boolean b) {
        if (n2 + n < 0.0f) {
            return;
        }
        final int n6 = (n != 0.0f) ? Math.max(0, (int)n2 / 2) : 0;
        final int n7 = (int)Math.ceil(Math.min(20.0f, n2 + n) / 2.0f) - n6;
        ii.a(0, this.ym);
        this.g(n5);
        final int n8 = b ? 9 : 0;
        for (int i = n6; i < n6 + n7; ++i) {
            final int n9 = n3 - i * 8 - 9;
            final float n10 = (n2 + n) / 2.0f - i;
            final GuiIngame ingameGUI = minecraft.ingameGUI;
            if (n10 >= 1.0f) {
                jU.a(n9, n4, 27, n8, 9, 9, (float)(int)((net.digitalingot.feather.mixin.core.a)ingameGUI).getBlitOffset());
            }
            else if (n10 > 0.5) {
                jU.a(n9, n4, 18, n8, 9, 9, (float)(int)((net.digitalingot.feather.mixin.core.a)ingameGUI).getBlitOffset());
            }
            else if (n10 > 0.25) {
                jU.a(n9, n4, 9, n8, 9, 9, (float)(int)((net.digitalingot.feather.mixin.core.a)ingameGUI).getBlitOffset());
            }
            else if (n10 > 0.0f) {
                jU.a(n9, n4, 0, n8, 9, 9, (float)(int)((net.digitalingot.feather.mixin.core.a)ingameGUI).getBlitOffset());
            }
        }
        this.h(n5);
        ii.a(0, Gui.icons);
    }
    
    public void g(final float n) {
        ii.lG();
        if (n == 1.0f) {
            return;
        }
        ii.a(1.0f, 1.0f, 1.0f, n);
        ii.n(770, 771);
    }
    
    public void h(final float n) {
        ii.lH();
        if (n == 1.0f) {
            return;
        }
        ii.a(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public ResourceLocation jf() {
        return this.ym;
    }
    
    static {
        oS = bN.K(16).cq();
        yk = bN.K(10016).cq();
        yl = Potion.getPotionFromResourceLocation("hunger");
    }
    
    @ef(fC = true)
    public static class a extends ea
    {
        @em(fS = 0)
        public eW mm;
        @er(fu = "animationSpeed", fh = "Animation Speed", fW = "10", fm = @em(fS = 1))
        @el(fQ = 1, fP = 25)
        public int yo;
        @er(fu = "tooltipFoodValues", fh = "Tooltip Food Values", fW = "shiftOnly", fm = @em(fS = 2))
        public hh.a.a yp;
        @em(fS = 10)
        public eW yq;
        @er(fu = "foodExhaustionColor", fh = "Color", fW = "128/128/128", fm = @em(fS = 11))
        public Color yr;
        @er(fu = "foodExhaustionUnderlay", fh = "Underlay", fW = "true", fm = @em(fS = 12))
        public boolean ys;
        @em(fS = 20)
        public eW yt;
        @er(fu = "foodGainOverlay", fh = "Gain Overlay", fW = "true", fm = @em(fS = 21))
        public boolean yu;
        @em(fS = 30)
        public eW yv;
        @er(fu = "redSaturationGainOverlay", fh = "Gain Overlay", fm = @em(fS = 31))
        public boolean yw;
        @er(fu = "redSaturationOverlay", fh = "Overlay", fW = "true", fm = @em(fS = 32))
        public boolean yx;
        @er(fu = "redTooltipSaturation", fh = "Tooltip Saturation", fm = @em(fS = 33))
        public boolean yy;
        @em(fS = 40)
        public eW yz;
        @er(fu = "saturationGainOverlay", fh = "Gain Overlay", fW = "true", fm = @em(fS = 41))
        public boolean yA;
        @er(fu = "saturationOverlay", fh = "Overlay", fW = "true", fm = @em(fS = 42))
        public boolean yB;
        
        public a() {
            this.mm = new eW("General");
            this.yq = new eW("Food Exhaustion");
            this.yt = new eW("Food Gain");
            this.yv = new eW("Red Saturation");
            this.yz = new eW("Saturation");
        }
        
        public enum a
        {
            @ei(fu = "never", fh = "Never")
            NEVER, 
            @ei(fu = "shiftOnly", fh = "Shift Only")
            SHIFT_ONLY, 
            @ei(fu = "always", fh = "Always")
            ALWAYS;
            
            private static /* synthetic */ a[] $values() {
                return new a[] { a.NEVER, a.SHIFT_ONLY, a.ALWAYS };
            }
            
            static {
                $VALUES = $values();
            }
        }
    }
}
