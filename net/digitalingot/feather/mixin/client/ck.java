package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraftforge.client.model.pipeline.*;
import net.minecraft.world.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.digitalingot.feather.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ ForgeBlockModelRenderer.class })
public class ck
{
    @Redirect(method = { "render" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/util/EnumFacing;values()[Lnet/minecraft/util/EnumFacing;"))
    private static EnumFacing[] uw() {
        return jT.FR;
    }
    
    @Inject(method = { "render" }, at = { @At("RETURN") }, remap = false)
    private static void a(final VertexLighterFlat vertexLighterFlat, final IBlockAccess blockAccess, final IBakedModel bakedModel, final Block block, final BlockPos blockPos, final WorldRenderer worldRenderer, final boolean b, final CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        ((kB)vertexLighterFlat).resetBlockInfo();
    }
}
