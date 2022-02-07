package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraftforge.client.model.animation.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ AnimationModelBase.class })
public class AnimationModelBaseMixin
{
    @Redirect(method = { "render" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/util/EnumFacing;values()[Lnet/minecraft/util/EnumFacing;"))
    private EnumFacing[] onRender() {
        return jT.FR;
    }
}
