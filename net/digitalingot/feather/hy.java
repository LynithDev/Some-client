package net.digitalingot.feather;

public class hy
{
    public static void a(final byte[] array, final float n) {
        if (Math.abs(n - 1.0) < 0.001) {
            return;
        }
        for (int i = 0; i < array.length; i += 2) {
            final short n2 = (short)(a(array[i], array[i + 1]) * n);
            array[i] = (byte)n2;
            array[i + 1] = (byte)(n2 >> 8);
        }
    }
    
    public static byte[] a(final byte[] array, final float n, final float n2) {
        final byte[] array2 = new byte[array.length * 2];
        for (int i = 0; i < array.length; i += 2) {
            final short a = a(array[i], array[i + 1]);
            final short n3 = (short)(a * n);
            final short n4 = (short)(a * n2);
            array2[i * 2] = (byte)n3;
            array2[i * 2 + 1] = (byte)(n3 >> 8);
            array2[i * 2 + 2] = (byte)n4;
            array2[i * 2 + 3] = (byte)(n4 >> 8);
        }
        return array2;
    }
    
    public static short a(final byte b, final byte b2) {
        return (short)((b2 & 0xFF) << 8 | (b & 0xFF));
    }
    
    public static byte[] a(final short n) {
        return new byte[] { (byte)(n & 0xFF), (byte)(n >> 8 & 0xFF) };
    }
}
