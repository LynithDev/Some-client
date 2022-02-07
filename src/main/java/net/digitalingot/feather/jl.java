package net.digitalingot.feather;

import net.minecraft.client.renderer.vertex.*;
import java.nio.*;

public interface jl extends iZ
{
    public static final VertexFormat ER = DefaultVertexFormats.POSITION_TEX;
    
    void a(final float p0, final float p1, final float p2, final float p3, final float p4);
    
    default void e(final float n, final float n2, final float n3, final float n4) {
        this.a(n, n2, 0.0f, n3, n4);
    }
    
    public static class a extends je implements jl
    {
        public a(final jc jc) {
            super(jc, ja.EG);
        }
        
        @Override
        public void a(final float n, final float n2, final float n3, final float n4, final float n5) {
            final int ep = this.EP;
            final ByteBuffer eo = this.EO;
            eo.putFloat(ep, n);
            eo.putFloat(ep + 4, n2);
            eo.putFloat(ep + 8, n3);
            eo.putFloat(ep + 12, n4);
            eo.putFloat(ep + 16, n5);
            this.td();
        }
    }
    
    public static class b extends jf implements jl
    {
        public b(final jc jc) {
            super(jc, ja.EG);
        }
        
        @Override
        public void a(final float n, final float n2, final float n3, final float n4, final float n5) {
            final long eq = this.EQ;
            iM.a(eq, n);
            iM.a(eq + 4L, n2);
            iM.a(eq + 8L, n3);
            iM.a(eq + 12L, n4);
            iM.a(eq + 16L, n5);
            this.td();
        }
    }
}
