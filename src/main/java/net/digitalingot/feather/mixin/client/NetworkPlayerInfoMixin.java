package net.digitalingot.feather.mixin.client;

import net.minecraft.client.network.*;
import com.mojang.authlib.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.resources.*;
import java.util.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ NetworkPlayerInfo.class })
public abstract class NetworkPlayerInfoMixin
{
    @Unique
    private static final dT<fz> HP;
    @Shadow
    @Final
    private GameProfile gameProfile;
    
    @Inject(method = { "getLocationSkin()Lnet/minecraft/util/ResourceLocation;" }, at = { @At("HEAD") }, cancellable = true)
    public void getSkinLocation(final CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
        final fz fz = NetworkPlayerInfoMixin.HP.eZ();
        if (fz == null || !fz.eS()) {
            return;
        }
        final fz.b b = fz.dI();
        final UUID id = this.gameProfile.getId();
        final UUID thePlayerUniqueID = Minecraft.getMinecraft().thePlayer.getUniqueID();
        final ResourceLocation defaultSkin = DefaultPlayerSkin.getDefaultSkin(id);
        final ResourceLocation hk = fz.hk();
        if (id.equals(thePlayerUniqueID)) {
            if (b.of) {
                callbackInfoReturnable.setReturnValue(((b.og && hk != null) ? hk : defaultSkin));
            }
        }
        else if (b.oh) {
            callbackInfoReturnable.setReturnValue(defaultSkin);
        }
    }
    
    @Inject(method = { "getSkinType" }, at = { @At("RETURN") }, cancellable = true)
    public void getSkinType(final CallbackInfoReturnable<String> callbackInfoReturnable) {
        final fz fz = NetworkPlayerInfoMixin.HP.eZ();
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
        if (this.gameProfile.getId().equals(Minecraft.getMinecraft().thePlayer.getUniqueID())) {
            callbackInfoReturnable.setReturnValue(fz.hm());
        }
    }
    
    @Inject(method = { "getLocationCape" }, at = { @At("RETURN") }, cancellable = true)
    public void getCapeLocation(final CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
        if (callbackInfoReturnable.getReturnValue() != null) {
            return;
        }
        final fz fz = NetworkPlayerInfoMixin.HP.eZ();
        if (fz == null || !fz.eS()) {
            return;
        }
        final fz.b b = fz.dI();
        if (!b.of || !b.og) {
            return;
        }
        if (this.gameProfile.getId().equals(Minecraft.getMinecraft().thePlayer.getUniqueID())) {
            callbackInfoReturnable.setReturnValue(fz.hn());
        }
    }
    
    static {
        HP = dU.a(fz.class);
    }
}
