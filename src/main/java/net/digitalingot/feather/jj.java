package net.digitalingot.feather;

import net.minecraft.client.renderer.vertex.*;
import java.nio.*;

public interface jj extends iZ
{
    public static final VertexFormat ER = DefaultVertexFormats.POSITION;
    
    void e(final float p0, final float p1, final float p2);
    
    default void d(final float n, final float n2) {
        this.e(n, n2, 0.0f);
    }
    
    public static class a extends je implements jj
    {
        public a(final jc jc) {
            super(jc, ja.EE);
        }
        
        @Override
        public void e(final float n, final float n2, final float n3) {
            final int ep = this.EP;
            final ByteBuffer eo = this.EO;
            eo.putFloat(ep, n);
            eo.putFloat(ep + 4, n2);
            eo.putFloat(ep + 8, n3);
            this.td();
        }
    }
    
    public static class b extends jf implements jj
    {
        public b(final jc jc) {
            super(jc, ja.EE);
        }
        
        @Override
        public void e(final float n, final float n2, final float n3) {
            final long eq = this.EQ;
            iM.a(eq, n);
            iM.a(eq + 4L, n2);
            iM.a(eq + 8L, n3);
            this.td();
        }
    }
}
