package net.digitalingot.feather;

import java.nio.*;

public abstract class je extends jd
{
    protected ByteBuffer EO;
    protected int EP;
    
    protected je(final jc jc, final jn<?> jn) {
        super(jc, jn);
    }
    
    @Override
    protected void te() {
        this.EO = this.EK.getDirectBuffer();
        this.EP = this.EK.getWriterPosition();
    }
    
    @Override
    protected void td() {
        this.EP += this.EM;
        super.td();
    }
}
