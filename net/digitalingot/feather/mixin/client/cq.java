package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraftforge.client.model.*;
import net.minecraft.util.*;
import net.digitalingot.feather.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ MultiModel.Baked.class })
public class cq
{
    @Redirect(method = { "getFaceQuads" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/util/EnumFacing;values()[Lnet/minecraft/util/EnumFacing;"))
    private EnumFacing[] uz() {
        return jT.FR;
    }
}
