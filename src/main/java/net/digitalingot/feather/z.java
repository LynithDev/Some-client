package net.digitalingot.feather;

public class z
{
    public final int aB;
    public final int aC;
    public final int textureWidth;
    public final int textureHeight;
    public final int aD;
    public final int aE;
    
    public z(final int ab, final int ac, final int textureWidth, final int textureHeight, final int ad, final int ae) {
        this.aB = ab;
        this.aC = ac;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.aD = ad;
        this.aE = ae;
    }
    
    public static z a(final int n, final int n2, final int n3) {
        final int n4 = (int)Math.floor(n3 / (float)n);
        final int n5 = (int)Math.floor(n3 / (float)n2);
        return new z(n, n2, n4 * n, n5 * n2, n4, n4 * n5);
    }
}
