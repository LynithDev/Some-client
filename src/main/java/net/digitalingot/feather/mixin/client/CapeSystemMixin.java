package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.entity.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.digitalingot.feather.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ LayerCape.class })
public class CapeSystemMixin
{
    @Inject(method = { "doRenderLayer(Lnet/minecraft/client/entity/AbstractClientPlayer;FFFFFFF)V" }, at = { @At("HEAD") }, cancellable = true, require = 1, allow = 1)
    private void renderCape(final AbstractClientPlayer abstractClientPlayer, final float n, final float n2, final float partialTicks, final float n4, final float n5, final float n6, final float scale, final CallbackInfo callbackInfo) {
        if (abstractClientPlayer.isInvisible()) {
            return;
        }
        if (!x.az.b(abstractClientPlayer.getUniqueID())) {
            return;
        }
        callbackInfo.cancel();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, 0.0f, 0.125f);
        final double n8 = abstractClientPlayer.prevChasingPosX + (abstractClientPlayer.chasingPosX - abstractClientPlayer.prevChasingPosX) * partialTicks - (abstractClientPlayer.prevPosX + (abstractClientPlayer.posX - abstractClientPlayer.prevPosX) * partialTicks);
        final double n9 = abstractClientPlayer.prevChasingPosY + (abstractClientPlayer.chasingPosY - abstractClientPlayer.prevChasingPosY) * partialTicks - (abstractClientPlayer.prevPosY + (abstractClientPlayer.posY - abstractClientPlayer.prevPosY) * partialTicks);
        final double n10 = abstractClientPlayer.prevChasingPosZ + (abstractClientPlayer.chasingPosZ - abstractClientPlayer.prevChasingPosZ) * partialTicks - (abstractClientPlayer.prevPosZ + (abstractClientPlayer.posZ - abstractClientPlayer.prevPosZ) * partialTicks);
        final float n11 = abstractClientPlayer.prevRenderYawOffset + (abstractClientPlayer.renderYawOffset - abstractClientPlayer.prevRenderYawOffset) * partialTicks;
        final double n12 = MathHelper.sin(n11 * 0.017453292f);
        final double n13 = -MathHelper.cos(n11 * 0.017453292f);
        final float clamp_float = MathHelper.clamp_float((float)n9 * 10.0f, -6.0f, 32.0f);
        float n14 = (float)(n8 * n12 + n10 * n13) * 100.0f;
        final float n15 = (float)(n8 * n13 - n10 * n12) * 100.0f;
        if (n14 < 0.0f) {
            n14 = 0.0f;
        }
        float f4 = abstractClientPlayer.prevCameraYaw + (abstractClientPlayer.cameraYaw - abstractClientPlayer.prevCameraYaw) * partialTicks;
        float n16 = clamp_float + MathHelper.sin((abstractClientPlayer.prevDistanceWalkedModified + (abstractClientPlayer.distanceWalkedModified - abstractClientPlayer.prevDistanceWalkedModified) * partialTicks) * 6.0f) * 32.0f * f4;
        if (abstractClientPlayer.isSneaking()) {
            n16 += 25.0f;
        }
        GlStateManager.rotate(6.0f + n14 / 2.0f + n16, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(n15 / 2.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(-n15 / 2.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
        if (abstractClientPlayer.isSneaking()) {
            GlStateManager.translate(0.0f, 0.115625f, 0.0875f);
        }
        x.az.c(abstractClientPlayer.getUniqueID());
        GlStateManager.popMatrix();
    }
}
