package net.digitalingot.feather.mixin.client;

import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.item.*;
import net.minecraft.client.resources.model.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.client.renderer.*;
import net.digitalingot.feather.*;

@Mixin({ RenderItem.class })
public abstract class br implements IResourceManagerReloadListener
{
    @Unique
    private static final dT<fw> HL;
    @Unique
    private ItemStack HN;
    @Unique
    private int effectRenderColor;
    
    public br() {
        this.HN = null;
    }
    
    @Shadow
    public abstract void func_180454_a(final ItemStack p0, final IBakedModel p1);
    
    @Shadow
    protected abstract void func_175035_a(final IBakedModel p0, final int p1);
    
    @Inject(method = { "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/resources/model/IBakedModel;)V" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/RenderItem;renderEffect(Lnet/minecraft/client/resources/model/IBakedModel;)V", ordinal = 0) }, require = 1, allow = 1)
    private void a(final ItemStack hn, final IBakedModel bakedModel, final CallbackInfo callbackInfo) {
        this.HN = hn;
    }
    
    @Inject(method = { "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/resources/model/IBakedModel;)V" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/RenderItem;renderEffect(Lnet/minecraft/client/resources/model/IBakedModel;)V", ordinal = 0, shift = At.Shift.AFTER) }, require = 1, allow = 1)
    private void b(final ItemStack itemStack, final IBakedModel bakedModel, final CallbackInfo callbackInfo) {
        this.HN = null;
    }
    
    @Redirect(method = { "renderEffect(Lnet/minecraft/client/resources/model/IBakedModel;)V" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;depthMask(Z)V", ordinal = 0), require = 1, allow = 1)
    private void w(final boolean b) {
    }
    
    @Redirect(method = { "renderEffect(Lnet/minecraft/client/resources/model/IBakedModel;)V" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;depthFunc(I)V", ordinal = 0), require = 1, allow = 1)
    private void be(final int n) {
    }
    
    @Inject(method = { "renderEffect(Lnet/minecraft/client/resources/model/IBakedModel;)V" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;disableLighting()V", ordinal = 0) }, require = 1, allow = 1)
    private void a(final IBakedModel bakedModel, final CallbackInfo callbackInfo) {
        final fw fw = br.HL.eZ();
        if (fw == null) {
            return;
        }
        if (!fw.f(this.HN)) {
            GlStateManager.depthMask(false);
            GlStateManager.depthFunc(514);
        }
        this.effectRenderColor = (fw.eS() ? fw.d(this.HN) : -8372020);
    }
    
    @Redirect(method = { "renderEffect(Lnet/minecraft/client/resources/model/IBakedModel;)V" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/RenderItem;renderModel(Lnet/minecraft/client/resources/model/IBakedModel;I)V"), require = 2, allow = 2)
    private void a(final RenderItem renderItem, final IBakedModel bakedModel, final int n) {
        this.func_175035_a(bakedModel, this.effectRenderColor);
    }
    
    @Redirect(method = { "renderItemModelTransform(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/resources/model/IBakedModel;Lnet/minecraft/client/renderer/block/model/ItemCameraTransforms$TransformType;)V" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/RenderItem;renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/resources/model/IBakedModel;)V", ordinal = 0), require = 1, allow = 1)
    private void a(final RenderItem renderItem, final ItemStack itemStack, final IBakedModel bakedModel) {
        final fw fw = br.HL.eZ();
        if (fw == null) {
            return;
        }
        final fw.a a = fw.dI();
        final boolean nk = a.nk;
        a.nk = false;
        this.func_180454_a(itemStack, bakedModel);
        a.nk = nk;
    }
    
    static {
        HL = dU.a(fw.class);
    }
}
