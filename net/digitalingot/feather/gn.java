package net.digitalingot.feather;

import net.minecraft.client.*;
import java.awt.*;
import net.minecraft.init.*;
import net.minecraft.client.entity.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;

@dP(eL = dW.CROSSHAIR, eM = @dV(fh = "Custom Crosshair", fi = "https://assets.feathercdn.net/game/mods/crosshair.svg", fj = "Customize your crosshair", fk = { df.a.PVP }))
public class gn extends dQ<a> implements dY
{
    private gp qG;
    
    public gn() {
        this.qG = null;
    }
    
    @Override
    public void initialize() {
        float n;
        int n2;
        int n3;
        int ql;
        Color color = null;
        final Minecraft minecraft;
        EntityPlayerSP thePlayer;
        final ItemStack itemStack;
        final int n5;
        float n4;
        af.bo.a((im, c) -> {
            if (!this.eS() || c != af.c.CROSSHAIRS) {
                return aq.PASS;
            }
            else {
                Minecraft.getMinecraft();
                n = (float)ip.mr();
                n2 = ip.mn() / 2;
                n3 = ip.mo() / 2;
                im.lW();
                im.c(1.0f / n, 1.0f / n, 1.0f / n);
                ((a)this.jC).kq.gS();
                ql = ((a)this.jC).qL;
                if (((a)this.jC).kq.gR()) {
                    color = new Color(iG.sL().sN());
                }
                thePlayer = minecraft.thePlayer;
                if (!((EntityPlayer)thePlayer).isSpectator()) {
                    ((EntityPlayer)thePlayer).getHeldItem();
                    if (itemStack != null) {
                        ((EntityPlayer)thePlayer).getItemInUseCount();
                        if (itemStack.getItem() == Items.bow) {
                            n4 = (itemStack.getItem().getMaxItemUseDuration(itemStack) - n5) / 20.0f;
                            if (n5 == 0 || n4 > 1.0f) {
                                n4 = 1.0f;
                            }
                            ql = ((a)this.jC).qL + (int)((1.0f - n4) * (((a)this.jC).qL + 5) * 2.0f);
                        }
                    }
                }
                this.ib().a((a)this.jC, n2, n3, ql, color, im);
                if (((a)this.jC).qO && ((a)this.jC).qJ != a.a.DEFAULT) {
                    this.a(im, n2, n3);
                }
                ii.lH();
                ii.a(1.0f, 1.0f, 1.0f, 1.0f);
                im.lX();
                return aq.FAIL;
            }
        });
    }
    
    @Override
    public void b(final im im) {
        final float n = (float)ip.mr();
        final int n2 = ip.mn() / 2;
        final int n3 = ip.mo() / 2;
        im.lW();
        im.c(1.0f / n, 1.0f / n, 1.0f / n);
        Color gs = ((a)this.jC).kq.gS();
        int ql = ((a)this.jC).qL;
        if (((a)this.jC).kq.gR()) {
            gs = new Color(iG.sL().sN());
        }
        final EntityPlayerSP thePlayer = Minecraft.getMinecraft().thePlayer;
        if (thePlayer != null && !((EntityPlayer)thePlayer).isSpectator()) {
            final ItemStack heldItem = ((EntityPlayer)thePlayer).getHeldItem();
            if (heldItem != null) {
                final int itemInUseCount = ((EntityPlayer)thePlayer).getItemInUseCount();
                if (heldItem.getItem() == Items.bow) {
                    float n4 = (heldItem.getItem().getMaxItemUseDuration(heldItem) - itemInUseCount) / 20.0f;
                    if (itemInUseCount == 0 || n4 > 1.0f) {
                        n4 = 1.0f;
                    }
                    ql = ((a)this.jC).qL + (int)((1.0f - n4) * (((a)this.jC).qL + 5) * 2.0f);
                }
            }
        }
        this.ib().a((a)this.jC, 0, 0, ql, gs, im);
        if (((a)this.jC).qO && ((a)this.jC).qJ != a.a.DEFAULT) {
            this.a(im, 0, 0);
        }
        ii.lH();
        ii.a(1.0f, 1.0f, 1.0f, 1.0f);
        im.lX();
    }
    
    @Override
    public int eF() {
        return 0;
    }
    
    @Override
    public int eG() {
        return 0;
    }
    
    @Override
    public void eP() {
        this.qG = null;
    }
    
    private gp ib() {
        if (this.qG == null) {
            switch (gn$1.qH[((a)this.jC).qJ.ordinal()]) {
                case 1: {
                    this.qG = new gs();
                    break;
                }
                case 2: {
                    this.qG = new gr();
                    break;
                }
                case 3: {
                    this.qG = new gu();
                    break;
                }
                case 4: {
                    this.qG = new gq();
                    break;
                }
                case 5: {
                    this.qG = new gt();
                    break;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
        }
        return this.qG;
    }
    
    private void a(final im im, final int n, final int n2) {
        final int n3 = ((a)this.jC).qM / 2;
        final int n4 = (((a)this.jC).qM + 1) / 2;
        if (((a)this.jC).qR) {
            go.b(im, n - n3 - ((a)this.jC).mq, n2 - n3 - ((a)this.jC).mq, n + n4 + ((a)this.jC).mq, n2 + n4 + ((a)this.jC).mq, ((a)this.jC).qS);
        }
        go.b(im, n - n3, n2 - n3, n + n4, n2 + n4, ((a)this.jC).kq.gR() ? new Color(iG.sL().sN(), true) : ((a)this.jC).qP);
    }
    
    public static class a extends ea
    {
        @em(fS = 0)
        public eW qI;
        @er(fu = "type", fh = "Type", fW = "cross", fm = @em(fS = 1))
        public gn.a.a qJ;
        @er(fu = "size", fh = "Size", fW = "5", fm = @em(fS = 2))
        @el(fP = 50)
        public int qK;
        @er(fu = "gap", fh = "Gap", fW = "3", fm = @em(fS = 3))
        @el(fP = 50)
        public int qL;
        @er(fu = "thickness", fh = "Thickness", fW = "1", fm = @em(fS = 4))
        @el(fQ = 1, fP = 50)
        public int qM;
        @er(fu = "color", fh = "Color", fW = "false/255/255/255/255", fm = @em(fS = 5))
        public eT kq;
        @em(fS = 10)
        public eW qN;
        @er(fu = "dot", fh = "Dot", fm = @em(fS = 11))
        public boolean qO;
        @er(fu = "dotColor", fh = "Dot Color", fW = "255/255/255/255", fm = @em(fS = 12))
        public Color qP;
        @em(fS = 20)
        public eW qQ;
        @er(fu = "outline", fh = "Outline", fW = "true", fm = @em(fS = 21))
        public boolean qR;
        @er(fu = "outlineThickness", fh = "Thickness", fW = "1", fm = @em(fS = 22))
        @el(fQ = 1, fP = 50)
        public int mq;
        @er(fu = "outlineColor", fh = "Color", fW = "0/0/0/255", fm = @em(fS = 23))
        public Color qS;
        
        public a() {
            this.qI = new eW("Crosshair");
            this.qN = new eW("Dot");
            this.qQ = new eW("Outline");
        }
        
        @Override
        public Boolean fn() {
            return true;
        }
        
        public enum a
        {
            @ei(fu = "cross", fh = "Cross")
            CROSS, 
            @ei(fu = "circle", fh = "Circle")
            CIRCLE, 
            @ei(fu = "square", fh = "Square")
            SQUARE, 
            @ei(fu = "default", fh = "Default")
            DEFAULT, 
            @ei(fu = "arrow", fh = "Arrow")
            ARROW;
            
            private static /* synthetic */ a[] $values() {
                return new a[] { a.CROSS, a.CIRCLE, a.SQUARE, a.DEFAULT, a.ARROW };
            }
            
            static {
                $VALUES = $values();
            }
        }
    }
}
