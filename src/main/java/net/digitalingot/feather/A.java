package net.digitalingot.feather;

import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;

public class A
{
    public void a(final D d, final F f) {
        final int ax = f.ax();
        final long n = d.aw() + ax % f.az() * d.ar();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.enableDepth();
        b(515);
        c(f.f(ax));
        GL15.glBindBuffer(34962, d.as());
        GL11.glVertexPointer(3, 5126, 0, 0L);
        GL11.glNormalPointer(5126, 0, d.av());
        GL11.glTexCoordPointer(2, 5126, 0, n);
        GL15.glBindBuffer(34962, 0);
        GL11.glEnableClientState(32884);
        GL11.glEnableClientState(32888);
        GL11.glEnableClientState(32885);
        GL15.glBindBuffer(34963, d.at());
        GL11.glDrawElements(4, d.au(), 5125, 0L);
        GL15.glBindBuffer(34963, 0);
        GL11.glDisableClientState(32885);
        GL11.glDisableClientState(32888);
        GL11.glDisableClientState(32884);
        GlStateManager.enableDepth();
    }
    
    private static void b(final int n) {
        GlStateManager.depthFunc(n);
    }
    
    private static void c(final int n) {
        GlStateManager.bindTexture(n);
    }
}
