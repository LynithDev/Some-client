package net.digitalingot.feather.mixin.client;

import net.minecraft.entity.player.*;
import net.minecraft.client.entity.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.world.*;
import com.mojang.authlib.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.resources.*;
import java.util.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ AbstractClientPlayer.class })
public abstract class AbstractEntityPlayerMixin extends EntityPlayer
{
    @Unique
    private static final dT<fz> HP;
    
    public AbstractEntityPlayerMixin(final World world, final GameProfile gameProfile) {
        super(world, gameProfile);
    }
    
    @Inject(method = { "getLocationSkin()Lnet/minecraft/util/ResourceLocation;" }, at = { @At("HEAD") }, cancellable = true)
    private void getSkinLocation(final CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
        final fz fz = AbstractEntityPlayerMixin.HP.eZ();
        if (fz == null || !fz.eS()) {
            return;
        }
        final fz.b b = fz.dI();
        final UUID func_110124_au = this.getUniqueID();
        final UUID func_110124_au2 = Minecraft.getMinecraft().thePlayer.getUniqueID();
        final ResourceLocation defaultSkin = DefaultPlayerSkin.getDefaultSkin(func_110124_au);
        final ResourceLocation hk = fz.hk();
        if (func_110124_au.equals(func_110124_au2)) {
            if (b.of) {
                callbackInfoReturnable.setReturnValue(b.og && hk != null ? hk : defaultSkin);
            }
        }
        else if (b.oh) {
            callbackInfoReturnable.setReturnValue(defaultSkin);
        }
    }
    
    @Inject(method = { "getSkinType" }, at = { @At("RETURN") }, cancellable = true)
    private void getSkinType(final CallbackInfoReturnable<String> callbackInfoReturnable) {
        final fz fz = AbstractEntityPlayerMixin.HP.eZ();
        if (fz == null || !fz.eS()) {
            return;
        }
        final fz.b b = fz.dI();
        if (!b.of || !b.og) {
            return;
        }
        if (fz.hk() == null) {
            return;
        }
        if (this.getUniqueID().equals(Minecraft.getMinecraft().thePlayer.getUniqueID())) {
            callbackInfoReturnable.setReturnValue(fz.hm());
        }
    }
    
    @Inject(method = { "getLocationCape" }, at = { @At("HEAD") }, cancellable = true)
    private void getCapeLocation(final CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
        if (callbackInfoReturnable.getReturnValue() != null) {
            return;
        }
        final fz fz = AbstractEntityPlayerMixin.HP.eZ();
        if (fz == null || !fz.eS()) {
            return;
        }
        final fz.b b = fz.dI();
        if (!b.of || !b.og) {
            return;
        }
        if (this.getUniqueID().equals(Minecraft.getMinecraft().thePlayer.getUniqueID())) {
            callbackInfoReturnable.setReturnValue(fz.hn());
        }
    }
    
    static {
        HP = dU.a(fz.class);
    }
}
