package net.digitalingot.feather;

import net.minecraft.util.*;
import org.jetbrains.annotations.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import java.nio.*;
import org.lwjgl.*;

public class bv
{
    private static final ResourceLocation[] cQ;
    @NotNull
    private final bs cR;
    private float cS;
    private int cT;
    
    public bv(@NotNull final bs cr) {
        this.cR = cr;
    }
    
    public void a(final float cs) {
        if (this.cS > cs) {
            ++this.cT;
        }
        this.cS = cs;
        final float n = this.cT + cs;
        this.a(this.cR.mc, (float)Math.sin(n * 0.001f) * 5.0f + 25.0f, -n * 0.1f, 1.0f);
    }
    
    public void a(final Minecraft minecraft, final float n, final float n2, final float n3) {
        final Tessellator instance = Tessellator.getInstance();
        final WorldRenderer worldRenderer = instance.getWorldRenderer();
        GlStateManager.matrixMode(5889);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        GlStateManager.multMatrix(this.a(85.0, minecraft.currentScreen.width / (float)minecraft.currentScreen.height, 0.05f, 10.0f));
        GlStateManager.matrixMode(5888);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.disableCull();
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        for (int i = 0; i < 4; ++i) {
            GlStateManager.pushMatrix();
            GlStateManager.translate((i % 2 / 2.0f - 0.5f) / 256.0f, (i / 2 / 2.0f - 0.5f) / 256.0f, 0.0f);
            GlStateManager.rotate(n, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(n2, 0.0f, 1.0f, 0.0f);
            for (int j = 0; j < 6; ++j) {
                minecraft.getTextureManager().bindTexture(bv.cQ[j]);
                worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                final int n4 = Math.round(255.0f * n3) / (i + 1);
                if (j == 0) {
                    worldRenderer.pos(-1.0, -1.0, 1.0).tex(0.0, 0.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(-1.0, 1.0, 1.0).tex(0.0, 1.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(1.0, 1.0, 1.0).tex(1.0, 1.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(1.0, -1.0, 1.0).tex(1.0, 0.0).color(255, 255, 255, n4).endVertex();
                }
                if (j == 1) {
                    worldRenderer.pos(1.0, -1.0, 1.0).tex(0.0, 0.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(1.0, 1.0, 1.0).tex(0.0, 1.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(1.0, 1.0, -1.0).tex(1.0, 1.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(1.0, -1.0, -1.0).tex(1.0, 0.0).color(255, 255, 255, n4).endVertex();
                }
                if (j == 2) {
                    worldRenderer.pos(1.0, -1.0, -1.0).tex(0.0, 0.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(1.0, 1.0, -1.0).tex(0.0, 1.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(-1.0, 1.0, -1.0).tex(1.0, 1.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(-1.0, -1.0, -1.0).tex(1.0, 0.0).color(255, 255, 255, n4).endVertex();
                }
                if (j == 3) {
                    worldRenderer.pos(-1.0, -1.0, -1.0).tex(0.0, 0.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(-1.0, 1.0, -1.0).tex(0.0, 1.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(-1.0, 1.0, 1.0).tex(1.0, 1.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(-1.0, -1.0, 1.0).tex(1.0, 0.0).color(255, 255, 255, n4).endVertex();
                }
                if (j == 4) {
                    worldRenderer.pos(-1.0, -1.0, -1.0).tex(0.0, 0.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(-1.0, -1.0, 1.0).tex(0.0, 1.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(1.0, -1.0, 1.0).tex(1.0, 1.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(1.0, -1.0, -1.0).tex(1.0, 0.0).color(255, 255, 255, n4).endVertex();
                }
                if (j == 5) {
                    worldRenderer.pos(-1.0, 1.0, 1.0).tex(0.0, 0.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(-1.0, 1.0, -1.0).tex(0.0, 1.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(1.0, 1.0, -1.0).tex(1.0, 1.0).color(255, 255, 255, n4).endVertex();
                    worldRenderer.pos(1.0, 1.0, 1.0).tex(1.0, 0.0).color(255, 255, 255, n4).endVertex();
                }
                instance.draw();
            }
            GlStateManager.popMatrix();
            GlStateManager.colorMask(true, true, true, false);
        }
        GlStateManager.colorMask(true, true, true, true);
        GlStateManager.matrixMode(5889);
        GlStateManager.popMatrix();
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        GlStateManager.depthMask(true);
        GlStateManager.enableCull();
        GlStateManager.enableDepth();
    }
    
    private FloatBuffer a(final double n, final float n2, final float n3, final float n4) {
        final float n5 = (float)(1.0 / Math.tan(n * 0.01745329238474369 / 2.0));
        final FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(16);
        floatBuffer.put(this.c(0, 0), n5 / n2);
        floatBuffer.put(this.c(0, 1), 0.0f);
        floatBuffer.put(this.c(0, 2), 0.0f);
        floatBuffer.put(this.c(0, 3), 0.0f);
        floatBuffer.put(this.c(1, 0), 0.0f);
        floatBuffer.put(this.c(1, 1), n5);
        floatBuffer.put(this.c(1, 2), 0.0f);
        floatBuffer.put(this.c(1, 3), 0.0f);
        floatBuffer.put(this.c(2, 0), 0.0f);
        floatBuffer.put(this.c(2, 1), 0.0f);
        floatBuffer.put(this.c(2, 2), (n4 + n3) / (n3 - n4));
        floatBuffer.put(this.c(2, 3), 2.0f * n4 * n3 / (n3 - n4));
        floatBuffer.put(this.c(3, 0), 0.0f);
        floatBuffer.put(this.c(3, 1), 0.0f);
        floatBuffer.put(this.c(3, 2), -1.0f);
        floatBuffer.put(this.c(3, 3), 0.0f);
        return floatBuffer;
    }
    
    private int c(final int n, final int n2) {
        return n2 * 4 + n;
    }
    
    static {
        cQ = new ResourceLocation[] { new ResourceLocation("feather:textures/gui/panorama/panorama_0.png"), new ResourceLocation("feather:textures/gui/panorama/panorama_1.png"), new ResourceLocation("feather:textures/gui/panorama/panorama_2.png"), new ResourceLocation("feather:textures/gui/panorama/panorama_3.png"), new ResourceLocation("feather:textures/gui/panorama/panorama_4.png"), new ResourceLocation("feather:textures/gui/panorama/panorama_5.png") };
    }
}
