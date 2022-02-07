package net.digitalingot.feather;

public final class il
{
    private il() {
        throw new AssertionError();
    }
    
    public static float k(final float n) {
        final float intBitsToFloat = Float.intBitsToFloat(1419967116 - Float.floatToIntBits(n) / 3);
        final float n2 = 0.6666667f * intBitsToFloat + 1.0f / (3.0f * intBitsToFloat * intBitsToFloat * n);
        return 0.6666667f * n2 + 1.0f / (3.0f * n2 * n2 * n);
    }
}
