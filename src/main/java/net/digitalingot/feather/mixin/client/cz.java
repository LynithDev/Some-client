package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.digitalingot.feather.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ RenderGlobal.class })
public class cz
{
    @Redirect(method = { "setupTerrain" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/util/EnumFacing;values()[Lnet/minecraft/util/EnumFacing;"))
    private EnumFacing[] uw() {
        return jT.FR;
    }
}
