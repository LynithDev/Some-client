package net.digitalingot.feather;

import java.io.*;
import java.nio.*;

public class y extends B
{
    private final int aA;
    
    public y(final B b, final int aa) {
        super(b.aF, b.aG, b.aH);
        this.aA = aa;
    }
    
    public int an() {
        return this.aA;
    }
    
    public static y a(final InputStream inputStream, final z z) {
        final int ae = z.aE;
        final B a = B.a(inputStream, true, z.aE);
        final int aq = a.aq();
        final int n = aq * 2;
        if (ae > 1) {
            final FloatBuffer ao = a.ao();
            final int ab = z.aB;
            final int ac = z.aC;
            final int ad = z.aD;
            final float n2 = 1.0f / z.textureWidth;
            final float n3 = 1.0f / z.textureHeight;
            final int n4 = aq * 3 + aq * 3;
            for (int i = ae - 1; i >= 0; --i) {
                final int n5 = n4 + i * n;
                for (int j = n - 1; j >= 0; j -= 2) {
                    final float value = ao.get(n4 + j - 1);
                    final float value2 = ao.get(n4 + j);
                    final float n6 = value * ab;
                    final float n7 = value2 * ac;
                    final int n8 = i % ad * ab;
                    final int n9 = (int)Math.floor(i / (float)ad) * ac;
                    final float n10 = (n8 + n6) * n2;
                    final float n11 = (n9 + n7) * n3;
                    ao.put(n5 + j - 1, n10);
                    ao.put(n5 + j, n11);
                }
            }
        }
        return new y(a, ae);
    }
}
