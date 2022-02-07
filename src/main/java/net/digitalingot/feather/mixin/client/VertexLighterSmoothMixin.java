package net.digitalingot.feather.mixin.client;

import net.minecraftforge.client.model.pipeline.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ VertexLighterSmoothAo.class })
public class VertexLighterSmoothMixin extends VertexLighterFlat
{
    @Overwrite(remap = false)
    protected void updateLightmap(final float[] array, final float[] array2, float n, float n2, float n3) {
        n *= 2.0f;
        n2 *= 2.0f;
        n3 *= 2.0f;
        final float n4 = n * n + n2 * n2 + n3 * n3;
        if (n4 > 5.98f) {
            final float n5 = (float)Math.sqrt(5.98f / n4);
            n *= n5;
            n2 *= n5;
            n3 *= n5;
        }
        final float n6 = (n > 0.0f) ? n : (-n);
        final float n7 = (n2 > 0.0f) ? n2 : (-n2);
        final float n8 = (n3 > 0.0f) ? n3 : (-n3);
        final float n9 = 1.0001f;
        if (n6 > 1.9999f && n7 <= n9 && n8 <= n9) {
            n = ((n < 0.0f) ? -1.9999f : 1.9999f);
        }
        else if (n7 > 1.9999f && n8 <= n9 && n6 <= n9) {
            n2 = ((n2 < 0.0f) ? -1.9999f : 1.9999f);
        }
        else if (n8 > 1.9999f && n6 <= n9 && n7 <= n9) {
            n3 = ((n3 < 0.0f) ? -1.9999f : 1.9999f);
        }
        final float n10 = (n > 0.0f) ? n : (-n);
        final float n11 = (n2 > 0.0f) ? n2 : (-n2);
        final float n12 = (n3 > 0.0f) ? n3 : (-n3);
        if (n10 <= n9 && n11 + n12 > 2.9999f) {
            final float n13 = 2.9999f / (n11 + n12);
            n2 *= n13;
            n3 *= n13;
        }
        else if (n11 <= n9 && n12 + n10 > 2.9999f) {
            final float n14 = 2.9999f / (n12 + n10);
            n3 *= n14;
            n *= n14;
        }
        else if (n12 <= n9 && n10 + n11 > 2.9999f) {
            final float n15 = 2.9999f / (n10 + n11);
            n *= n15;
            n2 *= n15;
        }
        else if (n10 + n11 + n12 > 3.9999f) {
            final float n16 = 3.9999f / (n10 + n11 + n12);
            n *= n16;
            n2 *= n16;
            n3 *= n16;
        }
        final float[][][][] blockLight = this.blockInfo.getBlockLight();
        final float[][][][] skyLight = this.blockInfo.getSkyLight();
        float n17 = 0.0f;
        float n18 = 0.0f;
        float n19 = 0.0f;
        for (int i = 0; i <= 1; ++i) {
            for (int j = 0; j <= 1; ++j) {
                for (int k = 0; k <= 1; ++k) {
                    final float n20 = n * (1 - i * 2);
                    final float n21 = n2 * (1 - j * 2);
                    final float n22 = n3 * (1 - k * 2);
                    final float n23 = n20 + n21 + n22 + 4.0f;
                    final float n24 = n21 + n22 + 3.0f;
                    final float n25 = n22 + n20 + 3.0f;
                    final float n26 = n20 + n21 + 3.0f;
                    final float n27 = (2.0f * n20 + n21 + n22 + 6.0f) / (n23 * n25 * n26 * (n20 + 2.0f));
                    final float n28 = n19 + n27;
                    final float n29 = n17 + n27 * blockLight[0][i][j][k];
                    final float n30 = n18 + n27 * skyLight[0][i][j][k];
                    final float n31 = (2.0f * n21 + n22 + n20 + 6.0f) / (n23 * n26 * n24 * (n21 + 2.0f));
                    final float n32 = n28 + n31;
                    final float n33 = n29 + n31 * blockLight[1][i][j][k];
                    final float n34 = n30 + n31 * skyLight[1][i][j][k];
                    final float n35 = (2.0f * n22 + n20 + n21 + 6.0f) / (n23 * n24 * n25 * (n22 + 2.0f));
                    n19 = n32 + n35;
                    n17 = n33 + n35 * blockLight[2][i][j][k];
                    n18 = n34 + n35 * skyLight[2][i][j][k];
                }
            }
        }
        final float n36 = n17 / n19;
        final float n37 = n18 / n19;
        array2[0] = MathHelper.clamp_float(n36, 0.0f, 0.0073243305f);
        array2[1] = MathHelper.clamp_float(n37, 0.0f, 0.0073243305f);
    }
}
