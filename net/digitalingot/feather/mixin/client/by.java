package net.digitalingot.feather.mixin.client;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.inventory.*;
import net.minecraft.client.entity.*;
import net.minecraft.potion.*;
import java.util.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;

@Mixin({ InventoryEffectRenderer.class })
public abstract class by extends GuiContainer
{
    @Unique
    private static final dT<gG> HQ;
    
    public by(final Container container) {
        super(container);
    }
    
    @Redirect(method = { "updateActivePotionEffects" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/EntityPlayerSP;getActivePotionEffects()Ljava/util/Collection;", opcode = 182), require = 2, allow = 2)
    private Collection<PotionEffect> a(final EntityPlayerSP entityPlayerSP) {
        final gG gg = by.HQ.eZ();
        if (gg != null && gg.eS() && gg.dI().ve) {
            return (Collection<PotionEffect>)Collections.emptySet();
        }
        return (Collection<PotionEffect>)entityPlayerSP.func_70651_bq();
    }
    
    static {
        HQ = dU.a(gG.class);
    }
}
