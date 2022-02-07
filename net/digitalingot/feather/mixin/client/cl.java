package net.digitalingot.feather.mixin.client;

import net.minecraftforge.client.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraftforge.common.*;
import net.minecraft.client.settings.*;
import net.minecraft.world.biome.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ ForgeHooksClient.class })
public class cl
{
    @Shadow
    private static int skyX;
    @Shadow
    private static int skyZ;
    @Shadow
    private static boolean skyInit;
    @Shadow
    private static int skyRGBMultiplier;
    
    @Overwrite(remap = false)
    public static int getSkyBlendColour(final World world, final BlockPos blockPos) {
        if (blockPos.func_177958_n() == cl.skyX && blockPos.func_177952_p() == cl.skyZ && cl.skyInit) {
            return cl.skyRGBMultiplier;
        }
        cl.skyInit = true;
        final GameSettings gameSettings = Minecraft.getMinecraft().gameSettings;
        final int[] blendRanges = ForgeModContainer.blendRanges;
        int n = 0;
        if (gameSettings.fancyGraphics && gameSettings.renderDistanceChunks >= 0 && gameSettings.renderDistanceChunks < blendRanges.length) {
            n = blendRanges[gameSettings.renderDistanceChunks];
        }
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                final BlockPos add = blockPos.add(i, 0, j);
                final BiomeGenBase biomeGenForCoords = world.getBiomeGenForCoords(add);
                final int skyColorByTemp = biomeGenForCoords.getSkyColorByTemp(biomeGenForCoords.getFloatTemperature(add));
                n2 += (skyColorByTemp & 0xFF0000) >> 16;
                n3 += (skyColorByTemp & 0xFF00) >> 8;
                n4 += (skyColorByTemp & 0xFF);
                ++n5;
            }
        }
        final int skyRGBMultiplier = (n2 / n5 & 0xFF) << 16 | (n3 / n5 & 0xFF) << 8 | (n4 / n5 & 0xFF);
        cl.skyX = blockPos.func_177958_n();
        cl.skyZ = blockPos.func_177952_p();
        return cl.skyRGBMultiplier = skyRGBMultiplier;
    }
}
