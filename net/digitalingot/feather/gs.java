package net.digitalingot.feather;

import java.awt.*;

public class gs implements gp
{
    @Override
    public void a(final gn.a a, final int n, final int n2, final int n3, final Color color, final im im) {
        final int n4 = a.qL / 2;
        final int n5 = a.qL / 2;
        if (a.qR) {
            final int n6 = a.qM / 2 + a.mq;
            final int n7 = (a.qM + 1) / 2 + a.mq;
            go.b(im, n - a.qK - n4 - a.mq, n2 - n6, n - n4 + a.mq, n2 + n7, a.qS);
            go.b(im, n + n5 - a.mq, n2 - n6, n + a.qK + n5 + a.mq, n2 + n7, a.qS);
            go.b(im, n - n6, n2 - n4 - a.qK - a.mq, n + n7, n2 - n4 + a.mq, a.qS);
            go.b(im, n - n6, n2 + n5 - a.mq, n + n7, n2 + n5 + a.qK + a.mq, a.qS);
        }
        final int n8 = a.qM / 2;
        final int n9 = (a.qM + 1) / 2;
        go.b(im, n - a.qK - n4, n2 - n8, n - n4, n2 + n9, color);
        go.b(im, n + n5, n2 - n8, n + a.qK + n5, n2 + n9, color);
        go.b(im, n - n8, n2 - n4 - a.qK, n + n9, n2 - n4, color);
        go.b(im, n - n8, n2 + n5, n + n9, n2 + n5 + a.qK, color);
    }
}
