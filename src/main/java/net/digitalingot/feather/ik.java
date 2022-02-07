package net.digitalingot.feather;

import net.minecraft.client.renderer.*;

public final class ik
{
    private ik() {
        throw new AssertionError();
    }
    
    public static void lU() {
        GlStateManager.pushMatrix();
    }
    
    public static void lV() {
        GlStateManager.popMatrix();
    }
    
    public static void b(final float n, final float n2, final float n3) {
        a(n, n2, n3);
    }
    
    public static void a(final double n, final double n2, final double n3) {
        GlStateManager.translate(n, n2, n3);
    }
    
    public static void c(final float n, final float n2, final float n3, final float n4) {
        GlStateManager.rotate(n, n2, n3, n4);
    }
    
    public static void c(final float n, final float n2, final float n3) {
        b(n, n2, (double)n3);
    }
    
    public static void b(final double n, final double n2, final double n3) {
        GlStateManager.scale(n, n2, n3);
    }
}
