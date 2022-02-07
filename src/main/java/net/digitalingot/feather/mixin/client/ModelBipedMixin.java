package net.digitalingot.feather.mixin.client;

import net.minecraft.client.model.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ ModelBiped.class })
public abstract class ModelBipedMixin extends ModelBase
{
    @Unique
    private static final dT<fq> HA;
    
    @ModifyConstant(method = { "setRotationAngles(FFFFFFLnet/minecraft/entity/Entity;)V" }, constant = { @Constant(floatValue = -0.5235988f) }, require = 1, allow = 1)
    private float z(final float n) {
        final fq fq = ModelBipedMixin.HA.eZ();
        return (fq.eS() && fq.dI().md) ? 0.0f : n;
    }
    
    static {
        HA = dU.a(fq.class);
    }
}
