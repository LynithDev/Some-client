package net.digitalingot.feather;

import java.awt.*;

public class gu implements gp
{
    @Override
    public void a(final gn.a a, final int n, final int n2, final int n3, final Color color, final im im) {
        final int n4 = -a.qM / 2;
        if (a.qR) {
            go.a(im, n4 + n - a.qK - a.mq, n4 + n2 - a.qK - a.mq, n4 + n + a.qK + a.qM, n4 + n2 + a.qK + a.qM, a.qS, a.mq);
            go.a(im, n4 + n - a.qK + a.qM, n4 + n2 - a.qK + a.qM, n4 + n + a.qK - a.mq, n4 + n2 + a.qK - a.mq, a.qS, a.mq);
        }
        go.a(im, n4 + n - a.qK, n4 + n2 - a.qK, n4 + n + a.qK, n4 + n2 + a.qK, color, a.qM);
    }
}
