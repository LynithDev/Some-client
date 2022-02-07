package net.digitalingot.feather;

import java.awt.*;
import org.lwjgl.opengl.*;

public class gq implements gp
{
    @Override
    public void a(final gn.a a, final int n, final int n2, final int n3, final Color color, final im im) {
        final boolean glIsEnabled = GL11.glIsEnabled(2848);
        if (glIsEnabled) {
            GL11.glDisable(2848);
        }
        final boolean glIsEnabled2 = GL11.glIsEnabled(2832);
        if (glIsEnabled2) {
            GL11.glDisable(2832);
        }
        ii.ly();
        ii.lH();
        float n4 = 1.0f;
        if (a.qR) {
            n4 = a.qM + (float)a.mq;
            if (n4 != 1.0f) {
                ii.j(n4);
            }
            go.a(im, n - a.qK, n2 + a.qK, n, n2, a.qS);
            go.a(im, n, n2, n + a.qK, n2 + a.qK, a.qS);
        }
        if (n4 != a.qM) {
            n4 = (float)a.qM;
            ii.j(n4);
        }
        go.a(im, n - a.qK, n2 + a.qK, n, n2, color);
        go.a(im, n, n2, n + a.qK, n2 + a.qK, color);
        if (n4 != 1.0f) {
            ii.j(1.0f);
        }
        if (glIsEnabled2) {
            GL11.glEnable(2832);
        }
        if (glIsEnabled) {
            GL11.glEnable(2848);
        }
    }
}
