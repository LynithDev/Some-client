package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraftforge.client.model.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ MultiLayerModel.class })
public class MultiLayerModelMixin
{
    @Redirect(method = { "process" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/util/EnumWorldBlockLayer;values()[Lnet/minecraft/util/EnumWorldBlockLayer;"))
    private EnumWorldBlockLayer[] onProcess() {
        return jT.FS;
    }
}
