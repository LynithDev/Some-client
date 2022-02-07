package net.digitalingot.feather;

import java.awt.*;
import net.minecraft.client.renderer.vertex.*;

public class go
{
    private static ii f(final Color color) {
        final ii lp = ii.lP();
        ii.lG();
        ii.lK();
        ii.c(770, 771, 1, 0);
        return lp;
    }
    
    public static void a(final im im, final double n, final double n2, final int n3, final Color color) {
        final int red = color.getRed();
        final int green = color.getGreen();
        final int blue = color.getBlue();
        final int alpha = color.getAlpha();
        final ii f = f(color);
        f.b(ii.a.LINE_STRIP, DefaultVertexFormats.POSITION_COLOR);
        for (int i = 0; i <= 360; ++i) {
            final float n4 = (float)(i * 0.017453292519943295);
            f.a(im, n + Math.cos(n4) * n3, n2 + Math.sin(n4) * n3, 0.0).d(red, green, blue, alpha).lR();
        }
        f.lS();
        ii.lL();
        ii.lH();
    }
    
    public static void a(final im im, final int n, final int n2, final int n3, final int n4, final Color color) {
        final int red = color.getRed();
        final int blue = color.getBlue();
        final int green = color.getGreen();
        final int alpha = color.getAlpha();
        final ii f = f(color);
        f.b(ii.a.LINE_STRIP, DefaultVertexFormats.POSITION_COLOR);
        f.a(im, n, n2, 0.0).d(red, green, blue, alpha).lR();
        f.a(im, n3, n4, 0.0).d(red, green, blue, alpha).lR();
        f.lS();
        ii.lL();
        ii.lH();
    }
    
    public static void b(final im im, int n, int n2, int n3, int n4, final Color color) {
        if (n < n3) {
            final int n5 = n;
            n = n3;
            n3 = n5;
        }
        if (n2 < n4) {
            final int n6 = n2;
            n2 = n4;
            n4 = n6;
        }
        final int red = color.getRed();
        final int green = color.getGreen();
        final int blue = color.getBlue();
        final int alpha = color.getAlpha();
        final ii f = f(color);
        f.b(ii.a.QUADS, DefaultVertexFormats.POSITION_COLOR);
        f.a(im, n, n4, 0.0).d(red, green, blue, alpha).lR();
        f.a(im, n3, n4, 0.0).d(red, green, blue, alpha).lR();
        f.a(im, n3, n2, 0.0).d(red, green, blue, alpha).lR();
        f.a(im, n, n2, 0.0).d(red, green, blue, alpha).lR();
        f.lS();
        ii.lL();
        ii.lH();
    }
    
    public static void a(final im im, final int n, final int n2, final int n3, final Color color, final int n4) {
        b(im, n2, n, n3 + n4, n + n4, color);
    }
    
    public static void b(final im im, final int n, final int n2, final int n3, final Color color, final int n4) {
        b(im, n, n2, n + n4, n3 + n4, color);
    }
    
    public static void a(final im im, final int n, final int n2, final int n3, final int n4, final Color color, final int n5) {
        a(im, n2, n, n3, color, n5);
        a(im, n4, n, n3, color, n5);
        b(im, n, n2, n4, color, n5);
        b(im, n3, n2, n4, color, n5);
    }
    
    public static void a(final im im, final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        iG.sL().d(im, n, n2, n3, n4, n5, n6);
    }
    
    public static int V(final String s) {
        return iG.sM().getStringWidth(s);
    }
}
