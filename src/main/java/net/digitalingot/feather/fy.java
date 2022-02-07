package net.digitalingot.feather;

import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.client.renderer.*;
import java.util.concurrent.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.resources.model.*;

@dP(eL = dW.ITEM_PHYSIC, eM = @dV(fh = "Item Physic", fi = "https://assets.feathercdn.net/game/mods/itemphysic.svg", fj = "", fk = {}))
public class fy extends dQ<a>
{
    public static final ItemCameraTransforms.TransformType nH;
    public static Minecraft nI;
    public static double nJ;
    
    public void a(final Entity entity, final float n, final double n2, final double n3, final double n4) {
        fy.nJ = System.currentTimeMillis() / 100.0 * ((a)this.jC).nK % 360.0;
        if (!fy.nI.inGameHasFocus) {
            fy.nJ = 0.0;
        }
        final EntityItem entityItem = (EntityItem)entity;
        final ItemStack entityItem2 = entityItem.getEntityItem();
        final TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
        textureManager.bindTexture(TextureMap.locationBlocksTexture);
        final ITextureObject texture = textureManager.getTexture(TextureMap.locationBlocksTexture);
        texture.setBlurMipmap(false, false);
        ii.lE();
        ii.a(516, 0.1f);
        ii.lG();
        RenderHelper.enableStandardItemLighting();
        ii.c(770, 771, 1, 0);
        ii.lU();
        final IBakedModel itemModel = fy.nI.getRenderItem().getItemModelMesher().getItemModel(entityItem2);
        final boolean gui3d = itemModel.isGui3d();
        final boolean gui3d2 = itemModel.isGui3d();
        final int g = g(entityItem2);
        ii.b((float)n2, (float)n3, (float)n4);
        if (itemModel.isGui3d()) {
            ii.c(0.5f, 0.5f, 0.5f);
        }
        itemModel.getItemCameraTransforms().applyTransform(fy.nH);
        ii.c(90.0f, 1.0f, 0.0f, 0.0f);
        ii.c(entityItem.field_70177_z, 0.0f, 0.0f, 1.0f);
        ii.a(0.0, 0.0, gui3d2 ? -0.08 : -0.04);
        if (gui3d2 || fy.nI.getRenderManager().options != null) {
            if (gui3d2) {
                if (!entityItem.field_70122_E) {
                    bn.a((Entity)entityItem, (float)fy.nJ);
                }
            }
            else if (!Double.isNaN(entityItem.field_70169_q) && !Double.isNaN(entityItem.field_70167_r) && !Double.isNaN(entityItem.field_70166_s) && entityItem.field_70170_p != null) {
                if (entityItem.field_70122_E) {
                    bn.a((Entity)entityItem, 0.0f);
                }
                else {
                    bn.a((Entity)entityItem, (float)fy.nJ);
                }
            }
            ii.c(entityItem.field_70125_A, 1.0f, 0.0f, 0.0f);
        }
        ii.a(1.0f, 1.0f, 1.0f, 1.0f);
        for (int i = 0; i < g; ++i) {
            ii.lU();
            if (gui3d) {
                if (i > 0) {
                    final ThreadLocalRandom current = ThreadLocalRandom.current();
                    ii.b((current.nextFloat() * 2.0f - 1.0f) * 0.15f, (current.nextFloat() * 2.0f - 1.0f) * 0.15f, (current.nextFloat() * 2.0f - 1.0f) * 0.15f);
                }
                fy.nI.getRenderItem().renderItem(entityItem2, itemModel);
                ii.lV();
            }
            else {
                fy.nI.getRenderItem().renderItem(entityItem2, itemModel);
                ii.lV();
                ii.b(0.0f, 0.0f, 0.05375f);
            }
        }
        ii.lV();
        ii.lF();
        ii.lH();
        textureManager.bindTexture(TextureMap.locationBlocksTexture);
        texture.restoreLastBlurMipmap();
    }
    
    public static int g(final ItemStack itemStack) {
        if (itemStack == null) {
            return 0;
        }
        final int stackSize = itemStack.stackSize;
        if (stackSize > 48) {
            return 5;
        }
        if (stackSize > 32) {
            return 4;
        }
        if (stackSize > 16) {
            return 3;
        }
        if (stackSize > 1) {
            return 2;
        }
        return 1;
    }
    
    static {
        nH = ItemCameraTransforms.TransformType.GROUND;
        fy.nI = Minecraft.getMinecraft();
    }
    
    public static class a extends ea
    {
        @er(fu = "rotateSpeed", fh = "Rotate Speed", fW = "10", fm = @em(fS = 0))
        @el
        public int nK;
    }
}
