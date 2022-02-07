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
public abstract class bx
{
    @Unique
    private static final dT<fz> HP;
    @Shadow
    @Final
    private GameProfile field_178867_a;
    
    @Inject(method = { "getLocationSkin()Lnet/minecraft/util/ResourceLocation;" }, at = { @At("HEAD") }, cancellable = true)
    public void f(final CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
        final fz fz = bx.HP.eZ();
        if (fz == null || !fz.eS()) {
            return;
        }
        final fz.b b = fz.dI();
        final UUID id = this.field_178867_a.getId();
        final UUID func_110124_au = Minecraft.getMinecraft().thePlayer.func_110124_au();
        final ResourceLocation defaultSkin = DefaultPlayerSkin.getDefaultSkin(id);
        final ResourceLocation hk = fz.hk();
        if (id.equals(func_110124_au)) {
            if (b.of) {
                callbackInfoReturnable.setReturnValue((Object)((b.og && hk != null) ? hk : defaultSkin));
            }
        }
        else if (b.oh) {
            callbackInfoReturnable.setReturnValue((Object)defaultSkin);
        }
    }
    
    @Inject(method = { "getSkinType" }, at = { @At("RETURN") }, cancellable = true)
    public void g(final CallbackInfoReturnable<String> callbackInfoReturnable) {
        final fz fz = bx.HP.eZ();
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
        if (this.field_178867_a.getId().equals(Minecraft.getMinecraft().thePlayer.func_110124_au())) {
            callbackInfoReturnable.setReturnValue((Object)fz.hm());
        }
    }
    
    @Inject(method = { "getLocationCape" }, at = { @At("RETURN") }, cancellable = true)
    public void h(final CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
        if (callbackInfoReturnable.getReturnValue() != null) {
            return;
        }
        final fz fz = bx.HP.eZ();
        if (fz == null || !fz.eS()) {
            return;
        }
        final fz.b b = fz.dI();
        if (!b.of || !b.og) {
            return;
        }
        if (this.field_178867_a.getId().equals(Minecraft.getMinecraft().thePlayer.func_110124_au())) {
            callbackInfoReturnable.setReturnValue((Object)fz.hn());
        }
    }
    
    static {
        HP = dU.a(fz.class);
    }
}
