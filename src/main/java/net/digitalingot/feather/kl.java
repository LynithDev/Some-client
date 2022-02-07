package net.digitalingot.feather;

public final class kl
{
    private kl() {
        throw new AssertionError();
    }
    
    public static float f(final float n, final float n2, final float n3) {
        return Math.max(n2, Math.min(n3, n));
    }
    
    public static float o(final float n) {
        return f(n, 0.0f, 1.0f);
    }
}
