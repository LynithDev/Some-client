package net.digitalingot.feather;

public class kz
{
    private final float GK;
    private final float GL;
    private float GM;
    private final int GN;
    
    public kz(final float gk, final float gl, final float gm, final int gn) {
        this.GK = gk;
        this.GL = gl;
        this.GM = gm;
        this.GN = gn;
    }
    
    public float tY() {
        return this.GK;
    }
    
    public float tZ() {
        return this.GL;
    }
    
    public float ua() {
        return this.GM;
    }
    
    public void q(final float gm) {
        this.GM = gm;
    }
    
    public int iu() {
        return this.GN;
    }
}
