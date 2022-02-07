package net.digitalingot.feather;

public abstract class jf extends jd
{
    protected long EQ;
    
    protected jf(final jc jc, final jn<?> jn) {
        super(jc, jn);
    }
    
    @Override
    protected void te() {
        this.EQ = iM.a(this.EK.getDirectBuffer(), this.EK.getWriterPosition());
    }
    
    @Override
    protected void td() {
        this.EQ += this.EM;
        super.td();
    }
}
