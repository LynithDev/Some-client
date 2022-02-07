package net.digitalingot.feather;

import java.util.*;

public class kx
{
    private final String kC;
    private float width;
    private final float height;
    private final float Gu;
    private final float Gv;
    private final float Gw;
    private final float Gx;
    private final int Gy;
    
    public kx(final String kc, final float width, final float height, final float gu, final float gv, final float gw, final float gx, final int gy) {
        this.kC = kc;
        this.width = width;
        this.height = height;
        this.Gu = gu;
        this.Gv = gv;
        this.Gw = gw;
        this.Gx = gx;
        this.Gy = gy;
    }
    
    public float tR() {
        return this.width;
    }
    
    public void p(final float width) {
        this.width = width;
    }
    
    public float tS() {
        return this.height;
    }
    
    public int tT() {
        return this.Gy;
    }
    
    public static class a
    {
        private final int Gz;
        private final Object[] GA;
        
        public a(final String s, final float n, final float n2, final float n3, final float n4, final boolean b) {
            this.Gz = Objects.hash(s, n, n2, n3, n4, b);
            this.GA = new Object[] { s, n, n2, n3, n4, b };
        }
        
        public int tU() {
            return this.Gz;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (!(o instanceof a)) {
                return false;
            }
            final Object[] ga = this.GA;
            final Object[] ga2 = ((a)o).GA;
            if (ga == ga2) {
                return true;
            }
            if (ga == null || ga2 == null) {
                return false;
            }
            final int length = ga.length;
            if (ga2.length != length) {
                return false;
            }
            for (int i = 0; i < length; ++i) {
                if (ga[i] != ga2[i] && !ga[i].equals(ga2[i])) {
                    return false;
                }
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            return this.Gz;
        }
    }
}
