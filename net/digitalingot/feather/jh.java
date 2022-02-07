package net.digitalingot.feather;

import net.minecraft.client.renderer.vertex.*;
import java.nio.*;

public interface jh extends iZ
{
    public static final VertexFormat ER = DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP;
    
    void a(final float p0, final float p1, final float p2, final float p3, final float p4, final int p5, final int p6);
    
    public static class a extends je implements jh
    {
        public a(final jc jc) {
            super(jc, ja.EI);
        }
        
        @Override
        public void a(final float n, final float n2, final float n3, final float n4, final float n5, final int n6, final int n7) {
            final int ep = this.EP;
            final ByteBuffer eo = this.EO;
            eo.putFloat(ep, n);
            eo.putFloat(ep + 4, n2);
            eo.putFloat(ep + 8, n3);
            eo.putFloat(ep + 12, n4);
            eo.putFloat(ep + 16, n5);
            eo.putInt(ep + 20, n6);
            eo.putInt(ep + 24, n7);
            this.td();
        }
    }
    
    public static class b extends jf implements jh
    {
        public b(final jc jc) {
            super(jc, ja.EI);
        }
        
        @Override
        public void a(final float n, final float n2, final float n3, final float n4, final float n5, final int n6, final int n7) {
            final long eq = this.EQ;
            iM.a(eq, n);
            iM.a(eq + 4L, n2);
            iM.a(eq + 8L, n3);
            iM.a(eq + 12L, n4);
            iM.a(eq + 16L, n5);
            iM.a(eq + 20L, n6);
            iM.a(eq + 24L, n7);
            this.td();
        }
    }
}
