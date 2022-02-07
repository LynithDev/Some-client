package net.digitalingot.feather;

import java.awt.*;

public class gr implements gp
{
    @Override
    public void a(final gn.a a, final int n, final int n2, final int n3, final Color color, final im im) {
        float n4 = 1.0f;
        if (a.qR) {
            n4 = a.qM + (float)a.mq;
            if (n4 != 1.0f) {
                ii.j(n4);
            }
            go.a(im, n + 0.5, n2 + 0.5, n3 - a.mq / 2 + 1, a.qS);
            go.a(im, n + 0.5, n2 + 0.5, n3 + a.mq / 2 + 1, a.qS);
        }
        if (n4 != a.qM) {
            n4 = (float)a.qM;
            ii.j(n4);
        }
        go.a(im, n + 0.5, n2 + 0.5, n3 + 1, color);
        if (n4 != 1.0f) {
            ii.j(1.0f);
        }
    }
}
