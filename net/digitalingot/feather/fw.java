package net.digitalingot.feather;

import net.minecraft.item.*;
import java.awt.*;

@dP(eL = dW.GLINT, eM = @dV(fh = "Glint", fi = "https://assets.feathercdn.net/game/mods/glint.svg", fj = "Customize color of enchants and other settings", fk = {}))
public class fw extends dQ<a>
{
    private static final int ni = -8372020;
    
    public int d(final ItemStack itemStack) {
        final boolean e = e(itemStack);
        switch (fw$1.nj[(e ? ((a)this.jC).nm : ((a)this.jC).np).ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return -8372020;
            }
            case 3: {
                return e ? ((a)this.jC).nn.getRGB() : ((a)this.jC).nq.getRGB();
            }
            default: {
                return iG.sL().sN();
            }
        }
    }
    
    public static boolean e(final ItemStack itemStack) {
        return itemStack != null && itemStack.getItem() instanceof ItemArmor;
    }
    
    public boolean f(final ItemStack itemStack) {
        return this.eS() && ((a)this.jC).nk && this.d(itemStack) != 0 && itemStack.getItem() instanceof ItemPotion;
    }
    
    public static class a extends ea
    {
        @em(fS = 0)
        public eW mm;
        @er(fu = "shinyPots", fh = "Shiny Pots", fm = @em(fS = 1))
        public boolean nk;
        @em(fS = 10)
        public eW nl;
        @er(fu = "mode", fh = "Mode", fW = "defaultColor", fm = @em(fS = 11))
        public fw.a.a nm;
        @er(fu = "armorColor", fh = "Color", fW = "128/64/204", fZ = @en(fu = "mode", fT = { "customColor" }), fm = @em(fS = 12))
        public Color nn;
        @em(fS = 20)
        public eW no;
        @er(fu = "item", fh = "Mode", fW = "defaultColor", fm = @em(fS = 21))
        public fw.a.a np;
        @er(fu = "itemColor", fh = "Color", fW = "128/64/204", fZ = @en(fu = "item", fT = { "customColor" }), fm = @em(fS = 22))
        public Color nq;
        
        public a() {
            this.mm = new eW("General");
            this.nl = new eW("Armor");
            this.no = new eW("Item");
            this.np = fw.a.a.DEFAULT_COLOR;
        }
        
        public enum a
        {
            @ei(fu = "off", fh = "Off")
            OFF, 
            @ei(fu = "defaultColor", fh = "Default Color")
            DEFAULT_COLOR, 
            @ei(fu = "customColor", fh = "Custom Color")
            CUSTOM_COLOR, 
            @ei(fu = "chroma", fh = "Chroma")
            CHROMA;
            
            private static /* synthetic */ a[] $values() {
                return new a[] { a.OFF, a.DEFAULT_COLOR, a.CUSTOM_COLOR, a.CHROMA };
            }
            
            static {
                $VALUES = $values();
            }
        }
        
        public enum b
        {
            @ei(fu = "item", fh = "Item")
            ITEM, 
            @ei(fu = "model", fh = "Model")
            MODEL;
            
            private static /* synthetic */ b[] $values() {
                return new b[] { b.ITEM, b.MODEL };
            }
            
            static {
                $VALUES = $values();
            }
        }
    }
}
