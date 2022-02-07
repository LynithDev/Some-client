package net.digitalingot.feather;

import net.minecraft.client.renderer.vertex.*;
import java.nio.*;

public interface jg extends iZ
{
    public static final VertexFormat ER = DefaultVertexFormats.OLDMODEL_POSITION_TEX_NORMAL;
    
    void a(final float p0, final float p1, final float p2, final float p3, final float p4, final int p5);
    
    public static class a extends je implements jg
    {
        public a(final jc jc) {
            super(jc, ja.EJ);
        }
        
        @Override
        public void a(final float n, final float n2, final float n3, final float n4, final float n5, final int n6) {
            final int ep = this.EP;
            final ByteBuffer eo = this.EO;
            eo.putFloat(ep, n);
            eo.putFloat(ep + 4, n2);
            eo.putFloat(ep + 8, n3);
            eo.putFloat(ep + 12, n4);
            eo.putFloat(ep + 16, n5);
            eo.putInt(ep + 20, n6);
            this.td();
        }
    }
    
    public static class b extends jf implements jg
    {
        public b(final jc jc) {
            super(jc, ja.EJ);
        }
        
        @Override
        public void a(final float n, final float n2, final float n3, final float n4, final float n5, final int n6) {
            final long eq = this.EQ;
            iM.a(eq, n);
            iM.a(eq + 4L, n2);
            iM.a(eq + 8L, n3);
            iM.a(eq + 12L, n4);
            iM.a(eq + 16L, n5);
            iM.a(eq + 20L, n6);
            this.td();
        }
    }
}
