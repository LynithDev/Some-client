package net.digitalingot.feather;

import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.vertex.*;
import java.awt.*;

@dP(eL = dW.DIRECTION, eM = @dV(fh = "Direction", fi = "https://assets.feathercdn.net/game/mods/direction.svg", fj = "Display your cardinal direction", fk = { df.a.HUD }))
public class gz extends dN<a>
{
    private static final float sb = 33.33f;
    private static final float sc = 33.335f;
    private static final float sd = 0.33330002f;
    private static final float se = 0.33335f;
    private static final Minecraft minecraft;
    private ResourceLocation texture;
    private int textureWidth;
    private int textureHeight;
    private float pixelsPerDegree;
    private int sf;
    private int sg;
    private int sh;
    private int si;
    private int gO;
    private int gP;
    private int sj;
    private int sk;
    private float sl;
    private float sm;
    private int sn;
    private int so;
    
    public gz() {
        this.sn = (int)(0.33330002f * this.sl);
        this.so = (int)(0.33335f * this.sl);
    }
    
    @Override
    public void a(final dN.a a, final im im) {
        this.a(im, gz.minecraft.thePlayer.field_70177_z);
    }
    
    @Override
    public void b(final im im) {
        this.a(im, 90.0f);
    }
    
    public void a(final im im, final float n) {
        this.b(im, n);
        this.f(im);
    }
    
    private void b(final im im, final float n) {
        float n2 = n;
        if (n2 < 0.0f) {
            n2 += 360.0f;
        }
        final float n3 = (-this.sm + n2 * this.pixelsPerDegree + 7.5f * this.pixelsPerDegree) % this.textureWidth;
        ii.a(0, this.texture);
        this.kw.b(im, 0, 0, this.sk, this.gP, this.sf, this.sg);
        this.kw.a(im, 0, 0, n3, 0.0f, this.so, this.textureHeight, this.sk, this.gP, (float)this.textureWidth, (float)this.textureHeight, this.sh, this.si);
        this.kw.b(im, 0 + this.sk, 0, this.sj, this.gP, this.sg, this.sg);
        this.kw.a(im, 0 + this.sk, 0, n3 + this.so, 0.0f, this.sn, this.textureHeight, this.sj, this.gP, (float)this.textureWidth, (float)this.textureHeight, this.si, this.si);
        this.kw.b(im, 0 + this.sk + this.sj, 0, this.sk, this.gP, this.sg, this.sf);
        this.kw.a(im, 0 + this.sk + this.sj, 0, n3 + this.so + this.sn, 0.0f, this.so, this.textureHeight, this.sk, this.gP, (float)this.textureWidth, (float)this.textureHeight, this.si, this.sh);
    }
    
    private void f(final im im) {
        final float n = (this.gO - ((a)this.jC).sr) / 2.0f;
        final float n2 = -1.0f;
        final float n3 = n2 - ((a)this.jC).sr;
        final int red = ((a)this.jC).sw.getRed();
        final int green = ((a)this.jC).sw.getGreen();
        final int blue = ((a)this.jC).sw.getBlue();
        ii.lG();
        ii.lK();
        ii.c(770, 771, 1, 0);
        final ii lp = ii.lP();
        lp.b(ii.a.TRIANGLE_FAN, DefaultVertexFormats.POSITION_COLOR);
        lp.a(im, n, n2, 0.0).d(red, green, blue, 255).lR();
        lp.a(im, n + ((a)this.jC).sr, n3, 0.0).d(red, green, blue, 255).lR();
        lp.a(im, n - ((a)this.jC).sr, n3, 0.0).d(red, green, blue, 255).lR();
        lp.lS();
        ii.lL();
        ii.lH();
    }
    
    private void ie() {
        this.texture = ((a)this.jC).sq.texture;
        this.textureWidth = ((a)this.jC).sq.textureWidth;
        this.textureHeight = ((a)this.jC).sq.textureHeight;
        this.pixelsPerDegree = ((a)this.jC).sq.pixelsPerDegree;
    }
    
    private void if() {
        this.sg = ((a)this.jC).la.getRGB();
        this.sf = (this.sg & 0xFFFFFF);
        this.si = ((a)this.jC).sv.gQ();
        this.sh = (this.si & 0xFFFFFF);
    }
    
    private void ig() {
        this.gO = ((a)this.jC).gO;
        this.gP = (int)(((a)this.jC).sr * 0.75 + 18.0);
        this.sj = (int)(0.33330002f * this.gO);
        this.sk = (int)(0.33335f * this.gO);
        this.sl = ((a)this.jC).st * this.pixelsPerDegree;
        this.sm = this.sl / 2.0f;
        this.sn = (int)(0.33330002f * this.sl);
        this.so = (int)(0.33335f * this.sl);
    }
    
    @Override
    public void eP() {
        this.ie();
        this.ig();
        this.if();
    }
    
    @Override
    public int eC() {
        return this.gP;
    }
    
    @Override
    public int eB() {
        return this.gO;
    }
    
    static {
        minecraft = Minecraft.getMinecraft();
    }
    
    public enum b
    {
        @ei(fu = "default", fh = "Default")
        DEFAULT("default.png", 1728, 70, 4.8f), 
        @ei(fu = "simple", fh = "Simple")
        SIMPLE("simple.png", 1728, 84, 4.8f), 
        @ei(fu = "noTick", fh = "No Tick")
        NO_TICK("no_tick.png", 1728, 84, 4.8f);
        
        private static final String BASE_PATH = "textures/direction/";
        public final ResourceLocation texture;
        public final int textureWidth;
        public final int textureHeight;
        public final float pixelsPerDegree;
        
        private b(final String s2, final int textureWidth, final int textureHeight, final float pixelsPerDegree) {
            this.texture = new ResourceLocation("feather", "textures/direction/" + s2);
            this.textureWidth = textureWidth;
            this.textureHeight = textureHeight;
            this.pixelsPerDegree = pixelsPerDegree;
        }
        
        private static /* synthetic */ b[] $values() {
            return new b[] { b.DEFAULT, b.SIMPLE, b.NO_TICK };
        }
        
        static {
            $VALUES = $values();
        }
    }
    
    @ej(fL = true, fI = 30.0)
    public static class a extends dX
    {
        @em(fS = 0)
        public eW sp;
        @er(fu = "type", fh = "Type", fW = "default", fm = @em(fS = 1))
        public b sq;
        @er(fu = "markerSize", fh = "Marker Size", fW = "3", fm = @em(fS = 2))
        @el(fQ = 1, fP = 9)
        public int sr;
        @er(fu = "shadow", fh = "Shadow", fW = "true", fm = @em(fS = 3))
        public boolean ss;
        @er(fu = "visibleDegrees", fh = "Visible Degrees", fW = "200", fm = @em(fS = 4))
        @el(fQ = 45, fP = 360)
        public int st;
        @er(fu = "width", fh = "Width", fW = "200", fm = @em(fS = 5))
        @el(fQ = 50, fP = 300)
        public int gO;
        @em(fS = 10)
        public eW su;
        @er(fu = "backgroundColor", fh = "Background Color", fW = "7/7/7/100", fm = @em(fS = 11))
        public Color la;
        @er(fu = "directionColor", fh = "Direction Color", fW = "false/255/255/255", fm = @em(fS = 12))
        public eT sv;
        @er(fu = "markerColor", fh = "Marker Color", fW = "255/255/255", fm = @em(fS = 13))
        public Color sw;
        
        public a() {
            this.sp = new eW("Direction");
            this.su = new eW("Colors");
        }
        
        @Override
        public double fp() {
            return ip.mn() / ip.mr() / 2.0;
        }
    }
}
