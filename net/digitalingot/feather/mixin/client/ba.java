package net.digitalingot.feather.mixin.client;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.renderer.entity.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.model.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ LayerHeldItem.class })
public abstract class ba implements LayerRenderer<EntityLivingBase>
{
    @Unique
    private static final dT<fq> HA;
    @Shadow
    @Final
    private RendererLivingEntity<?> field_177206_a;
    
    @Redirect(method = { "doRenderLayer(Lnet/minecraft/entity/EntityLivingBase;FFFFFFF)V" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/model/ModelBiped;postRenderArm(F)V", ordinal = 0), require = 1, allow = 1)
    private void a(final ModelBiped modelBiped, final float n) {
    }
    
    @Redirect(method = { "doRenderLayer(Lnet/minecraft/entity/EntityLivingBase;FFFFFFF)V" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;translate(FFF)V", ordinal = 1), require = 1, allow = 1)
    private void i(final float n, final float n2, final float n3) {
    }
    
    @Inject(method = { "doRenderLayer(Lnet/minecraft/entity/EntityLivingBase;FFFFFFF)V" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;translate(FFF)V", ordinal = 1, shift = At.Shift.AFTER) }, require = 1, allow = 1)
    private void a(final EntityLivingBase entityLivingBase, final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final CallbackInfo callbackInfo) {
        if (!(entityLivingBase instanceof EntityPlayer)) {
            ((ModelBiped)this.field_177206_a.getMainModel()).postRenderArm(0.0625f);
            GlStateManager.translate(-0.0625f, 0.4375f, 0.0625f);
            return;
        }
        final fq fq = ba.HA.eZ();
        final boolean es = fq.eS();
        if (es && fq.dI().md) {
            if (((EntityPlayer)entityLivingBase).isBlocking()) {
                if (entityLivingBase.func_70093_af()) {
                    ((ModelBiped)this.field_177206_a.getMainModel()).postRenderArm(0.0325f);
                    GlStateManager.scale(1.05f, 1.05f, 1.05f);
                    GlStateManager.translate(-0.58f, 0.32f, -0.07f);
                    GlStateManager.rotate(-24405.0f, 137290.0f, -2009900.0f, -2654900.0f);
                }
                else {
                    ((ModelBiped)this.field_177206_a.getMainModel()).postRenderArm(0.0325f);
                    GlStateManager.scale(1.05f, 1.05f, 1.05f);
                    GlStateManager.translate(-0.45f, 0.25f, -0.07f);
                    GlStateManager.rotate(-24405.0f, 137290.0f, -2009900.0f, -2654900.0f);
                }
            }
            else {
                ((ModelBiped)this.field_177206_a.getMainModel()).postRenderArm(0.0625f);
            }
        }
        else {
            ((ModelBiped)this.field_177206_a.getMainModel()).postRenderArm(0.0625f);
        }
        if (!es || !fq.dI().me) {
            GlStateManager.translate(-0.0625f, 0.4375f, 0.0625f);
        }
        else {
            final boolean blocking = ((EntityPlayer)entityLivingBase).isBlocking();
            final boolean func_70093_af = entityLivingBase.func_70093_af();
            if (!blocking && !func_70093_af) {
                GlStateManager.translate(-0.0855f, 0.4775f, 0.1585f);
                GlStateManager.rotate(-19.0f, 20.0f, 0.0f, -6.0f);
            }
            else if (func_70093_af && !blocking) {
                GlStateManager.translate(-0.0525f, 0.5375f, 0.0725f);
                GlStateManager.rotate(16.0f, -8.0f, 0.0f, 5.0f);
                GlStateManager.translate(0.0f, 0.1f, 0.09523f);
            }
            else {
                GlStateManager.translate(-0.0625f, 0.4375f, 0.0625f);
            }
        }
    }
    
    static {
        HA = dU.a(fq.class);
    }
}
