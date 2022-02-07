package net.digitalingot.feather;

import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.client.entity.*;
import org.apache.commons.lang3.math.*;
import net.digitalingot.feather.mixin.core.*;
import net.minecraft.client.renderer.chunk.*;
import java.util.*;
import java.awt.*;
import net.minecraft.entity.player.*;

@dP(eL = dW.COORDINATES, eM = @dV(fh = "Coordinates", fi = "https://assets.feathercdn.net/game/mods/coordinates.svg", fj = "Display your location and world info", fk = { df.a.PVP, df.a.HUD }))
public class gy extends dN<a>
{
    private static final int rC = 2;
    private static final String[] rD;
    private static final String[] rE;
    private static final String[] rF;
    private static final int rG = 3;
    private static final int rH = 10;
    private final Minecraft nI;
    private String rI;
    private String rJ;
    private int rK;
    
    public gy() {
        this.nI = Minecraft.getMinecraft();
    }
    
    @Override
    public void a(final dN.a a, final im im) {
        final EntityPlayerSP thePlayer = this.nI.thePlayer;
        final int floor_double = MathHelper.floor_double(((EntityPlayer)thePlayer).field_70169_q);
        final int floor_double2 = MathHelper.floor_double(((EntityPlayer)thePlayer).field_70167_r);
        final int floor_double3 = MathHelper.floor_double(((EntityPlayer)thePlayer).field_70166_s);
        this.rI = this.nI.theWorld.func_175726_f(new BlockPos(floor_double, floor_double2, floor_double3)).getBiome(new BlockPos(floor_double & 0xF, floor_double2, floor_double3 & 0xF), this.nI.theWorld.func_72959_q()).biomeName;
        this.a(im, floor_double, floor_double2, floor_double3, this.f(((EntityPlayer)thePlayer).field_70177_z), this.rI, this.rJ = this.id());
    }
    
    @Override
    public void b(final im im) {
        if (this.nI.thePlayer != null) {
            this.a(null, im);
        }
        else {
            this.a(im, 100, 100, 100, 0, "Plains", this.rJ = "C: 0 (s)");
        }
    }
    
    @Override
    public int eF() {
        return this.eB();
    }
    
    @Override
    public int eG() {
        return this.eC();
    }
    
    private void a(final im im, final int n, final int n2, final int n3, final int n4, final String s, final String s2) {
        final int n5 = 12;
        final int n6 = ((a)this.jC).rR ? 2 : 0;
        if (((a)this.jC).rR) {
            this.kw.b(im, 0, 0, this.eB(), this.eC(), ((a)this.jC).la.getRGB());
        }
        final String s3 = gy.rD[n4];
        final String s4 = gy.rE[n4];
        final String s5 = gy.rF[n4];
        switch (gy$1.rL[((a)this.jC).rM.ordinal()]) {
            case 1: {
                final String string = "(" + n + ", " + (((a)this.jC).rP ? (n2 + ", ") : "") + n3 + ")";
                this.kw.a(im, string, (float)n6, 2.0f, ((a)this.jC).rN.gQ(), ((a)this.jC).lh, ((a)this.jC).rN.gR());
                int rk = this.kw.V(string) + 3;
                if (((a)this.jC).rT) {
                    this.kw.a(im, s, (float)(n6 + rk), 2.0f, ((a)this.jC).rU, ((a)this.jC).lh);
                    rk += this.kw.V(s) + 3;
                }
                if (((a)this.jC).rW) {
                    this.kw.a(im, s2, (float)(n6 + rk), 2.0f, ((a)this.jC).rX, ((a)this.jC).lh);
                    rk += this.kw.V(s2) + 3;
                }
                if (((a)this.jC).rO) {
                    this.kw.a(im, s4, (float)(n6 + rk), -1.0f, ((a)this.jC).sa, ((a)this.jC).lh);
                    this.kw.a(im, s5, (float)(n6 + rk), 5.0f, ((a)this.jC).sa, ((a)this.jC).lh);
                    rk += this.kw.V("++");
                }
                if (((a)this.jC).rZ) {
                    this.kw.a(im, s3, (float)(n6 + rk), 2.0f, ((a)this.jC).sa, ((a)this.jC).lh);
                    rk += this.kw.V("NW");
                }
                this.rK = rk;
                break;
            }
            case 2: {
                final String string2 = "X " + n;
                final String s6 = ((a)this.jC).rP ? ("Y " + n2) : "";
                final String string3 = "Z " + n3;
                final int max = NumberUtils.max(new int[] { this.kw.V(string2), this.kw.V(s6), this.kw.V(string3) });
                this.kw.a(im, string2, (float)n6, 2.0f, ((a)this.jC).rN, ((a)this.jC).lh);
                if (((a)this.jC).rP) {
                    this.kw.a(im, s6, (float)n6, (float)(n5 + 2), ((a)this.jC).rN, ((a)this.jC).lh);
                }
                if (((a)this.jC).rZ) {
                    if (((a)this.jC).rO && !((a)this.jC).rP) {
                        this.kw.a(im, s3, (float)(n6 + max + 10 + 15), n5 / 2.0f + 2.0f, ((a)this.jC).sa, ((a)this.jC).lh);
                    }
                    else {
                        this.kw.a(im, s3, (float)(n6 + max + 10), (float)(n5 + 2), ((a)this.jC).sa, ((a)this.jC).lh);
                    }
                }
                if (((a)this.jC).rO) {
                    this.kw.a(im, s4, (float)(n6 + max + 10), 2.0f, ((a)this.jC).sa, ((a)this.jC).lh);
                    this.kw.a(im, s5, (float)(n6 + max + 10), (float)((((a)this.jC).rP ? 2 : 1) * n5 + 2), ((a)this.jC).sa, ((a)this.jC).lh);
                }
                this.kw.a(im, string3, (float)n6, (float)((((a)this.jC).rP ? 2 : 1) * n5 + 2), ((a)this.jC).rN, ((a)this.jC).lh);
                if (((a)this.jC).rT) {
                    this.kw.a(im, s, (float)n6, (float)((((a)this.jC).rP ? 3 : 2) * n5 + 2), ((a)this.jC).rU, ((a)this.jC).lh);
                }
                if (((a)this.jC).rW) {
                    int n7 = 0;
                    if (((a)this.jC).rP) {
                        ++n7;
                    }
                    if (((a)this.jC).rT) {
                        ++n7;
                    }
                    this.kw.a(im, s2, (float)n6, (float)((2 + n7) * n5 + 2), ((a)this.jC).rX, ((a)this.jC).lh);
                    break;
                }
                break;
            }
        }
    }
    
    @Override
    public int eB() {
        try {
            int n;
            if (((a)this.jC).rM == a.a.VERTICAL) {
                n = NumberUtils.max(new int[] { this.kw.V("X -17777") + (((a)this.jC).rZ ? (10 + this.kw.V("NW")) : 0), ((a)this.jC).rW ? this.kw.V(this.rJ) : 0, ((a)this.jC).rT ? this.kw.V(this.rI) : 0 });
            }
            else {
                n = this.rK;
            }
            return ((a)this.jC).rR ? (4 + n) : n;
        }
        catch (NullPointerException ex) {
            return 0;
        }
    }
    
    @Override
    public int eC() {
        if (((a)this.jC).rM == a.a.HORIZONTAL) {
            return 14;
        }
        return (2 + (((a)this.jC).rT ? 1 : 0) + (((a)this.jC).rP ? 1 : 0) + (((a)this.jC).rW ? 1 : 0)) * 12 + 2;
    }
    
    private int f(final float n) {
        return MathHelper.floor_double((MathHelper.wrapAngleTo180_float(n) + 180.0 + 22.5) % 360.0 / 45.0);
    }
    
    private String id() {
        final int length = ((i)this.nI.renderGlobal).getViewFrustum().renderChunks.length;
        int n = 0;
        for (final c c : ((i)this.nI.renderGlobal).getRenderInfos()) {
            final CompiledChunk dummy = CompiledChunk.DUMMY;
            final CompiledChunk compiledChunk = c.getRenderChunk().compiledChunk;
            final boolean empty = compiledChunk.isEmpty();
            if (compiledChunk != dummy && !empty) {
                ++n;
            }
        }
        return String.format("C %d/%d %s", n, length, this.nI.renderChunksMany ? "(s)" : "");
    }
    
    static {
        rD = new String[] { "N", "NE", "E", "SE", "S", "SW", "W", "NW" };
        rE = new String[] { "", "+", "++", "+", "", "-", "--", "-" };
        rF = new String[] { "--", "-", "", "+", "++", "+", "", "-" };
    }
    
    @ej(fL = true, fI = 28.0)
    public static class a extends dX
    {
        @em(fS = 0)
        public eW mm;
        @er(fu = "orientation", fh = "Orientation", fW = "vertical", fm = @em(fS = 1))
        public gy.a.a rM;
        @er(fu = "coordinatesColor", fh = "Color", fm = @em(fS = 2))
        public eT rN;
        @er(fu = "directionDetails", fh = "Direction Details", fW = "true", fm = @em(fS = 3))
        public boolean rO;
        @er(fu = "yCoordinate", fh = "Y Coordinate", fW = "true", fm = @em(fS = 4))
        public boolean rP;
        @er(fu = "textShadow", fh = "Text Shadow", fW = "false", fm = @em(fS = 5))
        public boolean lh;
        @em(fS = 10)
        public eW rQ;
        @er(fu = "background", fh = "Background", fW = "true", fm = @em(fS = 11))
        public boolean rR;
        @er(fu = "backgroundColor", fh = "Color", fW = "7/7/7/146", fZ = @en(fu = "background"), fm = @em(fS = 12))
        public Color la;
        @em(fS = 20)
        public eW rS;
        @er(fu = "biome", fh = "Biome", fW = "true", fm = @em(fS = 21))
        public boolean rT;
        @er(fu = "biomeColor", fh = "Color", fZ = @en(fu = "biome"), fm = @em(fS = 22))
        public eT rU;
        @em(fS = 30)
        public eW rV;
        @er(fu = "chunkCounter", fh = "Chunk Counter", fW = "true", fm = @em(fS = 31))
        public boolean rW;
        @er(fu = "chunkCounterColor", fh = "Color", fZ = @en(fu = "chunkCounter"), fm = @em(fS = 32))
        public eT rX;
        @em(fS = 40)
        public eW rY;
        @er(fu = "directions", fh = "Directions", fW = "true", fm = @em(fS = 41))
        public boolean rZ;
        @er(fu = "directionsColor", fh = "Color", fW = "false/0/255/255", fZ = @en(fu = "directions"), fm = @em(fS = 42))
        public eT sa;
        
        public a() {
            this.mm = new eW("General");
            this.rQ = new eW("Background");
            this.rS = new eW("Biome");
            this.rV = new eW("Chunk Counter");
            this.rY = new eW("Directions");
        }
        
        public enum a
        {
            @ei(fu = "horizontal", fh = "Horizontal")
            HORIZONTAL, 
            @ei(fu = "vertical", fh = "Vertical")
            VERTICAL;
            
            private static /* synthetic */ a[] $values() {
                return new a[] { a.HORIZONTAL, a.VERTICAL };
            }
            
            static {
                $VALUES = $values();
            }
        }
    }
}
