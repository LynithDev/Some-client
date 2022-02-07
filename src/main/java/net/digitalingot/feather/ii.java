package net.digitalingot.feather;

import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.util.vector.*;
import java.awt.*;
import net.minecraft.client.renderer.vertex.*;
import java.util.*;
import net.minecraft.client.*;

public final class ii
{
    public static final float Bm = 7.0f;
    public static final float Bn = 1.0f;
    public static final float Bo = 1.0f;
    private static final FontRenderer Bp;
    private static final TextureManager Bq;
    private final WorldRenderer Br;
    private VertexFormat Bs;
    
    private ii() {
        throw new AssertionError();
    }
    
    private ii(final WorldRenderer br) {
        this.Br = br;
    }
    
    public static void ly() {
        GlStateManager.disableAlpha();
    }
    
    public static void lz() {
        GlStateManager.enableAlpha();
    }
    
    public static void a(final int n, final float n2) {
        GlStateManager.alphaFunc(n, n2);
    }
    
    public static void Z(final int n) {
        GlStateManager.shadeModel(n);
    }
    
    public static void lA() {
        GlStateManager.enableLighting();
    }
    
    public static void lB() {
        GlStateManager.disableLighting();
    }
    
    public static void lC() {
        GlStateManager.enableDepth();
    }
    
    public static void lD() {
        GlStateManager.disableDepth();
    }
    
    public static void b(final int n) {
        GlStateManager.depthFunc(n);
    }
    
    public static void r(final boolean b) {
        GlStateManager.depthMask(b);
    }
    
    public static void lE() {
        GlStateManager.enableRescaleNormal();
    }
    
    public static void lF() {
        GlStateManager.disableRescaleNormal();
    }
    
    public static void lG() {
        GlStateManager.enableBlend();
    }
    
    public static void lH() {
        GlStateManager.disableBlend();
    }
    
    public static void lI() {
        GlStateManager.disableCull();
    }
    
    public static void lJ() {
        GlStateManager.disableCull();
    }
    
    public static void c(final int n, final int n2, final int n3, final int n4) {
        GlStateManager.tryBlendFuncSeparate(n, n2, n3, n4);
    }
    
    public static void n(final int n, final int n2) {
        GlStateManager.blendFunc(n, n2);
    }
    
    @Deprecated
    public static void lK() {
        GlStateManager.disableTexture2D();
    }
    
    @Deprecated
    public static void lL() {
        GlStateManager.enableTexture2D();
    }
    
    public static void a(final float n, final float n2, final float n3, final float n4) {
        GlStateManager.color(n, n2, n3, n4);
    }
    
    public static void a(final float n, final float n2, final float n3) {
        GlStateManager.color(n, n2, n3);
    }
    
    public static void j(final float n) {
        GL11.glLineWidth(n);
    }
    
    public static float lM() {
        return GL11.glGetFloat(2849);
    }
    
    public static void a(final im im, final String s, final float n, final float n2, final int n3, final boolean b) {
        if ((n3 >> 24 & 0xFF) <= 10) {
            return;
        }
        ik.lU();
        im.ma();
        ii.Bp.drawString(s, n, n2, n3, b);
        ik.lV();
    }
    
    public static void a(final im im, final String s, final float n, final float n2, final int n3, final int n4) {
        if ((n3 >> 24 & 0xFF) <= 10) {
            return;
        }
        ik.lU();
        im.ma();
        ii.Bp.drawString(s, n + 1.0f, n2 + 1.0f, n4, false);
        ii.Bp.drawString(s, n, n2, n3, false);
        ik.lV();
    }
    
    public static int az(final String s) {
        return ii.Bp.getStringWidth(s);
    }
    
    public static float a(final char c) {
        return (float)ii.Bp.getCharWidth(c);
    }
    
    public static float s(final boolean b) {
        float n = 7.0f;
        if (b) {
            ++n;
        }
        return n;
    }
    
    public static int lN() {
        return GL11.glGetInteger(34016);
    }
    
    public static void aa(final int activeTexture) {
        GlStateManager.setActiveTexture(activeTexture);
    }
    
    public static void a(final int n, final Runnable runnable) {
        final int glGetInteger = GL11.glGetInteger(32873);
        ab(n);
        runnable.run();
        ab(glGetInteger);
    }
    
    private static void ab(final int n) {
        GlStateManager.bindTexture(n);
    }
    
    public static void o(final int n, final int n2) {
        b(n, () -> ab(n2));
    }
    
    public static void a(final int n, final ResourceLocation resourceLocation) {
        o(n, b(resourceLocation));
    }
    
    private static int b(final ResourceLocation resourceLocation) {
        Object texture = ii.Bq.getTexture(resourceLocation);
        if (texture == null) {
            texture = new SimpleTexture(resourceLocation);
            ii.Bq.loadTexture(resourceLocation, (ITextureObject)texture);
        }
        return ((ITextureObject)texture).getGlTextureId();
    }
    
    public static void b(final int n, final Runnable runnable) {
        final int ln = lN();
        aa(33984 + n);
        runnable.run();
        aa(ln);
    }
    
    public static Tessellator lO() {
        return Tessellator.getInstance();
    }
    
    public static ii lP() {
        return new ii(lO().getWorldRenderer());
    }
    
    public WorldRenderer lQ() {
        return this.Br;
    }
    
    public ii a(final im im, final double n, final double n2, final double n3) {
        final Vector4f vector4f = new Vector4f((float)n, (float)n2, (float)n3, 1.0f);
        Matrix4f.transform(im.lY().mc(), vector4f, vector4f);
        this.Br.pos((double)vector4f.getX(), (double)vector4f.getY(), (double)vector4f.getZ());
        return this;
    }
    
    public ii a(final im im, final float n, final float n2, final float n3) {
        final Vector3f vector3f = new Vector3f(n, n2, n3);
        Matrix3f.transform(im.lY().md(), vector3f, vector3f);
        this.Br.normal(vector3f.getX(), vector3f.getY(), vector3f.getZ());
        return this;
    }
    
    public ii d(final int n, final int n2, final int n3, final int n4) {
        this.Br.color(n, n2, n3, n4);
        return this;
    }
    
    public ii b(final float n, final float n2, final float n3, final float n4) {
        this.Br.color(n, n2, n3, n4);
        return this;
    }
    
    public ii g(final Color color) {
        return this.d(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }
    
    public ii lR() {
        this.Br.endVertex();
        return this;
    }
    
    public ii c(final double n, final double n2) {
        this.Br.tex(n, n2);
        return this;
    }
    
    public ii a(final a a, final VertexFormat bs) {
        this.Bs = bs;
        this.Br.begin(a.vertexMode, bs);
        return this;
    }
    
    public ii b(final a a, final VertexFormat vertexFormat) {
        return this.a(a, vertexFormat);
    }
    
    public void lS() {
        this.lT();
    }
    
    public void h(final int n, final int n2, final int n3) {
        this.Br.sortVertexData((float)n, (float)n2, (float)n3);
        this.lT();
    }
    
    private static boolean[] a(final VertexFormat vertexFormat) {
        final VertexFormatElement.EnumUsage uv = VertexFormatElement.EnumUsage.UV;
        boolean[] copy = new boolean[2];
        for (final VertexFormatElement vertexFormatElement : vertexFormat.getElements()) {
            if (vertexFormatElement.getUsage() == uv) {
                final int index = vertexFormatElement.getIndex();
                if (copy.length <= index) {
                    copy = Arrays.copyOf(copy, index + 1);
                }
                copy[index] = true;
            }
        }
        return copy;
    }
    
    private void lT() {
        final VertexFormat bs = this.Bs;
        if (bs == null) {
            lO().draw();
            return;
        }
        final boolean[] a = a(bs);
        final boolean[] array = new boolean[a.length];
        for (int i = 0; i < array.length; ++i) {
            final Object o;
            final int n;
            final Object o2;
            final Object o3;
            final int n2;
            final int n3;
            b(i, () -> {
                GL11.glIsEnabled(3553);
                o[n] = o2;
                n2 = o3[n];
                if (n3 != n2) {
                    if (n2 != 0) {
                        GlStateManager.enableTexture2D();
                    }
                    else {
                        GlStateManager.disableTexture2D();
                    }
                }
                return;
            });
        }
        lO().draw();
        for (int j = 0; j < array.length; ++j) {
            if (array[j] != a[j]) {
                if (array[j]) {
                    b(j, GlStateManager::enableTexture2D);
                }
                else {
                    b(j, GlStateManager::disableTexture2D);
                }
            }
        }
    }
    
    @Deprecated
    public static void lU() {
        ik.lU();
    }
    
    @Deprecated
    public static void lV() {
        ik.lV();
    }
    
    @Deprecated
    public static void b(final float n, final float n2, final float n3) {
        ik.b(n, n2, n3);
    }
    
    @Deprecated
    public static void a(final double n, final double n2, final double n3) {
        ik.a(n, n2, n3);
    }
    
    @Deprecated
    public static void c(final float n, final float n2, final float n3, final float n4) {
        ik.c(n, n2, n3, n4);
    }
    
    @Deprecated
    public static void c(final float n, final float n2, final float n3) {
        ik.c(n, n2, n3);
    }
    
    @Deprecated
    public static void b(final double n, final double n2, final double n3) {
        ik.b(n, n2, n3);
    }
    
    static {
        Bp = Minecraft.getMinecraft().fontRendererObj;
        Bq = Minecraft.getMinecraft().getTextureManager();
    }
    
    public enum a
    {
        LINES(1), 
        LINE_STRIP(3), 
        TRIANGLES(4), 
        TRIANGLE_STRIP(5), 
        TRIANGLE_FAN(6), 
        QUADS(7);
        
        private final int mode;
        private final int vertexMode;
        
        private a(final int n2) {
            this.mode = n2;
            this.vertexMode = n2;
        }
        
        public static a fromGlMode(final int n) {
            switch (n) {
                case 1: {
                    return a.LINES;
                }
                case 3: {
                    return a.LINE_STRIP;
                }
                case 4: {
                    return a.TRIANGLES;
                }
                case 5: {
                    return a.TRIANGLE_STRIP;
                }
                case 6: {
                    return a.TRIANGLE_FAN;
                }
                case 7: {
                    return a.QUADS;
                }
                default: {
                    throw new IllegalArgumentException("Invalid mode " + n);
                }
            }
        }
        
        private static /* synthetic */ a[] $values() {
            return new a[] { a.LINES, a.LINE_STRIP, a.TRIANGLES, a.TRIANGLE_STRIP, a.TRIANGLE_FAN, a.QUADS };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
