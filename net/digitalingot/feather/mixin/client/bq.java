package net.digitalingot.feather.mixin.client;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.layers.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ LayerArmorBase.class })
public abstract class bq implements LayerRenderer<EntityLivingBase>
{
    @Unique
    private static final dT<fw> HL;
    @Unique
    private ItemStack HM;
    
    public bq() {
        this.HM = null;
    }
    
    @Redirect(method = { "renderLayer(Lnet/minecraft/entity/EntityLivingBase;FFFFFFFI)V" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemArmor;getColor(Lnet/minecraft/item/ItemStack;)I", ordinal = 0), require = 1, allow = 1)
    private int a(final ItemArmor itemArmor, final ItemStack hm) {
        this.HM = hm;
        return itemArmor.getColor(hm);
    }
    
    @Redirect(method = { "renderGlint" }, slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;disableLighting()V", ordinal = 0)), at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;color(FFFF)V", ordinal = 0), require = 1, allow = 1)
    private void h(float n, float n2, float n3, float n4) {
        final fw fw = bq.HL.eZ();
        if (fw != null && fw.eS()) {
            final int d = fw.d(this.HM);
            n = (d >> 16 & 0xFF) / 255.0f;
            n2 = (d >> 8 & 0xFF) / 255.0f;
            n3 = (d & 0xFF) / 255.0f;
            n4 = (d >> 24 & 0xFF) / 255.0f;
        }
        GlStateManager.color(n, n2, n3, n4);
    }
    
    static {
        HL = dU.a(fw.class);
    }
}
