package net.digitalingot.feather;

import java.nio.*;
import java.awt.*;

@dP(eL = dW.ANIMATIONS, eM = @dV(fh = "Animations", fi = "https://assets.feathercdn.net/game/mods/animations.svg", fj = "Switch between 1.7 and 1.8 animations", fk = {}))
public class fq extends dQ<a>
{
    public void a(final FloatBuffer floatBuffer) {
        final a.a mk = ((a)this.jC).mk;
        final Color ml = ((a)this.jC).ml;
        if (mk == a.a.CUSTOM_COLOR) {
            floatBuffer.put(ml.getRed() / 255.0f);
            floatBuffer.put(ml.getGreen() / 255.0f);
            floatBuffer.put(ml.getBlue() / 255.0f);
            floatBuffer.put(ml.getAlpha() / 255.0f);
        }
        else if (mk == a.a.CHROMA) {
            final Color color = new Color(iG.sL().sN());
            floatBuffer.put(color.getRed() / 255.0f);
            floatBuffer.put(color.getGreen() / 255.0f);
            floatBuffer.put(color.getBlue() / 255.0f);
            floatBuffer.put(ml.getAlpha() / 255.0f);
        }
    }
    
    @ef(fC = true)
    public static class a extends ea
    {
        @em(fS = 0)
        public eW lV;
        @er(fu = "blockHit", fh = "Block Hit", fW = "true", fm = @em(fS = 1))
        public boolean lW;
        @er(fu = "blockBreak", fh = "Block Break", fW = "true", fm = @em(fS = 2))
        public boolean lX;
        @er(fu = "bow", fh = "Bow", fW = "true", fm = @em(fS = 3))
        public boolean lY;
        @er(fu = "rod", fh = "Rod", fW = "true", fm = @em(fS = 4))
        public boolean lZ;
        @er(fu = "eating", fh = "Eating", fW = "true", fm = @em(fS = 5))
        public boolean ma;
        @er(fu = "sneaking", fh = "Sneaking", fW = "true", fm = @em(fS = 6))
        public boolean mb;
        @er(fu = "damage", fh = "Damage", fW = "true", fm = @em(fS = 7))
        public boolean mc;
        @er(fu = "sword", fh = "Sword", fW = "true", fm = @em(fS = 8))
        public boolean md;
        @er(fu = "itemHeld", fh = "Item Held", fW = "true", fm = @em(fS = 9))
        public boolean me;
        @er(fu = "itemUpdate", fh = "Item Update", fW = "true", fm = @em(fS = 10))
        public boolean mf;
        @er(fu = "swing", fh = "Swing", fW = "true", fm = @em(fS = 11))
        public boolean mg;
        @er(fu = "health", fh = "Health", fW = "true", fm = @em(fS = 12))
        public boolean mh;
        @er(fu = "debug", fh = "Debug", fW = "true", fm = @em(fS = 13))
        public boolean mi;
        @em(fS = 20)
        public eW mj;
        @er(fu = "damageIndicatorMode", fh = "Mode", fW = "default", fm = @em(fS = 21))
        public fq.a.a mk;
        @er(fu = "damageIndicatorColor", fh = "Color", fW = "160/0/0/76", fZ = @en(fu = "damageIndicatorMode", fT = { "customColor" }), fm = @em(fS = 22))
        public Color ml;
        
        public a() {
            this.lV = new eW("Animations");
            this.mj = new eW("Damage Indicator");
        }
        
        public enum a
        {
            @ei(fu = "default", fh = "Default")
            DEFAULT, 
            @ei(fu = "customColor", fh = "Custom Color")
            CUSTOM_COLOR, 
            @ei(fu = "chroma", fh = "Chroma")
            CHROMA;
            
            private static /* synthetic */ a[] $values() {
                return new a[] { a.DEFAULT, a.CUSTOM_COLOR, a.CHROMA };
            }
            
            static {
                $VALUES = $values();
            }
        }
    }
}
