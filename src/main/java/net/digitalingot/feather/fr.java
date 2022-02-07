package net.digitalingot.feather;

import net.minecraft.client.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import java.awt.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.vertex.*;

@dP(eL = dW.BLOCK_OVERLAY, eM = @dV(fh = "Block Overlay", fi = "https://assets.feathercdn.net/game/mods/blockoverlay.svg", fj = "Add overlay and outline to blocks", fk = {}))
public class fr extends dQ<a>
{
    @Override
    public void initialize() {
        final Minecraft minecraft;
        final BlockPos blockPos;
        WorldClient theWorld;
        final Block block;
        final RenderManager renderManager;
        double viewerPosX;
        double viewerPosY;
        double viewerPosZ;
        final Color color2;
        Color color;
        final AxisAlignedBB axisAlignedBB;
        final Color color3;
        float n;
        Color gs;
        final Color color4;
        R.bl.a(() -> {
            Minecraft.getMinecraft();
            if (!this.eS()) {
                return aq.PASS;
            }
            else if (((a)this.jC).mn == a.a.NONE) {
                return aq.FAIL;
            }
            else {
                minecraft.objectMouseOver.getBlockPos();
                if (blockPos == null) {
                    return aq.FAIL;
                }
                else {
                    theWorld = minecraft.theWorld;
                    ((World)theWorld).getBlockState(blockPos).getBlock();
                    if (block == null || block == Blocks.air || block == Blocks.water || block == Blocks.lava) {
                        return aq.FAIL;
                    }
                    else if (block == Blocks.flowing_water || block == Blocks.flowing_lava) {
                        return aq.FAIL;
                    }
                    else {
                        minecraft.getRenderManager();
                        viewerPosX = renderManager.viewerPosX;
                        viewerPosY = renderManager.viewerPosY;
                        viewerPosZ = renderManager.viewerPosZ;
                        ii.lG();
                        ii.c(770, 771, 1, 0);
                        ii.lK();
                        ii.r(false);
                        block.setBlockBoundsBasedOnState((IBlockAccess)theWorld, blockPos);
                        block.getSelectedBoundingBox((World)theWorld, blockPos).addCoord(-0.002, -0.002, -0.002).addCoord(0.002, 0.002, 0.002).offset(-viewerPosX, -viewerPosY, -viewerPosZ);
                        if (((a)this.jC).mn == a.a.FULL) {
                            ((a)this.jC).mo.gS();
                            if (((a)this.jC).mo.gR()) {
                                // new(java.awt.Color.class)
                                new Color(iG.sL().sN());
                            }
                            else {
                                color = color2;
                            }
                            a(new im(), axisAlignedBB, color3.getRed() / 255.0f, color3.getGreen() / 255.0f, color3.getBlue() / 255.0f, color3.getAlpha() / 255.0f);
                        }
                        n = ((a)this.jC).mq / 20.0f;
                        if (n != 1.0f) {
                            ii.j(n);
                        }
                        if (((a)this.jC).mr.gR()) {
                            // new(java.awt.Color.class)
                            new Color(iG.sL().sN());
                        }
                        else {
                            gs = ((a)this.jC).mr.gS();
                        }
                        ii.a(color4.getRed() / 255.0f, color4.getGreen() / 255.0f, color4.getBlue() / 255.0f, ((a)this.jC).mr.gS().getAlpha() / 255.0f);
                        RenderGlobal.drawSelectionBoundingBox(axisAlignedBB);
                        ii.r(true);
                        ii.lL();
                        ii.lH();
                        if (n != 1.0f) {
                            ii.j(1.0f);
                        }
                        return aq.FAIL;
                    }
                }
            }
        });
    }
    
    private static void a(final im im, final AxisAlignedBB axisAlignedBB, final float n, final float n2, final float n3, final float n4) {
        final ii lp = ii.lP();
        lp.b(ii.a.TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
        a(lp, im, (float)axisAlignedBB.minX, (float)axisAlignedBB.minY, (float)axisAlignedBB.minZ, (float)axisAlignedBB.maxX, (float)axisAlignedBB.maxY, (float)axisAlignedBB.maxZ, n, n2, n3, n4);
        lp.lS();
    }
    
    private static void a(final ii ii, final im im, final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8, final float n9, final float n10) {
        ii.a(im, n, n2, (double)n3).b(n7, n8, n9, n10).lR();
        ii.a(im, n, n2, (double)n3).b(n7, n8, n9, n10).lR();
        ii.a(im, n, n2, (double)n3).b(n7, n8, n9, n10).lR();
        ii.a(im, n, n2, (double)n6).b(n7, n8, n9, n10).lR();
        ii.a(im, n, n5, (double)n3).b(n7, n8, n9, n10).lR();
        ii.a(im, n, n5, (double)n6).b(n7, n8, n9, n10).lR();
        ii.a(im, n, n5, (double)n6).b(n7, n8, n9, n10).lR();
        ii.a(im, n, n2, (double)n6).b(n7, n8, n9, n10).lR();
        ii.a(im, n4, n5, (double)n6).b(n7, n8, n9, n10).lR();
        ii.a(im, n4, n2, (double)n6).b(n7, n8, n9, n10).lR();
        ii.a(im, n4, n2, (double)n6).b(n7, n8, n9, n10).lR();
        ii.a(im, n4, n2, (double)n3).b(n7, n8, n9, n10).lR();
        ii.a(im, n4, n5, (double)n6).b(n7, n8, n9, n10).lR();
        ii.a(im, n4, n5, (double)n3).b(n7, n8, n9, n10).lR();
        ii.a(im, n4, n5, (double)n3).b(n7, n8, n9, n10).lR();
        ii.a(im, n4, n2, (double)n3).b(n7, n8, n9, n10).lR();
        ii.a(im, n, n5, (double)n3).b(n7, n8, n9, n10).lR();
        ii.a(im, n, n2, (double)n3).b(n7, n8, n9, n10).lR();
        ii.a(im, n, n2, (double)n3).b(n7, n8, n9, n10).lR();
        ii.a(im, n4, n2, (double)n3).b(n7, n8, n9, n10).lR();
        ii.a(im, n, n2, (double)n6).b(n7, n8, n9, n10).lR();
        ii.a(im, n4, n2, (double)n6).b(n7, n8, n9, n10).lR();
        ii.a(im, n4, n2, (double)n6).b(n7, n8, n9, n10).lR();
        ii.a(im, n, n5, (double)n3).b(n7, n8, n9, n10).lR();
        ii.a(im, n, n5, (double)n3).b(n7, n8, n9, n10).lR();
        ii.a(im, n, n5, (double)n6).b(n7, n8, n9, n10).lR();
        ii.a(im, n4, n5, (double)n3).b(n7, n8, n9, n10).lR();
        ii.a(im, n4, n5, (double)n6).b(n7, n8, n9, n10).lR();
        ii.a(im, n4, n5, (double)n6).b(n7, n8, n9, n10).lR();
        ii.a(im, n4, n5, (double)n6).b(n7, n8, n9, n10).lR();
    }
    
    public static class a extends ea
    {
        @em(fS = 0)
        public eW mm;
        @er(fu = "mode", fh = "Mode", fW = "full", fm = @em(fS = 1))
        public fr.a.a mn;
        @er(fu = "fillColor", fh = "Fill Color", fW = "false/255/255/255/125", fm = @em(fS = 2))
        public eT mo;
        @em(fS = 10)
        public eW mp;
        @er(fu = "outlineThickness", fh = "Thickness", fW = "25", fm = @em(fS = 11))
        @el(fQ = 1)
        public int mq;
        @er(fu = "outlineColor", fh = "Color", fW = "false/255/255/255", fm = @em(fS = 12))
        public eT mr;
        @er(fu = "showAlways", fh = "Show always", fW = "true", fm = @em(fS = 13))
        public boolean ms;
        
        public a() {
            this.mm = new eW("General");
            this.mp = new eW("Outline");
        }
        
        public enum a
        {
            @ei(fu = "none", fh = "None")
            NONE, 
            @ei(fu = "outline", fh = "Outline")
            OUTLINE, 
            @ei(fu = "full", fh = "Full")
            FULL;
            
            private static /* synthetic */ a[] $values() {
                return new a[] { a.NONE, a.OUTLINE, a.FULL };
            }
            
            static {
                $VALUES = $values();
            }
        }
    }
}
