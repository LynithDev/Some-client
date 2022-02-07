package net.digitalingot.feather;

import net.minecraft.client.renderer.vertex.*;
import java.nio.*;

public interface ji extends iZ
{
    public static final VertexFormat ER = DefaultVertexFormats.POSITION_COLOR;
    
    void a(final float p0, final float p1, final float p2, final int p3);
    
    default void b(final float n, final float n2, final int n3) {
        this.a(n, n2, 0.0f, n3);
    }
    
    public static class a extends je implements ji
    {
        public a(final jc jc) {
            super(jc, ja.EF);
        }
        
        @Override
        public void a(final float n, final float n2, final float n3, final int n4) {
            final int ep = this.EP;
            final ByteBuffer eo = this.EO;
            eo.putFloat(ep, n);
            eo.putFloat(ep + 4, n2);
            eo.putFloat(ep + 8, n3);
            eo.putInt(ep + 12, n4);
            this.td();
        }
    }
    
    public static class b extends jf implements ji
    {
        public b(final jc jc) {
            super(jc, ja.EF);
        }
        
        @Override
        public void a(final float n, final float n2, final float n3, final int n4) {
            final long eq = this.EQ;
            iM.a(eq, n);
            iM.a(eq + 4L, n2);
            iM.a(eq + 8L, n3);
            iM.a(eq + 12L, n4);
            this.td();
        }
    }
}
