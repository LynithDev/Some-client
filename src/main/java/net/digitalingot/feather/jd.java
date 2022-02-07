package net.digitalingot.feather;

public abstract class jd implements iZ
{
    protected final jc EK;
    protected final jb EL;
    protected final int EM;
    private int EN;
    
    protected jd(final jc ek, final jn<?> jn) {
        this.EK = ek;
        this.EL = jn.tf();
        this.EM = this.EL.getStride();
        this.te();
    }
    
    @Override
    public void aI(final int n) {
        if (this.EK.ensureBufferCapacity((this.EN + n) * this.EM)) {
            this.te();
        }
    }
    
    @Override
    public void tc() {
        this.EK.flush(this.EN, this.EL);
        this.EN = 0;
    }
    
    protected void td() {
        ++this.EN;
    }
    
    protected abstract void te();
}
